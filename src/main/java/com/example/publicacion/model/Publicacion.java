package com.example.publicacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="titulo")
    private String titulo;
    @Column(name="fechaPublicacion")
    private String fechaPublicacion;

    //Getters and setters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // public Publicacion(int id, String titulo, String fechaPublicacion, List<Comentarios> comentarios, double calificacionPromedio) {
    //     this.id = id;
    //     this.titulo = titulo;
    //     this.fechaPublicacion = fechaPublicacion;
    //     this.comentarios = comentarios;
    //     this.calificacionPromedio = calificacionPromedio;
    // }

    // //Getters
    // public int getId() {
    //     return id;
    // }

    // public String getTitulo() {
    //     return titulo;
    // }

    // public String getFechaPublicacion() {
    //     return fechaPublicacion;
    // }

    // public List<Comentarios> getComentarios() {
    //     return comentarios;
    // }

    // public double getCalificacionPromedio(){
    //     return calificacionPromedio;
    // }
}
