package casa;

import casa.partido.Ganador;
import casa.partido.OponenteInterface;
import casa.partido.PartidoInterface;

import java.util.List;
import java.util.stream.Collectors;

public class Historial implements HistorialInterface {

    private List<PartidoInterface> historialDePartidos;

    public Historial(List<PartidoInterface> historialDePartidos) {this.historialDePartidos = historialDePartidos;}

    private List<PartidoInterface> enfrentamientosEntre(OponenteInterface local, OponenteInterface visitante) {
        return historialDePartidos.stream().filter(
                p -> p.local() == local && p.visitante() == visitante).collect(Collectors.toList());
    }

    private List<PartidoInterface> victoriasDeLocalAVisitanteConGanador(OponenteInterface local, OponenteInterface visitante, Ganador ganador) {
        return enfrentamientosEntre(local, visitante).stream().filter(
                p -> p.acierto(ganador)).collect(Collectors.toList());
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
        return enfrentamientosEntre(a, b).size() + enfrentamientosEntre(b, a).size();
    }

    @Override
    public int cantVictoriasEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos) {
        return 0;
    }

    @Override
    public int cantUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos) {
        return 0;
    }

    @Override
    public int cantEmpatesEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos) {
        return 0;
    }

}