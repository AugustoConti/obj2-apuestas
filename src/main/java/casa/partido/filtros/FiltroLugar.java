package casa.partido.filtros;

import casa.Historial;
import casa.partido.Partido;

import java.util.List;

public class FiltroLugar implements Filtrable {

    private final Historial historial;
    private final String lugar;

    FiltroLugar(Historial historial, String lugar) {
        this.historial = historial;
        this.lugar = lugar;
    }

    @Override
    public List<Partido> filtrar() {
        return historial.partidosCon(lugar);
    }
}
