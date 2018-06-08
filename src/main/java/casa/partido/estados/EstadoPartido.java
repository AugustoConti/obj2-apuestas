package casa.partido.estados;

import casa.TipeableInterface;
import casa.partido.Partido;

public interface EstadoPartido {

    Boolean terminado();

    void nextState(Partido partido);

    void cancelarApuesta(TipeableInterface apuesta) throws Exception;

    void reactivarApuesta(TipeableInterface apuesta) throws Exception;

}
