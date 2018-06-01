package casa;

import casa.partido.Ganador;
import casa.partido.OponenteInterface;
import casa.partido.PartidoInterface;

import java.util.List;
import java.util.stream.Collectors;

public class Historial implements HistorialInterface {

    private List<PartidoInterface> historialDePartidos;

    public Historial(List<PartidoInterface> historialDePartidos) {this.historialDePartidos = historialDePartidos;}

    private List<PartidoInterface> enfrentamientosEntre(OponenteInterface l, OponenteInterface v) {
        return historialDePartidos.stream().filter(p -> p.local() == l && p.visitante() == v).collect(Collectors.toList());
    }

    private List<PartidoInterface> victoriasDeLocalAVisitanteConGanador(OponenteInterface local, OponenteInterface visitante, Ganador g) {
        return enfrentamientosEntre(local, visitante).stream().filter(p -> p.acierto(g)).collect(Collectors.toList());
    }

    @Override
    public Integer cantVictoriasDe(OponenteInterface a, OponenteInterface b) {
        return victoriasDeLocalAVisitanteConGanador(a, b, Ganador.LOCAL).size()
                + victoriasDeLocalAVisitanteConGanador(b, a, Ganador.VISITANTE).size();
    }

    @Override
    public Integer cantEmpatesEntre(OponenteInterface a, OponenteInterface b) {
        return victoriasDeLocalAVisitanteConGanador(a, b, Ganador.NINGUNO).size()
                + victoriasDeLocalAVisitanteConGanador(b, a, Ganador.NINGUNO).size();
    }

    @Override
    public Integer cantidadEnfrentamientos(OponenteInterface a, OponenteInterface b) {
        return enfrentamientosEntre(a, b).size() + enfrentamientosEntre(b, a).size();
    }

    @Override
    public Integer cantVictoriasEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos) {
        // TODO Falta implementar cantVictoriasEnUltimosNPartidos
        return 2;
    }

    @Override
    public Integer cantUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos) {
        // TODO Falta implementar cantUltimosNPartidos
        return 4;
    }

    @Override
    public Integer cantEmpatesEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos) {
        // TODO Falta implementar cantEmpatesEnUltimosNPartidos
        return 1;
    }

}