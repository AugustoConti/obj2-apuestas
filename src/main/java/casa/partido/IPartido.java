package casa.partido;

import casa.IEstado;

public interface IPartido {
    IOponente local();
    IOponente visitante();
    boolean terminado();
    boolean acierto(String favorito);
    boolean inMonth(Integer month);
    void cancelarApuesta(IEstado apuesta) throws Exception;
    void reactivarApuesta(IEstado apuesta) throws Exception;
}
