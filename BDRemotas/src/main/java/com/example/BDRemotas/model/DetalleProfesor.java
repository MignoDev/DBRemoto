package com.example.BDRemotas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class DetalleProfesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String especialidad;
    @OneToOne(mappedBy = "detalleProfesor")
    private Profesor profesor;
}
