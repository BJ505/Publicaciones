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

    @GetMapping
    public List<Publicacion> getAllPublicaciones() {
        return publicacionService.getPublicaciones();
    }

    //Traer todas las publicaciones (solo campos de la tabla PUBLICACIONES)
    @GetMapping("/publicaciones")
    public List<Publicacion> getPublicaciones() {
        return publicacionService.getPublicaciones();
    }

    //Traer una publicacion (por Id)
    @GetMapping("/publicaciones/{id}")
    public Optional<Publicacion> getPublicacionId(@PathVariable Long id) {
        return publicacionService.getPublicacionId(id);
    }

    //Traer todos los comentarios (solo campos de la tabla COMENTARIOS)
    @GetMapping("/comentarios")
    public List<Comentarios> getComentarios() {
        return comentarioService.getComentarios();
    }

    //Traer un solo comentario (por Id)
    @GetMapping("/comentarios/{id}")
    public Optional<Comentarios> getComentarios(@PathVariable Long id) {
        return comentarioService.getComentarioId(id);
    }

    
}
