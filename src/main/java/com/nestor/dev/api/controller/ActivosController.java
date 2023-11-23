package com.nestor.dev.api.controller;

import com.nestor.dev.api.model.ActivosFijos;
import com.nestor.dev.api.model.Asignacion;
import com.nestor.dev.api.model.ActivosPersonas;
import com.nestor.dev.api.model.Persona;
import com.nestor.dev.api.service.ActivoFijoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/activos")
public class ActivosController {
    protected final ActivoFijoService service;
    protected final ModelMapper modelMapper;

    public ActivosController(ActivoFijoService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> findByCode(@PathVariable String codigo) {
        Optional<ActivosFijos> a = service.findByCodigo(codigo);

        if (a.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(a);
    }

    @GetMapping("/asignaciones")
    public ResponseEntity<?> findAsignaciones() {
        return ResponseEntity.ok().body(service.findAsignaciones());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ActivosFijos activo) {
        ActivosFijos activoDB = service.save(activo);
        return ResponseEntity.status(HttpStatus.CREATED).body(activoDB);
    }

    @PostMapping("/asignaciones")
    public ResponseEntity<?> saveAsignacion(@RequestBody ActivosPersonas dto) {
        Optional<ActivosFijos> af = service.findByCodigo(dto.getCodigoAf());
        Optional<Persona> persona = service.findByCarnet(dto.getNCarnet());

        if (af.isEmpty() || persona.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activo fijo o persona no encontrados");
        } else {
            Asignacion asignacionDb = new Asignacion();
            asignacionDb.setPersonasId(persona.get().getIdPersona());
            asignacionDb.setActivosFijosId(af.get().getIdActivoFijo());
            service.saveAsignacion(asignacionDb);
        }

        return ResponseEntity.status(HttpStatus.OK).body(findAsignaciones());
    }

    @DeleteMapping("/asignaciones/{id}")
    public ResponseEntity<?> deleteAsignacion(@PathVariable int id) {
        service.deleteAsignacion(id);
        return ResponseEntity.noContent().build(); // 204
    }

}
