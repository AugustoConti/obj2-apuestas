package apuestas.juego;

import java.time.LocalDate;

class Deportista {
    private String nombre;
    private String apellido;
    private LocalDate nacimiento;
    private String lugarNac;

    Deportista(String nombre, String apellido, LocalDate nacimiento, String lugarNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.lugarNac = lugarNac;
    }

    String getNombre() {
        return nombre;
    }

    String getApellido() {
        return apellido;
    }

    LocalDate getNacimiento() {
        return nacimiento;
    }

    String getLugarNac() {
        return lugarNac;
    }
}
