package apuestas.partido;

import java.util.List;

public class Equipo implements IOponente{
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
