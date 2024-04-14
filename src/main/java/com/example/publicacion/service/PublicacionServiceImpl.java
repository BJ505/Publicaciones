package com.example.publicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.publicacion.model.Publicacion;
import com.example.publicacion.repository.PublicacionRepository;

@Service
public class PublicacionServiceImpl implements PublicacionService {
    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public List<Publicacion> getPublicaciones() {
        return publicacionRepository.findAll();
    }

    @Override
    public Optional<Publicacion> getPublicacionId(Long id) {
       return publicacionRepository.findById(id);
    }
}
