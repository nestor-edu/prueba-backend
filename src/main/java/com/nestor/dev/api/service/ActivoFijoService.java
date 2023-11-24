package com.nestor.dev.api.service;

import com.nestor.dev.api.model.ActivosFijos;
import com.nestor.dev.api.model.Asignacion;
import com.nestor.dev.api.model.Persona;

import java.util.List;
import java.util.Optional;

public interface ActivoFijoService {

    Iterable<ActivosFijos> findAll();
    Optional<ActivosFijos> findByCodigo(String codigoId);
    ActivosFijos save(ActivosFijos activo);
    List<?> findAsignaciones();
    Asignacion saveAsignacion(int personaId, int activoId);
    Optional<Persona> findByCarnet(String carnet);
    void deleteAsignacion(int id);

}
