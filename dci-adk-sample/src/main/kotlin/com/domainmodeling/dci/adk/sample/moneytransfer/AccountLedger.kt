package com.domainmodeling.dci.adk.sample.moneytransfer

import java.math.BigDecimal

data class AccountLedger(val account: Account, val originalBalance: BigDecimal, val income: BigDecimal, val outcome: BigDecimal)
