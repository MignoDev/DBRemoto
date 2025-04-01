package com.example.BDRemotas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
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

    public Clase() {
    }

    public Clase(long id, String nombreClase, Profesor profesor, List<Estudiante> estudiantes) {
        this.id = id;
        this.nombreClase = nombreClase;
        this.profesor = profesor;
        this.estudiantes = estudiantes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "id=" + id +
                ", nombreClase='" + nombreClase + '\'' +
                ", profesor=" + profesor +
                ", estudiantes=" + estudiantes +
                '}';
    }
}
