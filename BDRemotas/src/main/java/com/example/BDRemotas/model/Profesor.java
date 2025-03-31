package com.example.BDRemotas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;
    private String nombre;

    @OneToMany(mappedBy = "idProfesor")
    private List<Estudiante> estudiantes;


    public Profesor() {
    }

    public Profesor(long id, String nombre, List<Estudiante> estudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.estudiantes = estudiantes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estudiantes=" + estudiantes +
                '}';
    }
}
