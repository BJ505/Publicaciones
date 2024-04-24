package com.example.publicacion.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.publicacion.model.Publicacion;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PublicacionRepositoryTest {
    @Autowired
    private PublicacionRepository publicacionRepository;
    
    @BeforeAll
    public static void open(){
        System.out.println("Iniciando pruebas de PublicacionRepositoryTest");
    }

    @Test
    public void guardarPublicacionTest() {
        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo("Lanzamiento Liveaction AVATAR: LAST AIRBANDER");
        publicacion.setFechaPublicacion("23-04-2024");

        Publicacion result = publicacionRepository.save(publicacion);

        assertNotNull(result.getId());
        assertEquals("Lanzamiento Liveaction AVATAR: LAST AIRBANDER", result.getTitulo());
    }

    @AfterAll
    public static void close(){
        System.out.println("Han terminado todas las pruebas de PublicacionRepositoryTest");
    }
}
