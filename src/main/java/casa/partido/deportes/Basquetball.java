package casa.partido.deportes;

public class Basquetball implements DeporteInterface {

    /*Retorna el nombre del deporte*/
    @Override
    public String nombre() {
        return "Basquetball";
    }

    /*Retorna true si admite empate*/
    @Override
    public boolean admiteEmpate() {
        return false;
    }
}
