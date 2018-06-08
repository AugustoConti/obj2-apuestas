package casa;

import casa.partido.Ganador;
import casa.partido.OponenteInterface;
import casa.partido.Partido;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Historial {

    private List<Partido> historialDePartidos;

    public Historial(List<Partido> historialDePartidos) {
        this.historialDePartidos = historialDePartidos;
    }

    private List<Partido> partidosTerminados() {
        return historialDePartidos.stream().filter(Partido::terminado).collect(Collectors.toList());
    }

    private List<Partido> enfrentamientosEntre(OponenteInterface local, OponenteInterface visitante) {
        return partidosTerminados().stream().filter(p -> p.local() == local && p.visitante() == visitante).collect(Collectors.toList());
    }

    private List<Partido> resultadoDe(OponenteInterface local, OponenteInterface visitante, Ganador g) {
        return enfrentamientosEntre(local, visitante).stream().filter(p -> p.acierto(g)).collect(Collectors.toList());
    }

    private List<Partido> victoriasDe(OponenteInterface a, OponenteInterface b) {
        List<Partido> ret = resultadoDe(a, b, Ganador.LOCAL);
        ret.addAll(resultadoDe(b, a, Ganador.VISITANTE));
        return ret;
    }

    public Integer cantVictoriasDe(OponenteInterface a, OponenteInterface b) {
        return victoriasDe(a, b).size();
    }

    public Integer cantEmpatesEntre(OponenteInterface a, OponenteInterface b) {
        return resultadoDe(a, b, Ganador.NINGUNO).size()
                + resultadoDe(b, a, Ganador.NINGUNO).size();
    }

    public Integer cantidadEnfrentamientos(OponenteInterface a, OponenteInterface b) {
        return enfrentamientosEntre(a, b).size() + enfrentamientosEntre(b, a).size();
    }

    private List<Partido> ultimosNPartidoDe(OponenteInterface oponente, Integer cantidad) {
        return partidosTerminados().stream().filter(p -> p.local() == oponente || p.visitante() == oponente)
                .sorted(Comparator.comparing(Partido::fecha).reversed())
                .limit(cantidad)
                .collect(Collectors.toList());
    }

    public Integer cantVictoriasEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos) {
        return ultimosNPartidoDe(oponente, cantUltimosNPartidos).stream()
                .filter(p -> (p.local() == oponente && p.acierto(Ganador.LOCAL))
                        || (p.visitante() == oponente && p.acierto(Ganador.VISITANTE)))
                .collect(Collectors.toList()).size();
    }

    public Integer cantUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos) {
        return ultimosNPartidoDe(oponente, cantUltimosNPartidos).size();
    }

    public Integer cantEmpatesEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos) {
        return ultimosNPartidoDe(oponente, cantUltimosNPartidos).stream()
                .filter(p -> p.acierto(Ganador.NINGUNO))
                .collect(Collectors.toList()).size();
    }

}