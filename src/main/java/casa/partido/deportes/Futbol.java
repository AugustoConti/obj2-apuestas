package casa.partido.deportes;

public class Futbol implements DeporteInterface {

    /*Retorna el nombre del deporte*/
    @Override
    public String nombre() {
        return "Futbol";
    }

    /*Retorna true si admite empate*/
    @Override
    public boolean admiteEmpate() {
        return true;
    }
}
