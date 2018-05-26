package casa.balance;

import casa.User;

import java.math.BigDecimal;

public interface BalanceNotifier {
	void notifyBalance(User user, Integer month, BigDecimal monthlyBalance);
}
