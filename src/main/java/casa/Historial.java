package casa;
import java.util.ArrayList;
import java.util.stream.Collectors;


import casa.partido.Ganador;
import casa.partido.OponenteInterface;
import casa.partido.Partido;

import java.util.List;


public class Historial implements HistorialInterface {


    private List<Partido> historialDePartidos = null;

    public void addPartido(Partido partido) {
        historialDePartidos.add(partido);
    }

    @Override
    public int cantVictoriasDe(OponenteInterface a, OponenteInterface b) {
        return victoriasDeLocalAVisitanteConGanador(a, b, Ganador.LOCAL).size()
                + victoriasDeLocalAVisitanteConGanador(b, a, Ganador.VISITANTE).size();
    }

    @Override
    public int cantEmpatesEntre(OponenteInterface a, OponenteInterface b) {
        return victoriasDeLocalAVisitanteConGanador(a, b, Ganador.NINGUNO).size()
                + victoriasDeLocalAVisitanteConGanador(b, a, Ganador.NINGUNO).size();
    }

    @Override
    public int cantidadEnfrentamientos(OponenteInterface a, OponenteInterface b) {
        return enfrentamientosEntre(a, b).size() + enfrentamientosEntre(b, a).size()
                ;
    }

    @Override
    public List<String> ultimosNPartidos(OponenteInterface a, int n) {
        List<Partido> nPartidos = historialDePartidos.stream().filter(
                p -> p.local() == a || p.visitante() == a).collect(Collectors.toList());
        return nPartidos;
    }


    private List<Partido> enfrentamientosEntre(OponenteInterface local, OponenteInterface visitante) {
        List<Partido> enfrentamientos = historialDePartidos.stream().filter(
                p -> p.local() == local && p.visitante() == visitante).collect(Collectors.toList());
        return enfrentamientos;

    }

    private List<Partido> victoriasDeLocalAVisitanteConGanador(OponenteInterface local, OponenteInterface visitante, Ganador ganador) {
        List<Partido> victoriasDe = enfrentamientosEntre(local, visitante).stream().filter(
                p -> p.acierto(ganador)).collect(Collectors.toList());
        return victoriasDe;
    }

}