package com.example.publicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.publicacion.model.Comentarios;
import com.example.publicacion.model.Publicacion;
import com.example.publicacion.repository.ComentariosRepository;
import com.example.publicacion.repository.PublicacionRepository;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    @Autowired
    private ComentariosRepository comentariosRepository;
    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public List<Comentarios> getComentarios() {
        return comentariosRepository.findAll();
    }

    @Override
    public Optional<Comentarios> getComentarioId(Long id) {
       return comentariosRepository.findById(id);
    }

    @Override
    public Comentarios createComentario(Long id,Comentarios comentarios) {
        if(publicacionRepository.existsById(id)){
            Publicacion publiData = publicacionRepository.getReferenceById(id);
            comentarios.setPublicacion(publiData);
            return comentariosRepository.save(comentarios);
        }else{
            return null;
        }
    }

    @Override
    public Comentarios updateComentario(Long idComentario, Long idPublicacion, Comentarios comentarios) {
        if(comentariosRepository.existsById(idComentario)){
            comentarios.setId(idComentario);
            Publicacion publiData = publicacionRepository.getReferenceById(idPublicacion);
            comentarios.setPublicacion(publiData);
            return comentariosRepository.save(comentarios);
        }else{
            return null;
        }
    }

    @Override
    public void deleteComentarios(Long id) {
        if(comentariosRepository.existsById(id)){
            comentariosRepository.deleteById(id);
        }
    }
}
