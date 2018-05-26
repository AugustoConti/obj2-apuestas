package casa.partido;

import java.util.List;

public class Equipo implements IOponente {
    private String nombre;
    private List<IOponente> deportistas;

    Equipo(String nombre, List<IOponente> deportistas) {
        this.nombre = nombre;
        this.deportistas = deportistas;
    }

    String getNombre() {
        return nombre;
    }
}
