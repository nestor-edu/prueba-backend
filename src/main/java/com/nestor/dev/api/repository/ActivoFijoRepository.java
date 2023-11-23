package com.nestor.dev.api.repository;

import com.nestor.dev.api.model.ActivosFijos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ActivoFijoRepository extends CrudRepository<ActivosFijos, Integer> {

    Optional<ActivosFijos> findByCodigo(String codigo);

    @Query(
            nativeQuery = true,
            value = "select id_asignaciones, nombres, nombre as area, codigo, descripcion from activos_fijos af join activo_fijo.asignaciones a on af.id_activo_fijo = a.activos_fijos_id join activo_fijo.personas p on p.id_persona =\n" +
                    "a.personas_id join activo_fijo.areas_trabajo t on t.id_areas_trabajo = p.areas_trabajo_id;"
    )
    List<?> findAsignaciones();



}
