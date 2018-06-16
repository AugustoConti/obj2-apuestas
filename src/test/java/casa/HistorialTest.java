package casa;

import casa.partido.Ganador;
import casa.partido.OponenteInterface;
import casa.partido.Partido;
import casa.partido.deportes.DeporteInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HistorialTest {

    private Historial historial;
    private OponenteInterface a;
    private OponenteInterface b;
    private Partido p1;
    private Partido p2;
    private Partido p3;
    private Partido p4;

    private Partido newPartido(OponenteInterface local, OponenteInterface visitante, Ganador g) {
        Partido p = mock(Partido.class);
        when(p.terminado()).thenReturn(true);
        when(p.getFecha()).thenReturn(LocalDateTime.now());
        when(p.getLocal()).thenReturn(local);
        when(p.getVisitante()).thenReturn(visitante);
        when(p.acierto(g)).thenReturn(true);
        return p;
    }

    @BeforeEach
    void setUp() {
        a = mock(OponenteInterface.class);
        b = mock(OponenteInterface.class);

        p1 = newPartido(a, b, Ganador.LOCAL);
        p2 = newPartido(b, a, Ganador.LOCAL);
        p3 = newPartido(a, b, Ganador.NINGUNO);
        p4 = newPartido(a, mock(OponenteInterface.class), Ganador.LOCAL);
        List<Partido> listaPartidos = Arrays.asList(p1, p2, p3, p4);

        historial = new Historial(listaPartidos);
    }

    @Test
    void partidosConDeporte() {
        DeporteInterface deporte = mock(DeporteInterface.class);
        when(p1.getDeporte()).thenReturn(deporte);
        List<Partido> res = historial.partidosCon(deporte);
        assertEquals(1, res.size());
        assertTrue(res.contains(p1));
    }

    @Test
    void partidosConFecha() {
        LocalDateTime fecha = LocalDateTime.now();
        when(p2.getFecha()).thenReturn(fecha);
        List<Partido> res = historial.partidosCon(fecha);
        assertEquals(1, res.size());
        assertTrue(res.contains(p2));
    }

    @Test
    void partidosConLugar() {
        when(p3.getLugar()).thenReturn("Bernal");
        List<Partido> res = historial.partidosCon("Bernal");
        assertEquals(1, res.size());
        assertTrue(res.contains(p3));
    }

    @Test
    void partidosConOponente() {
        OponenteInterface oponente = mock(OponenteInterface.class);
        when(p4.conOponente(oponente)).thenReturn(true);
        List<Partido> res = historial.partidosCon(oponente);
        assertEquals(1, res.size());
        assertTrue(res.contains(p4));
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