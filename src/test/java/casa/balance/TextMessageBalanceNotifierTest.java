package casa.balance;

import casa.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TextMessageBalanceNotifierTest {

    @Test
    void notifyBalance() {
        new TextMessageBalanceNotifier().notifyBalance(mock(User.class), 1, BigDecimal.ZERO);
    }
}