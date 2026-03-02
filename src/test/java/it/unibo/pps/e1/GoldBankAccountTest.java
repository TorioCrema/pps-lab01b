package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldBankAccountTest extends BankAccountTest {

    private final int maximumNegativeBalance = -500;

    @Override
    protected BankAccount getAccount() {
        return new GoldBankAccount(new CoreBankAccount(), new GoldFee());
    }

    @Override
    protected int getExpectedFee(final int withdrawAmount) {
        return 0;
    }

    @Override
    protected int getOverdrawAmount() {
        return this.amount - maximumNegativeBalance + 1;
    }

    @Test
    public void testCanReachNegativeBalance() {
        this.account.deposit(this.amount);
        this.account.withdraw(this.amount - this.maximumNegativeBalance);
        assertEquals(this.maximumNegativeBalance, this.account.getBalance());
    }
}
