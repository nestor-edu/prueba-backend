package com.nestor.dev.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "personas")
public class Persona {
    @Id
    private int idPersona;
    private String nombres;
    private String nCarnet;
    private int areasTrabajoId;

}
