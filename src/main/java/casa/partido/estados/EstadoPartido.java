package casa.partido.estados;

import casa.TipeableInterface;

public interface EstadoPartido {
    boolean terminado();
    void cancelarApuesta(TipeableInterface apuesta) throws Exception;
    void reactivarApuesta(TipeableInterface apuesta) throws Exception;
}
