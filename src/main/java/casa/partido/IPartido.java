package casa.partido;

public interface IPartido {
    IOponente local();
    IOponente visitante();
    boolean inMonth(Integer month);
}
