package casa;

import casa.partido.OponenteInterface;
import casa.partido.Partido;

public interface HistorialInterface {

    void addPartido(Partido partido);

    int cantVictoriasDe(OponenteInterface a, OponenteInterface b);

    int cantEmpatesEntre(OponenteInterface a, OponenteInterface b);

    int cantidadEnfrentamientos(OponenteInterface a, OponenteInterface b);

    int cantVictoriasEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos);

    int cantUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos);

    int cantEmpatesEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos);

}
