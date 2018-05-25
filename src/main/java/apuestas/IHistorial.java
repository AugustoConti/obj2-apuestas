package apuestas;

import apuestas.partido.IOponente;

import java.util.List;

public interface IHistorial {
    int victoriasDe(IOponente a, IOponente b);
    int empatesEntre(IOponente a, IOponente b);
    int cantidadEnfrentamientos(IOponente a, IOponente b);
    List<String> ultimosNPartidos(IOponente a, int n);
}
