package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BankAccountTest {

    @Override
    protected int getExpectedFee() {
        return 1;
    }

    @Override
    protected int getOverdrawAmount() {
        return this.amount + 1;
    }

    @Override
    @Test
    public void testCannotWithdrawMoreThanBalanceLimit() {
        this.account.deposit(this.amount);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(this.amount * 2));
    }

    @Override
    protected BankAccount getAccount() {
        return new SilverBankAccount(new CoreBankAccount(), new SilverFee());
    }
}
