package com.example.BDRemotas.model;

import jakarta.persistence.*;

@Entity
public class DetalleProfesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String especialidad;
    @OneToOne(mappedBy = "detalleProfesor")
    private Profesor profesor;

    public DetalleProfesor() {
    }

    public DetalleProfesor(long id, String especialidad, Profesor profesor) {
        this.id = id;
        this.especialidad = especialidad;
        this.profesor = profesor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "DetalleProfesor{" +
                "id=" + id +
                ", especialidad='" + especialidad + '\'' +
                ", profesor=" + profesor +
                '}';
    }
}
