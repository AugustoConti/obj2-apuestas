package casa.balance;

import casa.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EmailBalanceNotifierAdapterTest {

    @Test
    void notifyBalance() {
        EmailBalanceNotifier emailBalance = mock(EmailBalanceNotifier.class);
        User user = mock(User.class);
        when(user.email()).thenReturn("mail");
        new EmailBalanceNotifierAdapter(emailBalance).notifyBalance(user, 1, BigDecimal.TEN);
        verify(emailBalance).emailBalance("mail", 1, BigDecimal.TEN);
    }
}