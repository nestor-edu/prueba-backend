package com.nestor.dev.api.repository;

import com.nestor.dev.api.model.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {
    @Query("select u from Persona u where u.nCarnet = ?1")
    public Optional<Persona> findByNCarnet(String nCarnet);
}
