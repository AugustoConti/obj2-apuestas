package casa.apuestas.tipos.segura.cancelada;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeguraCanceladaNoEmpezadoTest {

    private SeguraCanceladaNoEmpezado canceladaNoEmpezado;

    @BeforeEach
    void setUp() {
        canceladaNoEmpezado = new SeguraCanceladaNoEmpezado();
    }

    @Test
    void ganancia() {
        assertEquals(0, canceladaNoEmpezado.ganancia(BigDecimal.TEN).compareTo(new BigDecimal(-200)));
    }
}