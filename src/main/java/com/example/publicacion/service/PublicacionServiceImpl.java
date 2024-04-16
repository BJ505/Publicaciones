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
            if(!calificaciones.isEmpty()){
                element.setPromedio(promCalificaciones(calificaciones));
            }else{
                element.setPromedio(0);
            }
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
        if(!calificaciones.isEmpty()){
            getById.get().setPromedio(promCalificaciones(calificaciones));
        }else{
            getById.get().setPromedio(0);
        }
        
        return getById;
    }

    @Override
    public Publicacion createPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Override
    public Publicacion updatePublicacion(Long id, Publicacion publicacion) {
        if(publicacionRepository.existsById(id)){
            publicacion.setId(id);
            return publicacionRepository.save(publicacion);
        }else{
            return null;
        }
    }

    @Override
    public void deletePublicacion(Long id) {
        if(publicacionRepository.existsById(id)){
            publicacionRepository.deleteById(id);
        }
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
