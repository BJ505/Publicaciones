package com.example.publicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.publicacion.model.Comentarios;

public interface ComentariosRepository extends JpaRepository<Comentarios,Long> {

    
}