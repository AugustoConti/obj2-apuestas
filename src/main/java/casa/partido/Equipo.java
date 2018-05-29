package casa.partido;

import java.util.List;

public class Equipo implements OponenteInterface {
    private String nombre;
    private List<OponenteInterface> deportistas;

    Equipo(String nombre, List<OponenteInterface> deportistas) {
        this.nombre = nombre;
        this.deportistas = deportistas;
    }

    String getNombre() {
        return nombre;
    }
}
