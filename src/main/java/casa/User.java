package casa;

import casa.apuestas.Apuesta;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

public class User {
    private String nombre;
    private List<Apuesta> apuestas;

    public User(String nombre, List<Apuesta> apuestas) {
        this.nombre = nombre;
        this.apuestas = apuestas;
    }

    public void addApuesta(Apuesta apuesta) {
        apuestas.add(apuesta);
    }

    public BigDecimal getGanancia(Month month) {
        BigDecimal ganancia = new BigDecimal(0);
        for (Apuesta a : apuestas) {
            if (a.inMonth(month)) {
                ganancia = ganancia.add(a.gananciaBruta());
            }
        }
        return ganancia;
    }
}
