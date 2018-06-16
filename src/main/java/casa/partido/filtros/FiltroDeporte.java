package casa.partido.filtros;

import casa.Historial;
import casa.partido.Partido;
import casa.partido.deportes.DeporteInterface;

import java.util.List;

public class FiltroDeporte implements FiltroInterface {

    private final Historial historial;
    private final DeporteInterface deporte;

    FiltroDeporte(Historial historial, DeporteInterface deporte) {
        this.historial = historial;
        this.deporte = deporte;
    }

    @Override
    public List<Partido> filtrar() {
        return historial.partidosCon(deporte);
    }
}
