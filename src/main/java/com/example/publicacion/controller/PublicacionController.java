package com.example.publicacion.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.publicacion.model.Comentarios;
import com.example.publicacion.model.Publicacion;
import com.example.publicacion.service.PublicacionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;


@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @Autowired
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

    @GetMapping
    public List<Publicacion> getPublicaciones() {
        return publicacionService.getPublicaciones();
    }

    @GetMapping("/{id}")
    public Optional<Publicacion> getPublicacionId(@PathVariable Long id) {
        return publicacionService.getPublicacionId(id);
    }
}
