package apuestas;

import apuestas.partido.IOponente;

import java.util.List;

public class Historial implements IHistorial{

    @Override
    public int victoriasDe(IOponente a, IOponente b) {
        return 0;
    }

    @Override
    public int empatesEntre(IOponente a, IOponente b) {
        return 0;
    }

    @Override
    public int cantidadEnfrentamientos(IOponente a, IOponente b) {
        return 0;
    }

    @Override
    public List<String> ultimosNPartidos(IOponente a, int n) {
        return null;
    }
}
