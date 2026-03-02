package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {

    final private BankAccount base;
    final private Fee fee;

    public GoldBankAccount(final BankAccount base, final Fee fee) {
        this.base = base;
        this.fee = fee;
    }

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        this.base.withdraw(amount + this.fee.calculateFee());
    }
}
