package casa.partido.deportes;

public class Basquetball implements DeporteInterface {
    @Override
    public String nombre() {
        return "Basquetball";
    }

    @Override
    public boolean admiteEmpate() {
        return false;
    }
}
