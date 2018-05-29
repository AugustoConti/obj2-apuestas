package casa;

import casa.partido.OponenteInterface;

import java.util.List;

public class Historial implements HistorialInterface {

    @Override
    public int victoriasDe(OponenteInterface a, OponenteInterface b) {
        return 0;
    }

    @Override
    public int empatesEntre(OponenteInterface a, OponenteInterface b) {
        return 0;
    }

    @Override
    public int cantidadEnfrentamientos(OponenteInterface a, OponenteInterface b) {
        return 0;
    }

    @Override
    public List<String> ultimosNPartidos(OponenteInterface a, int n) {
        return null;
    }
}
