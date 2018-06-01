package casa.partido;

import casa.TipeableInterface;
import casa.partido.estados.EstadoPartido;

import java.time.Month;

public interface PartidoInterface {

    OponenteInterface local();

    OponenteInterface visitante();

    boolean terminado();

    boolean acierto(Ganador favorito);

    boolean inMonth(Month month);

    void cancelarApuesta(TipeableInterface apuesta) throws Exception;

    void reactivarApuesta(TipeableInterface apuesta) throws Exception;

    void nextState();

    void setState(EstadoPartido estado);

    Ganador ganador();

}
