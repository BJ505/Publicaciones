package com.example.publicacion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.publicacion.model.Comentarios;
import com.example.publicacion.model.Publicacion;
import com.example.publicacion.repository.PublicacionRepository;

@Service
public class PublicacionServiceImpl implements PublicacionService {
    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public List<Publicacion> getPublicaciones() {
        List<Publicacion> getAll = publicacionRepository.findAll();
        ArrayList<Integer> calificaciones = new ArrayList<>();
        for (Publicacion element : getAll) {
            calificaciones.clear();
            for (Comentarios ele : element.getComentarios()){
                calificaciones.add(ele.getCalificacion());
            }
            element.setPromedio(promCalificaciones(calificaciones));
        }
        return getAll;
    }

    @Override
    public Optional<Publicacion> getPublicacionId(Long id) {
        Optional<Publicacion> getById = publicacionRepository.findById(id);
        ArrayList<Integer> calificaciones = new ArrayList<>();
        for (Comentarios ele : getById.get().getComentarios()){
            calificaciones.add(ele.getCalificacion());
        }
        getById.get().setPromedio(promCalificaciones(calificaciones));
        return getById;
    }

    private double promCalificaciones( ArrayList<Integer> calificaciones) {
        //set variable para almacernar la suma de todas las calificaciones
        double suma = 0;
        //set cantidad de calificaciones
        int cantCalificaciones = calificaciones.size();
        //iterar calificaciones para obtener el total
        for (int calificacion : calificaciones){
            suma = suma+calificacion;
        }
        double prom = Math.floor((suma/cantCalificaciones)*10)/10.0;
        //retornar promedio (suma calificaciones / cantCalificaciones)
        return prom;
    }
}
