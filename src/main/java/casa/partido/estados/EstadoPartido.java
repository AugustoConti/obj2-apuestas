package casa.partido.estados;

import casa.IEstado;

public interface EstadoPartido {
    boolean terminado();
    void cancelarApuesta(IEstado apuesta) throws Exception;
    void reactivarApuesta(IEstado apuesta) throws Exception;
}
