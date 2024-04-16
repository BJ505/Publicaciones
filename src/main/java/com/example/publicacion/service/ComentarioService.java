package com.example.publicacion.service;

import java.util.List;
import java.util.Optional;

import com.example.publicacion.model.Comentarios;

public interface ComentarioService {
    List<Comentarios> getComentarios();
    Optional<Comentarios> getComentarioId(Long id);
    Comentarios createComentario(Long id,Comentarios comentarios);
    Comentarios updateComentario(Long idComentario, Long idPublicacion, Comentarios comentarios);
    void deleteComentarios(Long id);
}
