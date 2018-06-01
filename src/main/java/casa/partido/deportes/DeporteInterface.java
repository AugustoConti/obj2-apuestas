package casa.partido.deportes;

import casa.partido.Ganador;

import java.util.List;

public interface DeporteInterface {

    String nombre();

    List<Ganador> resultadosPosibles();

}
