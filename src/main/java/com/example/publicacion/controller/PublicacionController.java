package com.example.publicacion.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.publicacion.model.Comentarios;
import com.example.publicacion.model.Publicacion;
import com.example.publicacion.service.ComentarioService;
import com.example.publicacion.service.PublicacionService;

import java.util.List;
import java.util.Optional;


@RestController
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;
    
    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/publicaciones")
    public List<Publicacion> getPublicaciones() {
        return publicacionService.getPublicaciones();
    }

    @GetMapping("/publicaciones/{id}")
    public Optional<Publicacion> getPublicacionId(@PathVariable Long id) {
        return publicacionService.getPublicacionId(id);
    }

    @GetMapping("/comentarios")
    public List<Comentarios> getComentarios() {
        return comentarioService.getComentarios();
    }

    @GetMapping("/comentarios/{id}")
    public Optional<Comentarios> getComentarios(@PathVariable Long id) {
        return comentarioService.getComentarioId(id);
    }

    // private double promCalificaciones(double [] calificaciones) {
    //     //set variable para almacernar la suma de todas las calificaciones
    //     double suma = 0;
    //     //set cantidad de calificaciones
    //     int cantCalificaciones = calificaciones.length;
    //     //iterar calificaciones para obtener el total
    //     for (int i = 0; i< calificaciones.length; i++){
    //         suma = suma+calificaciones[i];
    //     }
    //     double prom = suma/cantCalificaciones;
    //     //retornar promedio (suma calificaciones / cantCalificaciones)
    //     return prom;
    // }
}
