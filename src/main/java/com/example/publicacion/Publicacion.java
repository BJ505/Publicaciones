package com.example.publicacion;

import java.util.List;

public class Publicacion {
    private int id;
    private String titulo;
    private String fechaPublicacion;
    private List<Comentarios> comentarios;
    private double calificacion;



    public Publicacion(int id, String titulo, String fechaPublicacion, List<Comentarios> comentarios, double calificacion) {
        this.id = id;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.comentarios = comentarios;
        this.calificacion = calificacion;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public double getCalificacion(){
        return calificacion;
    }
}
