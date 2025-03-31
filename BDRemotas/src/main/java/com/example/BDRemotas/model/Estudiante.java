package com.example.BDRemotas.model;

import jakarta.persistence.*;
import org.aspectj.lang.annotation.RequiredTypes;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    private String nombre;

    private String telefono;

    @ManyToOne
    @JoinColumn(name="idProfesor")
    private Profesor idProfesor;

    public Estudiante() {
    }

    public Estudiante(int codigo, String nombre, String telefono, Profesor idProfesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.idProfesor = idProfesor;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
