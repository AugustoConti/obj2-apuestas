package casa.partido.filtros;

import casa.Historial;
import casa.partido.Partido;

import java.time.LocalDateTime;
import java.util.List;

public class FiltroFecha implements FiltroInterface {

    private final Historial historial;
    private final LocalDateTime fecha;

    FiltroFecha(Historial historial, LocalDateTime fecha) {
        this.historial = historial;
        this.fecha = fecha;
    }

    @Override
    public List<Partido> filtrar() {
        return historial.partidosCon(fecha);
    }
}
