package casa.apuestas.tipos.cancelada;

import casa.apuestas.Evento;
import casa.partido.Ganador;

import java.math.BigDecimal;
import java.math.MathContext;

public class SeguraCanceladaEmpezado implements CanceladaInterface {
    /**
     * Se le cobra al usuario una penalidad del 30% del total que haya apostado.
     */
    @Override
    public BigDecimal ganancia(Evento evento, Ganador favorito, BigDecimal monto) {
        Float porcentajeADescontar = 30f;
        return monto.multiply(BigDecimal.valueOf(porcentajeADescontar / 100), new MathContext(2));
    }
}
