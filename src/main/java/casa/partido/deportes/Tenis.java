package casa.partido.deportes;

public class Tenis implements DeporteInterface {


    /*Retorna el nombre del deporte*/
    @Override
    public String nombre() {
        return "Tenis";
    }

    /*Retorna true si admite empate*/
    @Override
    public boolean admiteEmpate() {
        return false;
    }
}
