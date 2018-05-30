package casa.partido;

import casa.TipeableInterface;
import casa.partido.estados.EstadoPartido;

public interface PartidoInterface {
    OponenteInterface local();
    OponenteInterface visitante();
    boolean terminado();
    boolean acierto(String favorito);
    boolean inMonth(Integer month);
    void cancelarApuesta(TipeableInterface apuesta) throws Exception;
    void reactivarApuesta(TipeableInterface apuesta) throws Exception;
    void nextState();
    void setState(EstadoPartido estado);
}
