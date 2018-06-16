package casa;

import casa.partido.Ganador;
import casa.partido.OponenteInterface;
import casa.partido.Partido;
import casa.partido.deportes.DeporteInterface;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Historial {

    private final List<Partido> historialDePartidos;

    public Historial(List<Partido> historialDePartidos) {
        this.historialDePartidos = historialDePartidos;
    }

    private List<Partido> filtrar(Predicate<Partido> predicate) {
        return historialDePartidos.stream().filter(predicate).collect(Collectors.toList());
    }

    public List<Partido> partidosCon(DeporteInterface deporte) {
        return filtrar(p -> p.getDeporte() == deporte);
    }

    public List<Partido> partidosCon(LocalDateTime fecha) {
        return filtrar(p -> p.getFecha() == fecha);
    }

    public List<Partido> partidosCon(String lugar) {
        return filtrar(p -> Objects.equals(p.getLugar(), lugar));
    }

    public List<Partido> partidosCon(OponenteInterface oponente) {
        return filtrar(p -> p.conOponente(oponente));
    }

    private List<Partido> partidosTerminados() {
        return filtrar(Partido::terminado);
    }

    private List<Partido> enfrentamientosEntre(OponenteInterface local, OponenteInterface visitante) {
        return partidosTerminados().stream().filter(p -> p.getLocal() == local && p.getVisitante() == visitante).collect(Collectors.toList());
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
        return partidosTerminados().stream().filter(p -> p.getLocal() == oponente || p.getVisitante() == oponente)
                .sorted(Comparator.comparing(Partido::getFecha).reversed())
                .limit(cantidad)
                .collect(Collectors.toList());
    }

    public Integer cantVictoriasEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos) {
        return ultimosNPartidoDe(oponente, cantUltimosNPartidos).stream()
                .filter(p -> (p.getLocal() == oponente && p.acierto(Ganador.LOCAL))
                        || (p.getVisitante() == oponente && p.acierto(Ganador.VISITANTE)))
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