package casa;

import casa.partido.OponenteInterface;

public interface HistorialInterface {

    Integer cantVictoriasDe(OponenteInterface a, OponenteInterface b);

    Integer cantEmpatesEntre(OponenteInterface a, OponenteInterface b);

    Integer cantidadEnfrentamientos(OponenteInterface a, OponenteInterface b);

    Integer cantVictoriasEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos);

    Integer cantUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos);

    Integer cantEmpatesEnUltimosNPartidos(OponenteInterface oponente, Integer cantUltimosNPartidos);

}
