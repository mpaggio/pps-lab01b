package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldBankAccountTest {
    private BankAccount account;
    private static final int INITIAL_BALANCE = 0;

    @BeforeEach
    public void setUp() {
        this.account = new GoldBankAccount();
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
}
