package com.domainmodeling.dci.adk.sample.java.moneytransfer;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class MoneyTransferTest {

    @Test
    public void testTransfer() {

        List<AccountLedger> ledgers = new MoneyTransfer("abbish", "grace").transfer(BigDecimal.valueOf(10));

        assertEquals(2, ledgers.size());
        assertEquals("abbish", ledgers.get(0).getAccount().getName());
        assertEquals(BigDecimal.ZERO, ledgers.get(0).getIncome());
        assertEquals(BigDecimal.valueOf(90), ledgers.get(0).getAccount().getBalance());

        assertEquals("grace", ledgers.get(1).getAccount().getName());
        assertEquals(BigDecimal.valueOf(10), ledgers.get(1).getIncome());
        assertEquals(BigDecimal.valueOf(110), ledgers.get(1).getAccount().getBalance());
    }
}