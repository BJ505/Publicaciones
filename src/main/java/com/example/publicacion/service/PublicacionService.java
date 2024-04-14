package com.example.publicacion.service;

import java.util.List;
import java.util.Optional;

import com.example.publicacion.model.Publicacion;

public interface PublicacionService {
    List<Publicacion> getPublicaciones();
    Optional<Publicacion> getPublicacionId(Long id);
    
}
