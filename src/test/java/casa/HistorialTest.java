package casa;

import casa.partido.Ganador;
import casa.partido.OponenteInterface;
import casa.partido.PartidoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HistorialTest {

    private Historial historial;
    private OponenteInterface a;
    private OponenteInterface b;

    PartidoInterface newPartido(OponenteInterface local, OponenteInterface visitante, Ganador g){
        PartidoInterface p = mock(PartidoInterface.class);
        when(p.terminado()).thenReturn(true);
        when(p.fecha()).thenReturn(LocalDateTime.now());
        when(p.local()).thenReturn(local);
        when(p.visitante()).thenReturn(visitante);
        when(p.acierto(g)).thenReturn(true);
        return p;
    }

    @BeforeEach
    void setUp() {
        a = mock(OponenteInterface.class);
        b = mock(OponenteInterface.class);

        PartidoInterface p1 = newPartido(a, b, Ganador.LOCAL);
        PartidoInterface p2 = newPartido(b, a, Ganador.LOCAL);
        PartidoInterface p3 = newPartido(a, b, Ganador.NINGUNO);
        PartidoInterface p4 = newPartido(a, mock(OponenteInterface.class), Ganador.LOCAL);
        List<PartidoInterface> listaPartidos = Arrays.asList(p1, p2, p3, p4);

        historial = new Historial(listaPartidos);
    }

    @Test
    void cantVictoriasDe() {
        assertEquals(Integer.valueOf(1), historial.cantVictoriasDe(a, b));
    }

    @Test
    void cantEmpatesEntre() {
        assertEquals(Integer.valueOf(1), historial.cantEmpatesEntre(a, b));
    }

    @Test
    void cantidadEnfrentamientos() {
        assertEquals(Integer.valueOf(3), historial.cantidadEnfrentamientos(a, b));
    }

    @Test
    void cantVictoriasEnUltimosNPartidos() {
        assertEquals(Integer.valueOf(2), historial.cantVictoriasEnUltimosNPartidos(a, 10));
    }

    @Test
    void cantUltimosNPartidos() {
        assertEquals(Integer.valueOf(4), historial.cantUltimosNPartidos(a, 10));
    }

    @Test
    void cantEmpatesEnUltimosNPartidos() {
        assertEquals(Integer.valueOf(1), historial.cantEmpatesEnUltimosNPartidos(a, 10));
    }
}