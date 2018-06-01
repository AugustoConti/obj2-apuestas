package casa;

import casa.partido.OponenteInterface;
import casa.partido.Partido;

import java.util.List;

public interface HistorialInterface {

    int cantVictoriasDe(OponenteInterface a, OponenteInterface b);

    int cantEmpatesEntre(OponenteInterface a, OponenteInterface b);

    int cantidadEnfrentamientos(OponenteInterface a, OponenteInterface b);

    List<String> ultimosNPartidos(OponenteInterface a, int n);
}
