package casa.partido;

import java.util.List;

public class Equipo implements OponenteInterface {
    private String nombre;
    private List<OponenteInterface> deportistas;

    /**
     * Constructor. Recine un nombre (string) y una lista de deportistas
     */
    Equipo(String nombre, List<OponenteInterface> deportistas) {
        this.nombre = nombre;
        this.deportistas = deportistas;
    }

    /**
     * Retorna el nombre del equipo
     */
    String getNombre() {
        return nombre;
    }

}
