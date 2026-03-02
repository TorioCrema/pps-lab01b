package it.unibo.pps.e1;

public class BronzeAccount implements BankAccount {
    private final BankAccount base;
    private final Fee fee;

    public BronzeAccount(final BankAccount base, final Fee fee) {
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
        if (this.base.getBalance() - amount - this.fee.calculateFee(amount) < 0) {
            throw new IllegalStateException("Cannot draw more that available balance.");
        }
        this.base.withdraw(amount + this.fee.calculateFee(amount));
    }
}
