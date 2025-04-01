package com.example.BDRemotas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombreClase;

    @ManyToOne
    @JoinColumn(name = "profesor")
    private Profesor profesor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "estudiantes_clase",
        joinColumns = @JoinColumn(name = "estudiante_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private List<Estudiante> estudiantes;

}
