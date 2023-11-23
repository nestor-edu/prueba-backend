package com.nestor.dev.api.repository;

import com.nestor.dev.api.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AsignacionesRepository extends CrudRepository<Asignacion, Integer> {

}
