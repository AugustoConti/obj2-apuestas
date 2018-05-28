package casa.partido.deportes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeportesTest {

    void deporteTest(IDeporte deporte, String nombre, boolean empate){
        assertEquals(nombre, deporte.nombre());
        assertEquals(empate, deporte.admiteEmpate());
    }

    @Test
    void basquetball() {
        deporteTest(new Basquetball(), "Basquetball", false);
    }

    @Test
    void boxeo() {
        deporteTest(new Boxeo(), "Boxeo", true);
    }

    @Test
    void futbol() {
        deporteTest(new Futbol(), "Futbol", true);
    }

    @Test
    void tenis() {
        deporteTest(new Tenis(), "Tenis", false);
    }

    @Test
    void voley() {
        deporteTest(new Voley(), "Voley", false);
    }
}