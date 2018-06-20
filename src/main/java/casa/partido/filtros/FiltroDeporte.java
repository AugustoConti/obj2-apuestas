package casa.partido.filtros;

import casa.Historial;
import casa.partido.Deporte;
import casa.partido.Partido;

import java.util.List;

public class FiltroDeporte implements Filtrable {

    private final Historial historial;
    private final Deporte deporte;

    FiltroDeporte(Historial historial, Deporte deporte) {
        this.historial = historial;
        this.deporte = deporte;
    }

    @Override
    public List<Partido> filtrar() {
        return historial.partidosCon(deporte);
    }
}
