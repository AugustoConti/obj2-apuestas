package casa.partido.deportes;

public class Voley implements IDeporte {
    @Override
    public String nombre() {
        return "Voley";
    }

    @Override
    public boolean admiteEmpate() {
        return false;
    }
}
