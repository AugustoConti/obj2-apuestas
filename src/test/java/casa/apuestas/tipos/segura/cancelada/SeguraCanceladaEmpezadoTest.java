package casa.apuestas.tipos.segura.cancelada;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeguraCanceladaEmpezadoTest {

    private SeguraCanceladaEmpezado canceladaEmpezado;

    @BeforeEach
    void setUp() {
        canceladaEmpezado = new SeguraCanceladaEmpezado();
    }

    @Test
    void ganancia() {
        assertEquals(0, canceladaEmpezado.ganancia(BigDecimal.TEN).compareTo(new BigDecimal(3)));
    }
}