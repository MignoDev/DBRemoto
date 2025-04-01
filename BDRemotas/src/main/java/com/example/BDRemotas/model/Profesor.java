package com.example.BDRemotas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
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


    public Profesor() {
    }

    public Profesor(long id, String nombre, List<Clase> clases, List<Estudiante> estudiantes, DetalleProfesor detalleProfesor) {
        this.id = id;
        this.nombre = nombre;
        this.clases = clases;
        this.estudiantes = estudiantes;
        this.detalleProfesor = detalleProfesor;
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

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public DetalleProfesor getDetalleProfesor() {
        return detalleProfesor;
    }

    public void setDetalleProfesor(DetalleProfesor detalleProfesor) {
        this.detalleProfesor = detalleProfesor;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clases=" + clases +
                ", estudiantes=" + estudiantes +
                ", detalleProfesor=" + detalleProfesor +
                '}';
    }
}
