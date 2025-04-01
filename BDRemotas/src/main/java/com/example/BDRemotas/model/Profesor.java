package com.example.BDRemotas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;
    private String nombre;

    @OneToMany(mappedBy = "profesor")
    private List<Clase> clases;

    @OneToMany(mappedBy = "profesor")
    private List<Estudiante> estudiantes;

    @OneToOne
    @JoinColumn(name = "DetalleProfesor")
    private DetalleProfesor detalleProfesor;

}
