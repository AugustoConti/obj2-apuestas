package casa.partido.deportes;

import casa.partido.Ganador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeportesTest {

    private Deporte deporte;

    @BeforeEach
    void setUp() {
        List<Ganador> resultados = new ArrayList<>();
        deporte = new Deporte("Boxeo", resultados);
    }

    @Test
    void nombre() {
        assertEquals("Boxeo", deporte.nombre());
    }

    @Test
    void resultador() {
        assertEquals(new ArrayList<>(), deporte.resultadosPosibles());
    }

}