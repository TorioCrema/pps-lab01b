package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BronzeAccountTest extends BankAccountTest {
    @Override
    protected BankAccount getAccount() {
        return new BronzeAccount(new CoreBankAccount(), new BronzeFee());
    }

    @Override
    protected int getExpectedFee(final int withdrawAmount) {
        return withdrawAmount > 100 ? 1 : 0;
    }

    @Override
    protected int getOverdrawAmount() {
        return this.amount + 1;
    }

    @Test
    public void testCanWithdrawWithoutFee() {
        final int withdrawAmountWithoutFee = 50;
        this.account.deposit(this.amount);
        this.account.withdraw(withdrawAmountWithoutFee);
        assertEquals(this.amount - withdrawAmountWithoutFee, this.account.getBalance());
    }
}
