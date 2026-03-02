package it.unibo.pps.e1;

public class SilverBankAccountTest extends BankAccountTest {

    @Override
    protected int getExpectedFee(final int withdrawAmount) {
        return 1;
    }

    @Override
    protected int getOverdrawAmount() {
        return this.amount + 1;
    }

    @Override
    protected BankAccount getAccount() {
        return new SilverBankAccount(new CoreBankAccount(), new SilverFee());
    }
}
