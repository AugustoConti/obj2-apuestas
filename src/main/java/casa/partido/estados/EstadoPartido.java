package casa.partido.estados;

import casa.ITipeable;

public interface EstadoPartido {
    boolean terminado();
    void cancelarApuesta(ITipeable apuesta) throws Exception;
    void reactivarApuesta(ITipeable apuesta) throws Exception;
}
