package com.nestor.dev.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "asignaciones")
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsignaciones;
    private int personasId;
    private int activosFijosId;
}
