package casa.partido.deportes;

public class Tenis implements IDeporte {
    @Override
    public String nombre() {
        return "Tenis";
    }

    @Override
    public boolean admiteEmpate() {
        return false;
    }
}
