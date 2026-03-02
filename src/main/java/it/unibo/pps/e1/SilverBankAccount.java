package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount {

    private final BankAccount base;
    private final static int SILVER_FEE = 1;

    public SilverBankAccount(final BankAccount base) {
        this.base = base;
    }

    public int getBalance() {
        return this.base.getBalance();
    }

    public void deposit(final int amount) {
        this.base.deposit(amount);
    }

    public void withdraw(final int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount + SILVER_FEE);
    }
}
