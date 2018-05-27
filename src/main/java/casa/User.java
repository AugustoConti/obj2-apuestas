package casa;

import casa.apuestas.Apuesta;

import java.math.BigDecimal;
import java.util.List;

public class User {
    private String nombre;
    private List<Apuesta> apuestas;

    public User(String nombre, List<Apuesta> apuestas) {
        this.nombre = nombre;
        this.apuestas = apuestas;
    }

    public void addApuesta(Apuesta apuesta){
        apuestas.add(apuesta);
    }

    public BigDecimal getGanancia(Integer month) {
        BigDecimal ganancia = new BigDecimal(0);
        for (Apuesta a : apuestas){
            if(a.inMonth(month)) {
                try {
                    ganancia = ganancia.add(a.gananciaBruta());
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
        }
        return ganancia;
    }
}
