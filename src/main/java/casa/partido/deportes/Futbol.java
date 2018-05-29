package casa.partido.deportes;

public class Futbol implements DeporteInterface {
    @Override
    public String nombre() {
        return "Futbol";
    }

    @Override
    public boolean admiteEmpate() {
        return true;
    }
}
