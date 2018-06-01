package casa;

import casa.partido.OponenteInterface;
import casa.partido.Partido;
import casa.partido.PartidoInterface;

public interface HistorialInterface {

    int cantVictoriasDe(OponenteInterface a, OponenteInterface b);

    int cantEmpatesEntre(OponenteInterface a, OponenteInterface b);

    int cantidadEnfrentamientos(OponenteInterface a, OponenteInterface b);

    int cantVictoriasEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos);

    int cantUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos);

    int cantEmpatesEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos);

}
