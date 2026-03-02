package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldBankAccountTest {
    private static final int INITIAL_BALANCE = 0;

    @Test
    public void testInitiallyEmpty() {
        BankAccount account = new GoldBankAccount();
        assertEquals(INITIAL_BALANCE, account.getBalance());
    }
}
