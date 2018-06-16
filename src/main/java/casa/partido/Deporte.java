package casa.partido;

import java.util.List;

public class Deporte {

    private final String nombre;
    private final List<Ganador> resultadosPosibles;

    public Deporte(String nombre, List<Ganador> resultadosPosibles) {
        this.nombre = nombre;
        this.resultadosPosibles = resultadosPosibles;
    }

    public String nombre() {
        return this.nombre;
    }

    public List<Ganador> resultadosPosibles() {
        return this.resultadosPosibles;
    }
}
