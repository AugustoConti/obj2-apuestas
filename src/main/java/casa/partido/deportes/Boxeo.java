package casa.partido.deportes;

public class Boxeo implements DeporteInterface {

    /*Retorna el nombre del deporte*/
    @Override
    public String nombre() {
        return "Boxeo";
    }


    /*Retorna true si admite empate*/
    @Override
    public boolean admiteEmpate() {
        return true;
    }
}
