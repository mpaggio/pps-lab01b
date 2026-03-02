package it.unibo.pps.e1;

public abstract class AbstractBankAccount implements BankAccount {
    final BankAccount base;

    public AbstractBankAccount(final BankAccount base) {
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
        if (canWithdraw(amount)) {
            executeWithdraw(amount);
        } else {
            throw new IllegalStateException("Can't execute withdraw with given amount!");
        }
    }

    protected abstract boolean canWithdraw(final int amount);
    protected abstract void executeWithdraw(final int amount);
}
