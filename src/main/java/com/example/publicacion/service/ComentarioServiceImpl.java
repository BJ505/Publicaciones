package com.example.publicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.publicacion.model.Comentarios;
import com.example.publicacion.repository.ComentariosRepository;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    @Autowired
    private ComentariosRepository comentariosRepository;

    @Override
    public List<Comentarios> getComentarios() {
        return comentariosRepository.findAll();
    }

    @Override
    public Optional<Comentarios> getComentarioId(Long id) {
       return comentariosRepository.findById(id);
    }
}
