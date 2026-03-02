package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {
    private final BankAccount base;
    private static final int MAX_OVERDRAFT = 500;

    public GoldBankAccount(final BankAccount base) {
        this.base = base;
    }

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

    @Override
    public void deposit(final int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(final int amount) {
        if ((amount - this.base.getBalance()) > MAX_OVERDRAFT) {
            throw new IllegalStateException("Withdraw with total amount over the max possible overdraft!");
        }
        this.base.withdraw(amount);
    }
}
