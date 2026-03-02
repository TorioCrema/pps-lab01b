package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount {

    private final BankAccount base;
    private final Fee fee;

    public SilverBankAccount(final BankAccount base, final Fee fee) {
        this.base = base;
        this.fee = fee;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + this.fee.calculateFee());
    }
}
