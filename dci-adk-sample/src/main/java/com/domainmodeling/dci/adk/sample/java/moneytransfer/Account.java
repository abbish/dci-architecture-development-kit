package com.domainmodeling.dci.adk.sample.java.moneytransfer;

import com.domainmodeling.dci.adk.core.data.DCIData;
import org.immutables.value.Value;

import java.math.BigDecimal;

@Value.Immutable
interface Account extends DCIData {
     String name();
     BigDecimal balance();
}
