package casa.balance;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EmailBalanceNotifierTest {

    @Test
    void emailBalance() {
        new EmailBalanceNotifier().emailBalance("email", 1, BigDecimal.ZERO);
    }
}