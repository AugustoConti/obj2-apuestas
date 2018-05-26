package casa.partido;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DeportistaTest {

    private Deportista juan;

    @BeforeEach
    void setUp() {
        juan = new Deportista("juan", "perez", LocalDate.of(1984, 5, 2), "bernal");
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
        assertEquals(LocalDate.of(1984, 5, 2), juan.getNacimiento());
    }

    @Test
    void getLugarNac() {
        assertEquals("bernal", juan.getLugarNac());
    }
}