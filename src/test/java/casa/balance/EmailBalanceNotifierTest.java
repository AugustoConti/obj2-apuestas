package casa.balance;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class EmailBalanceNotifierTest {

    @Test
    void emailBalance() {
        new EmailBalanceNotifier().emailBalance("email", 1, BigDecimal.ZERO);
    }
}