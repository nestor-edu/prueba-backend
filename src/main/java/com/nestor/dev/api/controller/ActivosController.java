package com.nestor.dev.api.controller;

import com.nestor.dev.api.dtos.ActivoPersonaDTO;
import com.nestor.dev.api.exceptions.NotFoundException;
import com.nestor.dev.api.model.ActivosFijos;
import com.nestor.dev.api.model.Persona;
import com.nestor.dev.api.service.ActivoFijoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/activos")
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
    public ResponseEntity<?> findByCode(@PathVariable String codigo) throws NotFoundException {
        Optional<ActivosFijos> activoOpt = service.findByCodigo(codigo);
        if (activoOpt.isEmpty()) {
            throw new NotFoundException("Producto No encontrado");
        }
        ActivosFijos a = activoOpt.get();

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
    public ResponseEntity<?> saveAsignacion(@RequestBody ActivoPersonaDTO dto) throws NotFoundException {
        Optional<ActivosFijos> optActivo = service.findByCodigo(dto.getCodActivo());
        Optional<Persona> optPersona = service.findByCarnet(dto.getPersonaCarnet());

        return ResponseEntity.status(HttpStatus.CREATED).
                body(service.saveAsignacion(optPersona.get().getIdPersona(), optActivo.get().getIdActivoFijo()));
    }

    @DeleteMapping("/asignaciones/{id}")
    public ResponseEntity<?> deleteAsignacion(@PathVariable int id) {
        service.deleteAsignacion(id);
        return ResponseEntity.noContent().build(); // 204
    }

}
