package apuestas.juego;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DeportistaTest {

    private Deportista juan;

    @BeforeEach
    void setUp() {
        juan = new Deportista("juan", "perez", LocalDate.of(1984, 5, 2), "Bernal");
    }

    @Test
    void getNombre() {
        assertEquals("juan", juan.getNombre());
    }

    @Test
    void getApellido() {
        assertEquals("perez", juan.getApellido());
    }

    @Test
    void getNacimiento() {
    }

    @Test
    void getLugarNac() {
    }
}