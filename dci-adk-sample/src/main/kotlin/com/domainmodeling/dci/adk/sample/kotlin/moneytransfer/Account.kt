package com.domainmodeling.dci.adk.sample.kotlin.moneytransfer

import java.math.BigDecimal

data class Account(var balance: BigDecimal, val name: String)