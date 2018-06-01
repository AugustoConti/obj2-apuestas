package casa.partido.estados;

import casa.TipeableInterface;
import casa.partido.PartidoInterface;

public interface EstadoPartido {

    boolean terminado();

    void nextState(PartidoInterface partido);

    void cancelarApuesta(TipeableInterface apuesta) throws Exception;

    void reactivarApuesta(TipeableInterface apuesta) throws Exception;

}
