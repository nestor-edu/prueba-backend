package com.nestor.dev.api.service;

import com.nestor.dev.api.model.ActivosFijos;
import com.nestor.dev.api.model.Asignacion;
import com.nestor.dev.api.model.Persona;
import com.nestor.dev.api.repository.ActivoFijoRepository;
import com.nestor.dev.api.repository.AsignacionesRepository;
import com.nestor.dev.api.repository.PersonaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ActivosServiceImpl implements ActivoFijoService{

    protected final ActivoFijoRepository activosRepository;
    protected final AsignacionesRepository asignacionesRepository;
    protected final PersonaRepository personaRepository;

    public ActivosServiceImpl(
            ActivoFijoRepository activosRepository, AsignacionesRepository asignacionesRepository, PersonaRepository personaRepository) {
        this.activosRepository = activosRepository;
        this.asignacionesRepository = asignacionesRepository;
        this.personaRepository = personaRepository;
    }

    @Override
    public Iterable<ActivosFijos> findAll() {
        return activosRepository.findAll();
    }

    @Override
    public Optional<ActivosFijos> findByCodigo(String codigoId) {
        return activosRepository.findByCodigo(codigoId);
    }

    @Override
    public ActivosFijos save(ActivosFijos activo) {
        return activosRepository.save(activo);
    }

    @Override
    public List<?> findAsignaciones() {
        return activosRepository.findAsignaciones();
    }

    @Override
    public Asignacion saveAsignacion(int personaId, int activoId) {
        Asignacion asignacion = new Asignacion();
        asignacion.setPersonasId(personaId);
        asignacion.setActivosFijosId(activoId);
        return asignacionesRepository.save(asignacion);
    }

    @Override
    public Optional<Persona> findByCarnet(String carnet) {
        return personaRepository.findByNCarnet(carnet);
    }

    @Override
    @Transactional
    public void deleteAsignacion(int id) {
        asignacionesRepository.deleteById(id);
    }


}
