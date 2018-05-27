package casa.partido;

import casa.ITipeable;

public interface IPartido {
    IOponente local();
    IOponente visitante();
    boolean terminado();
    boolean acierto(String favorito) throws Exception;
    boolean inMonth(Integer month);
    void cancelarApuesta(ITipeable apuesta) throws Exception;
    void reactivarApuesta(ITipeable apuesta) throws Exception;
}
