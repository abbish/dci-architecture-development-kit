package com.domainmodeling.dci.adk.sample.moneytransfer

import java.math.BigDecimal

data class Account(var balance: BigDecimal, val name: String)