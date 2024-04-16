package com.example.publicacion.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.publicacion.model.Comentarios;
import com.example.publicacion.model.Publicacion;
import com.example.publicacion.service.ComentarioService;
import com.example.publicacion.service.PublicacionService;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




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

    //---------PUBLICACIONES-------------
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

    @PostMapping("/publicaciones")
    public Publicacion createPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionService.createPublicacion(publicacion);
    }

    @PutMapping("/publicaciones/{id}")
    public Publicacion updatePublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
        return publicacionService.updatePublicacion(id, publicacion);
    }
    
    @DeleteMapping("/publicaciones/{id}")
    public void deletePublicacion(@PathVariable Long id) {
        publicacionService.deletePublicacion(id);
    }
    

    //---------COMENTARIOS-------------
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

    @PostMapping("/comentarios/{idPublicacion}")
    public Comentarios createComentario(@PathVariable Long idPublicacion,@RequestBody Comentarios comentarios) {
        return comentarioService.createComentario(idPublicacion,comentarios);
    }

    @PutMapping("/comentarios/{idComentario}/{idPublicacion}")
    public Comentarios updateComentario(@PathVariable Long idComentario,@PathVariable Long idPublicacion, @RequestBody Comentarios comentarios) {
        return comentarioService.updateComentario(idComentario,idPublicacion, comentarios);
    }

    @DeleteMapping("/comentarios/{id}")
    public void deleteComentarios(@PathVariable Long id) {
        comentarioService.deleteComentarios(id);
    }    
}
