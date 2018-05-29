package casa.partido;

import casa.TipeableInterface;

public interface PartidoInterface {
    OponenteInterface local();
    OponenteInterface visitante();
    boolean terminado();
    boolean acierto(String favorito) throws Exception;
    boolean inMonth(Integer month);
    void cancelarApuesta(TipeableInterface apuesta) throws Exception;
    void reactivarApuesta(TipeableInterface apuesta) throws Exception;
}
