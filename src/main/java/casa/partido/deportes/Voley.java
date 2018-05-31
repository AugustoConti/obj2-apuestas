package casa.partido.deportes;

public class Voley implements DeporteInterface {

    /*Retorna el nombre del deporte*/
    @Override
    public String nombre() {
        return "Voley";
    }

    /*Retorna true si admite empate*/
    @Override
    public boolean admiteEmpate() {
        return false;
    }
}
