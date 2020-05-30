package com.domainmodeling.dci.adk.sample.moneytransfer

import java.math.BigDecimal

@com.domainmodeling.dci.adk.annotation.DCIData
data class Account(var balance: BigDecimal, val name: String)