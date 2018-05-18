package apuestas.juego;

import java.util.List;

class Equipo {
    private String nombre;
    private List<Deportista> deportistas;

    Equipo(String nombre, List<Deportista> deportistas) {
        this.nombre = nombre;
        this.deportistas = deportistas;
    }

    String getNombre() {
        return nombre;
    }
}
