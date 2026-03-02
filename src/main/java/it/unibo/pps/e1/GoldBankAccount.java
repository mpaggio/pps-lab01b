package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {
    private int balance;
    private static final int MAX_OVERDRAFT = 500;

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(final int amount) {
        if ((amount - this.balance) > MAX_OVERDRAFT) {
            throw new IllegalStateException("Withdraw with total amount over the max possible overdraft!");
        }
        this.balance -= amount;
    }
}
