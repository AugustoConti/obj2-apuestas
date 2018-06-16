package casa.partido;

import java.time.LocalDate;

class Deportista implements OponenteInterface {
    private final String nombre;
    private final String apellido;
    private final LocalDate nacimiento;
    private final String lugarNac;

    /**
     * Constructor. Recibe un nombre (string) , un apellido (string) , una fecha de nacimiento (LocalDate) y un lugar de nacimiento (string)
     */
    Deportista(String nombre, String apellido, LocalDate nacimiento, String lugarNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.lugarNac = lugarNac;
    }

    /**
     * Retorna el nombre
     */
    String getNombre() {
        return nombre;
    }

    /**
     * Retorna el apellido
     */
    String getApellido() {
        return apellido;
    }

    /**
     * Retorna la fecha de nacimiento
     */
    LocalDate getNacimiento() {
        return nacimiento;
    }

    /**
     * Retorna el lugar de nacimiento
     */
    String getLugarNac() {
        return lugarNac;
    }
}
