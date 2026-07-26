package com.tejas.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(101, "Tejas", 1000);
    }

    @Test
    void testDeposit(){
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testWithdraw() throws InsufficientFundsException {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        assertThrows(
                InsufficientFundsException.class, () -> account.withdraw(1500)
        );
    }

    @Test
    void testTransactionAddedAfterDeposit(){
        account.deposit(500);
        assertEquals(1, account.getTransactions().size());
    }
}
