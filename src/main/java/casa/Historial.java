package casa;

import casa.partido.Ganador;
import casa.partido.OponenteInterface;
import casa.partido.PartidoInterface;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Historial implements HistorialInterface {

    private List<PartidoInterface> historialDePartidos;

    public Historial(List<PartidoInterface> historialDePartidos) {this.historialDePartidos = historialDePartidos;}

    private List<PartidoInterface> partidosTerminados() {
        return historialDePartidos.stream().filter(p -> p.terminado()).collect(Collectors.toList());
    }

    private List<PartidoInterface> enfrentamientosEntre(OponenteInterface l, OponenteInterface v) {
        return partidosTerminados().stream().filter(p -> p.local() == l && p.visitante() == v).collect(Collectors.toList());
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

    private List<PartidoInterface> ultimosNPartidoDe(OponenteInterface oponente, Integer cantidad){
        return partidosTerminados().stream().filter(p -> p.local() == oponente || p.visitante() == oponente)
                .sorted(Comparator.comparing(PartidoInterface::fecha).reversed())
                .limit(cantidad)
                .collect(Collectors.toList());
    }

    @Override
    public Integer cantVictoriasEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos) {
        return ultimosNPartidoDe(oponente, cantUltimosNPartidos).stream()
                .filter(p -> (p.local() == oponente && p.acierto(Ganador.LOCAL))
                             || (p.visitante() == oponente && p.acierto(Ganador.VISITANTE)))
                .collect(Collectors.toList()).size();
    }

    @Override
    public Integer cantUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos) {
        return ultimosNPartidoDe(oponente, cantUltimosNPartidos).size();
    }

    @Override
    public Integer cantEmpatesEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos) {
        return ultimosNPartidoDe(oponente, cantUltimosNPartidos).stream()
                .filter(p -> p.acierto(Ganador.NINGUNO))
                .collect(Collectors.toList()).size();
    }

}