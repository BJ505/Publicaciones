package com.example.publicacion;

public class Comentarios {
    private String comentario;
    private int calificacion;

    public Comentarios(String comentario, int calificacion) {
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    //Getters
    public String getComentario() {
        return comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

}
