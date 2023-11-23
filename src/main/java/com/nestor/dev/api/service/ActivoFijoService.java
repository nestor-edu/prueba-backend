package com.nestor.dev.api.service;

import com.nestor.dev.api.model.ActivosFijos;
import com.nestor.dev.api.model.Asignacion;
import com.nestor.dev.api.model.Persona;

import java.util.List;
import java.util.Optional;

public interface ActivoFijoService {

    public Iterable<ActivosFijos> findAll();
    public Optional<ActivosFijos> findByCodigo(String codigoId);
    public ActivosFijos save(ActivosFijos activo);
    public List<?> findAsignaciones();
    public Asignacion saveAsignacion(Asignacion asignacion);
    public Optional<Persona> findByCarnet(String carnet);
    public void deleteAsignacion(int id);

}
