package casa;

import casa.apuestas.Apuesta;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

public class User {
    private String nombre;
    private String email;
    private List<Apuesta> apuestas;

    /**
     * Constructor. Recibe un Nombre, un email y una lista de apuestas
     */
    public User(String nombre, String email, List<Apuesta> apuestas) {
        this.nombre = nombre;
        this.email = email;
        this.apuestas = apuestas;
    }

    public String email() { return this.email; }

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
        return apuestas.stream().filter(apuesta -> apuesta.inMonth(month)).map(Apuesta::gananciaBruta).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
