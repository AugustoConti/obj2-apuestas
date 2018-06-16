package casa.partido.filtros;

import casa.Historial;
import casa.partido.Deporte;
import casa.partido.Ganador;
import casa.partido.OponenteInterface;
import casa.partido.Partido;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class FiltrosGeneralTest {

    private final Deporte futbol = mock(Deporte.class);
    private final Deporte voley = mock(Deporte.class);
    private final OponenteInterface estudiantes = mock(OponenteInterface.class);
    private final OponenteInterface river = mock(OponenteInterface.class);
    private final OponenteInterface lanus = mock(OponenteInterface.class);
    private final LocalDateTime fecha1 = LocalDateTime.now();
    private final Partido p1 = new Partido(futbol, estudiantes, lanus, fecha1, "Bernal", Ganador.LOCAL);
    private final Partido p2 = new Partido(futbol, estudiantes, lanus, fecha1, "Quilmes", Ganador.VISITANTE);
    private final Partido p3 = new Partido(futbol, estudiantes, lanus, fecha1, "LP", Ganador.NINGUNO);
    private final Partido p4 = new Partido(futbol, estudiantes, river, fecha1, "Bernal", Ganador.LOCAL);
    private final Partido p5 = new Partido(voley, river, lanus, fecha1, "Quilmes", Ganador.LOCAL);
    private final Historial historial = new Historial(new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5)));

    @Test
    void filtroDeporteVoley() {
        List<Partido> res = new FiltroDeporte(historial, voley).filtrar();
        assertEquals(1, res.size());
        assertTrue(res.contains(p5));
    }

    @Test
    void filtroDeporteANDLugar() {
        List<Partido> res = new FiltroAND(new FiltroDeporte(historial, futbol), new FiltroLugar(historial, "Quilmes")).filtrar();
        assertEquals(1, res.size());
        assertTrue(res.contains(p2));
    }

    @Test
    void filtroDeporteANDOponente() {
        List<Partido> res = new FiltroAND(new FiltroDeporte(historial, futbol), new FiltroOponente(historial, lanus)).filtrar();
        assertEquals(3, res.size());
        assertTrue(res.containsAll(Arrays.asList(p1, p2, p3)));
    }

    @Test
    void filtroDeporteANDLugarORLugar() {
        List<Partido> res = new FiltroAND(new FiltroDeporte(historial, futbol),
                new FiltroOR(new FiltroLugar(historial, "Quilmes"),
                        new FiltroLugar(historial, "Bernal"))).filtrar();
        assertEquals(3, res.size());
        assertTrue(res.containsAll(Arrays.asList(p1, p2, p4)));
    }

    @Test
    void filtroCombineAndOr() {
        List<Partido> res = new FiltroOR(
                new FiltroAND(new FiltroLugar(historial, "Quilmes"),
                        new FiltroAND(new FiltroOponente(historial, estudiantes),
                                new FiltroOponente(historial, lanus))),
                new FiltroAND(new FiltroLugar(historial, "Bernal"),
                        new FiltroAND(new FiltroOponente(historial, estudiantes),
                                new FiltroOponente(historial, river)))).filtrar();
        assertEquals(2, res.size());
        assertTrue(res.containsAll(Arrays.asList(p2, p4)));
    }
}
