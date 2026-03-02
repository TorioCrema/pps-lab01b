package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class BankAccountTest {
    protected BankAccount account;
    protected final int amount = 1000;

    @BeforeEach
    void init() {
        this.account = this.getAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(this.amount);
        assertEquals(this.amount, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        final int withDrawAmount = 200;
        this.account.deposit(this.amount);
        this.account.withdraw(withDrawAmount);
        assertEquals(this.amount - withDrawAmount - this.getExpectedFee(), this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanBalanceLimit() {
        this.account.deposit(this.amount);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(this.getOverdrawAmount()));
    }

    protected abstract BankAccount getAccount();

    protected abstract int getExpectedFee();

    protected abstract int getOverdrawAmount();
}
