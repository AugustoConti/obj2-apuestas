package casa;

import casa.balance.BalanceNotifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class CasaDeApuestasTest {

    private CasaDeApuestas casaDeApuestas;
    private User u;
    private BalanceNotifier balance;

    @BeforeEach
    void setUp() {
        balance = mock(BalanceNotifier.class);
        u = mock(User.class);
        when(u.getGanancia(Month.JANUARY)).thenReturn(BigDecimal.TEN);
        List<User> lista = new ArrayList<>();
        lista.add(u);
        casaDeApuestas = new CasaDeApuestas(lista,balance);
    }

    @Test
    void notifyBalance() {
        casaDeApuestas.notifyBalance(1);
        verify(balance).notifyBalance(u, 1, BigDecimal.TEN);
    }
}