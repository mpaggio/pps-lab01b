package it.unibo.pps.e1;

public class BronzeBankAccount extends AbstractBankAccount{
    private static final int MAX_WITHDRAW_AMOUNT_WITHOUT_FEE = 99;
    private static final int OPTIONAL_FEE = 1;

    public BronzeBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    protected boolean canWithdraw(int amount) {
        return this.getBalance() >= amount;
    }

    @Override
    protected void executeWithdraw(int amount) {
        if (amount <= MAX_WITHDRAW_AMOUNT_WITHOUT_FEE) {
            this.base.withdraw(amount);
        } else {
            this.base.withdraw(amount + OPTIONAL_FEE);
        }

    }
}
