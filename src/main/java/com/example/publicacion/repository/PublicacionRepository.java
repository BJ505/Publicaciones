package com.example.publicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.publicacion.model.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion,Long> {

    
}
