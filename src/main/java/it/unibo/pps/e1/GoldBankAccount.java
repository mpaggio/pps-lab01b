package it.unibo.pps.e1;

public class GoldBankAccount extends AbstractBankAccount {
    private static final int MAX_OVERDRAFT = 500;

    public GoldBankAccount(final BankAccount base) {
        super(base);
    }

    @Override
    protected boolean canWithdraw(int amount) {
        return (amount - this.base.getBalance()) <= MAX_OVERDRAFT;
    }

    @Override
    protected void executeWithdraw(int amount) {
        this.base.withdraw(amount);
    }
}
