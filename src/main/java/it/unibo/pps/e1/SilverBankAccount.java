package it.unibo.pps.e1;

public class SilverBankAccount extends AbstractBankAccount {

    private final static int SILVER_FEE = 1;

    public SilverBankAccount(final BankAccount base) {
        super(base);
    }

    @Override
    protected boolean canWithdraw(int amount) {
        return this.getBalance() >= amount;
    }

    @Override
    protected void executeWithdraw(int amount) {
        this.base.withdraw(amount + SILVER_FEE);
    }
}
