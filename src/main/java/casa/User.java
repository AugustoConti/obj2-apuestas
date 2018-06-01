package casa;

import casa.apuestas.Apuesta;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

public class User {
    private String nombre;
    private List<Apuesta> apuestas;

    /**
     * Constructor. Recibe un Nombre (string) y una lista de apuestas
     */
    public User(String nombre, List<Apuesta> apuestas) {
        this.nombre = nombre;
        this.apuestas = apuestas;
    }

    /**
     * Recibe una apuesta. Agrega la apuesta a la lista de apuestas
     */
    public void addApuesta(Apuesta apuesta) {
        apuestas.add(apuesta);
    }

    /**
     * Recibe un mes. Retorna la suma de las ganancias de cada apuesta del mes
     */
    public BigDecimal getGanancia(Month month) {
        BigDecimal ganancia = BigDecimal.ZERO;
        for(Apuesta a : apuestas) {
            if(a.inMonth(month)) {
                ganancia = ganancia.add(a.gananciaBruta());
            }
        }
        return ganancia;
    }
}
