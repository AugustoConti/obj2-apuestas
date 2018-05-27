package casa.partido.deportes;

public class Basquetball implements IDeporte {
    @Override
    public String nombre() {
        return "Basquetball";
    }

    @Override
    public boolean admiteEmpate() {
        return false;
    }
}
