package casa.partido.deportes;

public class Boxeo implements DeporteInterface {
    @Override
    public String nombre() {
        return "Boxeo";
    }

    @Override
    public boolean admiteEmpate() {
        return true;
    }
}
