package casa.apuestas.tipos.segura.cancelada;

import java.math.BigDecimal;
import java.math.MathContext;

public class SeguraCanceladaEmpezado implements SeguraCanceladaInterface {
    /**
     * Se le cobra al usuario una penalidad del 30% del total que haya apostado.
     */
    @Override
    public BigDecimal ganancia(BigDecimal monto) {
        Float porcentajeADescontar = 30f;
        return monto.multiply(BigDecimal.valueOf(porcentajeADescontar / 100), new MathContext(2));
    }
}
