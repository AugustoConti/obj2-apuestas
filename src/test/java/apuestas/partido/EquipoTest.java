package apuestas.partido;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {

    private Equipo lanus;

    @BeforeEach
    void setUp() {
        lanus = new Equipo("lanus", new ArrayList<>());
    }

    @Test
    void getNombre() {
        assertEquals("lanus", lanus.getNombre());
    }
}