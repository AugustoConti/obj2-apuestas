package casa;

import casa.partido.OponenteInterface;

import java.util.List;

public interface HistorialInterface {
    int victoriasDe(OponenteInterface a, OponenteInterface b);

    int empatesEntre(OponenteInterface a, OponenteInterface b);

    int cantidadEnfrentamientos(OponenteInterface a, OponenteInterface b);

    List<String> ultimosNPartidos(OponenteInterface a, int n);
}
