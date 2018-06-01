package casa;

import casa.partido.Ganador;
import casa.partido.OponenteInterface;
import casa.partido.PartidoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HistorialTest {

    private Historial historial;
    private OponenteInterface a;
    private OponenteInterface b;

    @BeforeEach
    void setUp() {
        a = mock(OponenteInterface.class);
        b = mock(OponenteInterface.class);

        PartidoInterface p1 = mock(PartidoInterface.class);
        when(p1.local()).thenReturn(a);
        when(p1.visitante()).thenReturn(b);
        when(p1.acierto(Ganador.LOCAL)).thenReturn(true);

        PartidoInterface p2 = mock(PartidoInterface.class);
        when(p1.local()).thenReturn(b);
        when(p1.visitante()).thenReturn(a);
        when(p1.acierto(Ganador.LOCAL)).thenReturn(true);

        PartidoInterface p3 = mock(PartidoInterface.class);
        when(p1.local()).thenReturn(a);
        when(p1.visitante()).thenReturn(b);
        when(p1.acierto(Ganador.NINGUNO)).thenReturn(true);

        PartidoInterface p4 = mock(PartidoInterface.class);
        when(p1.local()).thenReturn(a);
        when(p1.visitante()).thenReturn(mock(OponenteInterface.class));
        when(p1.acierto(Ganador.LOCAL)).thenReturn(true);

        List<PartidoInterface> listaPartidos = Arrays.asList(p1, p2, p3, p4);

        historial = new Historial(listaPartidos);
    }

    @Test
    void cantVictoriasDe() {

       // historial.cantVictoriasDe(a, b)

    }

    @Test
    void cantEmpatesEntre() {
        // historial.cantEmpatesEntre(a, b)
    }

    @Test
    void cantidadEnfrentamientos() {
        // historial.cantidadEnfrentamientos(a, b)
    }

    @Test
    void cantVictoriasEnUltimosNPartidos() {
        //  historial.cantVictoriasEnUltimosNPartidos(a, b)
    }

    @Test
    void cantUltimosNPartidos() {
        //  historial.cantUltimosNPartidos(a, b)
    }

    @Test
    void cantEmpatesEnUltimosNPartidos() {
        //  historial.cantEmpatesEnUltimosNPartidos(a, b)
    }
}