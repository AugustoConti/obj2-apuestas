package casa.partido.deportes;

import casa.partido.Ganador;

import java.util.List;

public class Deporte implements DeporteInterface {

    private final String nombre;
    private final List<Ganador> resultadosPosibles;

    public Deporte(String nombre, List<Ganador> resultadosPosibles) {
        this.nombre = nombre;
        this.resultadosPosibles = resultadosPosibles;
    }

    @Override
    public String nombre() {
        return this.nombre;
    }

    @Override
    public List<Ganador> resultadosPosibles() {
        return this.resultadosPosibles;
    }
}
