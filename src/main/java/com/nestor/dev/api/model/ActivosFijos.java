package com.nestor.dev.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "activos_fijos")
public class ActivosFijos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActivoFijo;
    private String codigo;
    private String descripcion;
    private int tipoActivoId;

}
