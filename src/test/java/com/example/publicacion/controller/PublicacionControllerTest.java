package com.example.publicacion.controller;

import static org.mockito.Mockito.when;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.publicacion.model.Comentarios;
import com.example.publicacion.model.Publicacion;
import com.example.publicacion.service.ComentarioServiceImpl;
import com.example.publicacion.service.PublicacionServiceImpl;

@WebMvcTest(PublicacionController.class)
public class PublicacionControllerTest {
    
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublicacionServiceImpl publicacionServiceMock;

    @MockBean
    private ComentarioServiceImpl comentarioServiceImplMock;

    @BeforeAll
    public static void open(){
        System.out.println("Iniciando pruebas de PublicControllerTest");
    }

    //Declaramos publicacion usada en los test
    Publicacion publicacion1 = new Publicacion();

    @BeforeEach
    public void initClass(){
        //seteamos valores a la instancia aplicable a todos los test
        publicacion1.setTitulo("Test Publicacion Sumativa S8");
        publicacion1.setFechaPublicacion("22-04-2024");
        publicacion1.setId(1L);
   }
    //Get all Publicaciones
    @Test
    public void getAllPublicacionesTest() throws Exception {
        Publicacion publicacion2 = new Publicacion();
        publicacion2.setTitulo("Test Publicacion Sumativa S8 2");
        publicacion2.setFechaPublicacion("23-04-2024");
        publicacion2.setId(2L);
        List<Publicacion> publicaciones = List.of(publicacion1, publicacion2);
        when(publicacionServiceMock.getPublicaciones()).thenReturn(publicaciones);

        mockMvc.perform(MockMvcRequestBuilders.get("/publicaciones"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.publicacionList.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.publicacionList[0].titulo").value("Test Publicacion Sumativa S8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.publicacionList[1].titulo").value("Test Publicacion Sumativa S8 2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.publicacionList[0].fechaPublicacion").value("22-04-2024"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.publicacionList[1].fechaPublicacion").value("23-04-2024"));
    }

    //Get all Comentarios
    @Test
    public void getAllComentariosTest() throws Exception {
        Comentarios comentario1 = new Comentarios();
        comentario1.setComentario("Yo opino que mas o menos no mas porque...");
        comentario1.setCalificacion(2);
        comentario1.setPublicacion(publicacion1);

        Comentarios comentario2 = new Comentarios();
        comentario2.setComentario("Yo opino que está super bien! porque...");
        comentario2.setCalificacion(5);
        comentario2.setPublicacion(publicacion1);

        List<Comentarios> comentarios = List.of(comentario1, comentario2);
        when(comentarioServiceImplMock.getComentarios()).thenReturn(comentarios);

        mockMvc.perform(MockMvcRequestBuilders.get("/comentarios"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.comentariosList.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.comentariosList[0].comentario").value("Yo opino que mas o menos no mas porque..."))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.comentariosList[1].comentario").value("Yo opino que está super bien! porque..."))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.comentariosList[0].calificacion").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.comentariosList[1].calificacion").value("5"));
    // }
    }

    @AfterAll
    public static void close(){
        System.out.println("Han terminado todas las pruebas de PublicControllerTest");
    }
}
