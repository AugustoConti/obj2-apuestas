package casa;

import casa.apuestas.Apuesta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Juan", new ArrayList<>());
    }

    @Test
    void getGanancia() {
        Apuesta ap1 = mock(Apuesta.class);
        when(ap1.inMonth(any(Month.class))).thenReturn(true);
        when(ap1.gananciaBruta()).thenReturn(BigDecimal.TEN);
        user.addApuesta(ap1);

        Apuesta ap2 = mock(Apuesta.class);
        when(ap2.inMonth(any(Month.class))).thenReturn(true);
        when(ap2.gananciaBruta()).thenReturn(BigDecimal.ZERO);
        user.addApuesta(ap2);

        assertEquals(0, user.getGanancia(Month.JANUARY).compareTo(BigDecimal.TEN));
    }
}