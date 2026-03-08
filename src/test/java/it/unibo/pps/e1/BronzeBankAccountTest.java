package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest {
    private BankAccount account;
    private final static int INITIAL_BALANCE = 0;
    private final static int OPTIONAL_FEE = 1;

    @BeforeEach
    void init() {
        this.account = new BronzeBankAccount(new CoreBankAccount());
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(INITIAL_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        int amountExample = 1000;
        this.account.deposit(amountExample);
        assertEquals(amountExample, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithFee() {
        int depositExample = 1000;
        int withdrawExample = 200;
        this.account.deposit(depositExample);
        this.account.withdraw(withdrawExample);
        assertEquals(depositExample - (withdrawExample + OPTIONAL_FEE), this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithoutFee() {
        int depositExample = 1000;
        int withdrawExample = 99;
        this.account.deposit(depositExample);
        this.account.withdraw(withdrawExample);
        assertEquals(depositExample - (withdrawExample), this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        int depositExample = 1000;
        int withdrawExample = 1200;
        this.account.deposit(depositExample);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawExample));
    }
}
