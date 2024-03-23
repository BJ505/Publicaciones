package com.example.publicacion;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


@RestController
public class PublicacionController {
    private List<Publicacion> publicaciones = new ArrayList<>();

    public PublicacionController() {
        publicaciones.add(new Publicacion(1, "Reseña del libro El Nombre del Viento", "15/03/2024", 
        Arrays.asList(
            new Comentarios("Buena reseña :)", 5),
            new Comentarios("bien, pero te equivocas con el final", 3)
            ),promCalificaciones(new double[]{5,3}) //En un futuro ver como sacar el promedio leyendo directo las calificaciones de los comentarios.
        ));
        publicaciones.add(new Publicacion(2, "¿Como están amigos?", "10/01/2024",
        Arrays.asList(
            new Comentarios("Hola, bien ¿y tu?",4),
            new Comentarios("¿qué te importa?",1)
            ),promCalificaciones(new double[]{4,1})
        ));
        publicaciones.add(new Publicacion(3, "Estudio de mercado", "12/02/2024",
        Arrays.asList(
            new Comentarios("Toda la razón, está todo muy caro",5),
            new Comentarios("a quien le importa?",1)
            ),promCalificaciones(new double[]{5,1})
        ));
        publicaciones.add(new Publicacion(4, "Anuncian segunda temporada de Avatar", "11/03/2024",
        Arrays.asList(
            new Comentarios("Best Serie",5),
            new Comentarios("me gustó pero algo le falta",4)
            ),promCalificaciones(new double[]{5,4})
        ));
    }

    private double promCalificaciones(double [] calificaciones) {
        //set variable para almacernar la suma de todas las calificaciones
        double suma = 0;
        //set cantidad de calificaciones
        int cantCalificaciones = calificaciones.length;
        //iterar calificaciones para obtener el total
        for (int i = 0; i< calificaciones.length; i++){
            suma = suma+calificaciones[i];
        }
        double prom = suma/cantCalificaciones;
        //retornar promedio (suma calificaciones / cantCalificaciones)
        return prom;
    }

    @GetMapping("/publicaciones")
    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    @GetMapping("/publicaciones/{id}")
    public Publicacion getPublicacionId(@PathVariable int id) {
        for (Publicacion publicacion : publicaciones){
            if (publicacion.getId() == id){
                return publicacion;
            }
        }
        return null;
    }
}
