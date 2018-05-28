package casa.partido;

import casa.ITipeable;
import casa.partido.deportes.IDeporte;
import casa.partido.estados.EstadoPartido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PartidoTest {

    private IPartido partido;
    private IOponente local;
    private IOponente visitante;
    private EstadoPartido estado;
    private IDeporte deporte;

    @BeforeEach
    void setUp() {
        local = mock(IOponente.class);
        visitante = mock(IOponente.class);
        estado = mock(EstadoPartido.class);
        deporte = mock(IDeporte.class);
        when(estado.terminado()).thenReturn(true);
        partido = new Partido(deporte, local, visitante,
                LocalDateTime.of(2018, 5,25,10,0), "Bernal",
                "E", estado);
    }

    @Test
    void local() {
        assertEquals(local, partido.local());
    }

    @Test
    void visitante() {
        assertEquals(visitante, partido.visitante());
    }

    @Test
    void terminado() {
        assertTrue(partido.terminado());
    }

    @Test
    void aciertoTrue() {
        when(deporte.admiteEmpate()).thenReturn(true);
        try {
            assertTrue(partido.acierto("E"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void aciertoFalse() {
        when(deporte.admiteEmpate()).thenReturn(true);
        try {
            assertFalse(partido.acierto("V"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void aciertoThrow() {
        when(deporte.admiteEmpate()).thenReturn(false);
        try {
            assertFalse(partido.acierto("E"));
            fail();
        } catch(Exception e) {
            //e.printStackTrace();
        }
    }

    @Test
    void inMonthTrue() {
        assertTrue(partido.inMonth(5));
    }

    @Test
    void inMonthFalse() {
        assertFalse(partido.inMonth(1));
    }

    @Test
    void cancelarApuesta() {
        try {
            ITipeable apuesta = mock(ITipeable.class);
            partido.cancelarApuesta(apuesta);
            verify(estado).cancelarApuesta(apuesta);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void reactivarApuesta() {
        try {
            ITipeable apuesta = mock(ITipeable.class);
            partido.reactivarApuesta(apuesta);
            verify(estado).reactivarApuesta(apuesta);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}