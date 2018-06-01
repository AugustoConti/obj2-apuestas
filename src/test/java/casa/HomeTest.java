package casa;

import casa.balance.BalanceNotifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class HomeTest {

    private Home home;
    private User u;
    private BalanceNotifier balance;

    @BeforeEach
    void setUp() {
        balance = mock(BalanceNotifier.class);
        u = mock(User.class);
        when(u.getGanancia(Month.JANUARY)).thenReturn(BigDecimal.TEN);
        List<User> lista = new ArrayList<>();
        lista.add(u);
        home = new Home(lista, mock(HistorialInterface.class), balance);
    }

    @Test
    void notifyBalance() {
        home.notifyBalance(1);
        verify(balance).notifyBalance(u, 1, BigDecimal.TEN);
    }
}