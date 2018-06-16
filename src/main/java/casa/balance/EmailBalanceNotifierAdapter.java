package casa.balance;

import casa.User;

import java.math.BigDecimal;

public class EmailBalanceNotifierAdapter implements BalanceNotifier {

    private final EmailBalanceNotifier emailBalance;

    public EmailBalanceNotifierAdapter(EmailBalanceNotifier emailBalance) {this.emailBalance = emailBalance;}

    @Override
    public void notifyBalance(User user, Integer month, BigDecimal monthlyBalance) {
        emailBalance.emailBalance(user.getEmail(), month, monthlyBalance);
    }
}
