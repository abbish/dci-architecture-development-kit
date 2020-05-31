package com.domainmodeling.dci.adk.sample.kotlin.moneytransfer

import java.math.BigDecimal

class MoneyTransfer(private val fromAccount: String, private val toAccount: String) :
        AccountTransferer {
    fun transfer(transferAmount: BigDecimal): Array<AccountLedger> {

        val from = Account(
                BigDecimal(100.00),
                fromAccount
        );
        val to = Account(
                BigDecimal(100.00),
                toAccount
        );

        val ledgers: Array<AccountLedger> = arrayOf(
            from.outcome(transferAmount),
            to.income(transferAmount)
        );

        return ledgers;
    }
}