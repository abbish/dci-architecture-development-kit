package com.domainmodeling.dci.adk.sample.moneytransfer

import com.domainmodeling.dci.adk.sample.moneytransfer.Account
import com.domainmodeling.dci.adk.sample.moneytransfer.MoneyTransfer
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal

class MoneyTransferTest {

    @Test
    fun `test transfer`(): Unit {

        val ledgers = MoneyTransfer(
            "abbish",
            "grace"
        )
            .transfer(BigDecimal(10));

        assertEquals(2, ledgers.size);
        assertEquals("abbish", ledgers.get(0).account.name);
        assertEquals(BigDecimal(90), ledgers.get(0).account.balance);
        assertEquals("grace", ledgers.get(1).account.name);
        assertEquals(BigDecimal(110), ledgers.get(1).account.balance);
    }

}