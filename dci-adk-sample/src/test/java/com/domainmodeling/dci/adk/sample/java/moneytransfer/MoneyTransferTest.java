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
        assertEquals("abbish", ledgers.get(0).account().name());
        assertEquals(BigDecimal.valueOf(100), ledgers.get(0).originalBalance());
        assertEquals(BigDecimal.valueOf(10), ledgers.get(0).outcome());
        assertEquals(BigDecimal.valueOf(90), ledgers.get(0).account().balance());

        assertEquals("grace", ledgers.get(1).account().name());
        assertEquals(BigDecimal.valueOf(100), ledgers.get(1).originalBalance());
        assertEquals(BigDecimal.valueOf(10), ledgers.get(1).income());
        assertEquals(BigDecimal.valueOf(110), ledgers.get(1).account().balance());

    }
}