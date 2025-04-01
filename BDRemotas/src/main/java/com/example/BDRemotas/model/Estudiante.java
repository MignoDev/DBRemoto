package com.example.BDRemotas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.lang.annotation.RequiredTypes;

import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String telefono;

    @ManyToOne
    @JoinColumn(name="profesor")
    private Profesor profesor;

    @ManyToMany(mappedBy = "estudiantes")
    private List<Clase> clases;

}
