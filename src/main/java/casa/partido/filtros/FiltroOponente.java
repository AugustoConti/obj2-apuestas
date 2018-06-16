package casa.partido.filtros;

import casa.Historial;
import casa.partido.OponenteInterface;
import casa.partido.Partido;

import java.util.List;

public class FiltroOponente implements FiltroInterface {

    private final Historial historial;
    private final OponenteInterface oponente;

    FiltroOponente(Historial historial, OponenteInterface oponente) {
        this.historial = historial;
        this.oponente = oponente;
    }

    @Override
    public List<Partido> filtrar() {
        return historial.partidosCon(oponente);
    }
}
