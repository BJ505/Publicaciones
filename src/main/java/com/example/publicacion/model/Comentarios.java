package com.example.publicacion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comentarios")
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="comentario")
    private String comentario;
    @Column(name="Calificacion")
    private int calificacion;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "publicacion_id")
    private Publicacion publicacion;
    //Getters and setters
    public Long getId() {
        return id;
    }
    public String getComentario() {
        return comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public void setPublicacion(Publicacion publicacion){
        this.publicacion = publicacion;
    }
}
