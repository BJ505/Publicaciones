package com.example.publicacion.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.publicacion.model.Comentarios;
import com.example.publicacion.model.Publicacion;
import com.example.publicacion.service.ComentarioService;
import com.example.publicacion.service.PublicacionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public CollectionModel<EntityModel<Publicacion>> getAllPublicaciones() {
        List<Publicacion> publicaciones = publicacionService.getPublicaciones();
        List<EntityModel<Publicacion>> publicacionResorurces = publicaciones.stream()
            .map( publicacion -> EntityModel.of(publicacion,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionId(publicacion.getId())).withSelfRel()
            ))
            .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicaciones());
        CollectionModel<EntityModel<Publicacion>> resources = CollectionModel.of(publicacionResorurces, linkTo.withRel("publicaciones"));

        return resources;
    }

    //---------PUBLICACIONES-------------
    //Traer todas las publicaciones
    @GetMapping("/publicaciones")
    public CollectionModel<EntityModel<Publicacion>> getPublicaciones() {
        List<Publicacion> publicaciones = publicacionService.getPublicaciones();
        List<EntityModel<Publicacion>> publicacionResorurces = publicaciones.stream()
            .map( publicacion -> EntityModel.of(publicacion,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionId(publicacion.getId())).withSelfRel()
            ))
            .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicaciones());
        CollectionModel<EntityModel<Publicacion>> resources = CollectionModel.of(publicacionResorurces, linkTo.withRel("publicaciones"));

        return resources;
    }

    //Traer una publicacion (por Id)
    @GetMapping("/publicaciones/{id}")
    public EntityModel<Publicacion> getPublicacionId(@PathVariable Long id) {
        Optional<Publicacion> publicacion = publicacionService.getPublicacionId(id);

        if(publicacion.isPresent()){
            return EntityModel.of(publicacion.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionId(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicaciones()).withRel("publicaciones"));
        } else{
            throw new PublicacionNotFoundException("Publicacion no encontrada con el id: " + id);
        }
    }

    @PostMapping("/publicaciones")
    public EntityModel<Publicacion> createPublicacion(@Validated @RequestBody Publicacion publicacion) {
        Publicacion createPublicacion = publicacionService.createPublicacion(publicacion);
        return EntityModel.of(createPublicacion,
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionId(createPublicacion.getId())).withSelfRel(),
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicaciones()).withRel("publicaciones"));
    }

    @PutMapping("/publicaciones/{id}")
    public EntityModel<Publicacion> updatePublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
        Publicacion updatePublicacion = publicacionService.updatePublicacion(id, publicacion);

        return EntityModel.of(updatePublicacion,
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionId(updatePublicacion.getId())).withSelfRel(),
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicaciones()).withRel("publicaciones"));
    }
    
    @DeleteMapping("/publicaciones/{id}")
    public void deletePublicacion(@PathVariable Long id) {
        publicacionService.deletePublicacion(id);
    }
    

    //---------COMENTARIOS-------------
    //Traer todos los comentarios (solo campos de la tabla COMENTARIOS)
    @GetMapping("/comentarios")
    public CollectionModel<EntityModel<Comentarios>> getComentarios() {
        List<Comentarios> comentarios = comentarioService.getComentarios();
        List<EntityModel<Comentarios>> comentariosResources = comentarios.stream()
            .map( comentario -> EntityModel.of(comentario,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getComentariosId(comentario.getId())).withSelfRel()
        ))
        .collect(Collectors.toList());
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getComentarios());
        CollectionModel<EntityModel<Comentarios>> resources = CollectionModel.of(comentariosResources, linkTo.withRel("comentarios"));

        return resources;
    }

    //Traer un solo comentario (por Id)
    @GetMapping("/comentarios/{id}")
    public EntityModel<Comentarios> getComentariosId(@PathVariable Long id) {
        Optional<Comentarios> comentario = comentarioService.getComentarioId(id);

        if(comentario.isPresent()){
            return EntityModel.of(comentario.get(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getComentariosId(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getComentarios()).withRel("comentarios"));
        }else{
            throw new PublicacionNotFoundException("Comentario no encontrado con el id: " + id);
        }
    }

    @PostMapping("/comentarios/{idPublicacion}")
    public EntityModel<Comentarios> createComentario(@PathVariable Long idPublicacion,@Validated @RequestBody Comentarios comentarios) {
        Comentarios createComentario = comentarioService.createComentario(idPublicacion,comentarios);
        return EntityModel.of(createComentario,
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionId(createComentario.getId())).withSelfRel(),
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicaciones()).withRel("comentarios"));
    }

    @PutMapping("/comentarios/{idComentario}/{idPublicacion}")
    public EntityModel<Comentarios> updateComentario(@PathVariable Long idComentario,@PathVariable Long idPublicacion, @RequestBody Comentarios comentarios) {
        Comentarios comentarioUpdate = comentarioService.updateComentario(idComentario, idPublicacion, comentarios);
        return EntityModel.of(comentarioUpdate,
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionId(comentarioUpdate.getId())).withSelfRel(),
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicaciones()).withRel("comentarios"));
    }

    @DeleteMapping("/comentarios/{id}")
    public void deleteComentarios(@PathVariable Long id) {
        comentarioService.deleteComentarios(id);
    }    
}
