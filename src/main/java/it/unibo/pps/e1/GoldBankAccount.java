package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {
    private int balance;

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
        this.balance -= amount;
    }
}
