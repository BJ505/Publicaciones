package com.example.publicacion.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "publicacion")
    @JsonIgnoreProperties("comentarios")
    private List<Comentarios> comentarios = new ArrayList<Comentarios>();
    @Transient
    @JsonProperty
    private double promedio;

    //Getters and setters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaPublicacion(){
        return fechaPublicacion;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFechaPublicacion(String fecha){
        this.fechaPublicacion = fecha;
    }

    public void setComentarios(List<Comentarios> comentarios){
        this.comentarios = comentarios;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
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
