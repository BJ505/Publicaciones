package com.example.publicacion.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.publicacion.model.Comentarios;
import com.example.publicacion.model.Publicacion;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComentariosRepositoryTest {
    @Autowired
    private ComentariosRepository comentariosRepository;

    @BeforeAll
    public static void open(){
        System.out.println("Iniciando pruebas de ComentariosRepositoryTest");
    }
    
    @Test
    public void testGuardarComentarios(){
        Publicacion publicacion = new Publicacion();
        //Publicacion de id (tipo long) 2
        publicacion.setId(2L);
        Comentarios comentario = new Comentarios();
        comentario.setComentario("Me gusto bastante");
        comentario.setCalificacion(4);
        comentario.setPublicacion(publicacion);

        Comentarios result = comentariosRepository.save(comentario);

        assertNotNull(result.getId());
        assertEquals("Me gusto bastante", result.getComentario());
    }

    @AfterAll
    public static void close(){
        System.out.println("Han terminado todas las pruebas de ComentariosRepositoryTest");
    }
}
