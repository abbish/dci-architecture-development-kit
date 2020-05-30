package com.domainmodeling.dci.adk

import com.domainmodeling.dci.adk.sample.moneytransfer.Account
import com.domainmodeling.dci.adk.sample.moneytransfer.MoneyTransfer
import com.domainmodeling.dci.adk.sample.moneytransfer.Transferer
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal

class TransfererTest: Transferer {

    @Test
    fun `test transferer income`(): Unit {
        val account = Account(BigDecimal(100), "abbish");

        val ledger = account.income(BigDecimal(10));

        assertEquals(BigDecimal(110), ledger.account.balance);
    }

    @Test
    fun `test transferer outcome`(): Unit {
        val account = Account(BigDecimal(100), "abbish");

        val ledger = account.outcome(BigDecimal(10));

        assertEquals(BigDecimal(90), ledger.account.balance);
    }

}