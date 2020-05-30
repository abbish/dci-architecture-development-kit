package com.domainmodeling.dci.adk.sample.moneytransfer

import java.math.BigDecimal

interface Transferer {
    fun Account.income(amount: BigDecimal): AccountLedger {
        return AccountLedger(
            this.copy(
                this.balance.plus(
                    amount
                )
            ), this.balance, amount, BigDecimal.ZERO
        );
    }

    fun Account.outcome(amount: BigDecimal): AccountLedger {
        return AccountLedger(
            this.copy(
                this.balance.subtract(
                    amount
                )
            ), this.balance, BigDecimal.ZERO, amount
        );
    }
}