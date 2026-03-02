package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends BankAccountTest {

    @Override
    protected BankAccount getAccount() {
        return new GoldBankAccount(new CoreBankAccount(), new GoldFee());
    }

    @Override
    protected int getExpectedFee() {
        return 0;
    }

    @Override
    protected int getOverdrawAmount() {
        int maximumNegativeBalance = -500;
        return this.amount - maximumNegativeBalance + 1;
    }

    @Test
    public void testCanReachNegativeBalance() {
        this.account.deposit(this.amount);
        this.account.withdraw(this.amount + 500);
        assertEquals(-500, this.account.getBalance());
    }
}
