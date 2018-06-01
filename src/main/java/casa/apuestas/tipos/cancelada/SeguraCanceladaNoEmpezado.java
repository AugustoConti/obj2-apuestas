package casa.apuestas.tipos.cancelada;

import java.math.BigDecimal;

public class SeguraCanceladaNoEmpezado implements CanceladaInterface {
    /**
     * Se le cobra al usuario una penalidad fija de $200
     */
    @Override
    public BigDecimal ganancia(BigDecimal monto) {
        return new BigDecimal(-200);
    }
}
