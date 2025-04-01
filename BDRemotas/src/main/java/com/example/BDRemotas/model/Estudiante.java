package com.example.BDRemotas.model;

import jakarta.persistence.*;
import org.aspectj.lang.annotation.RequiredTypes;

import java.util.List;

@Entity
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

    public Estudiante() {
    }

    public Estudiante(long id, String nombre, String telefono, Profesor profesor, List<Clase> clases) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.profesor = profesor;
        this.clases = clases;
    }

    public long getCodigo() {
        return id;
    }

    public void setCodigo(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "codigo=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", profesor=" + profesor +
                ", clases=" + clases +
                '}';
    }
}
