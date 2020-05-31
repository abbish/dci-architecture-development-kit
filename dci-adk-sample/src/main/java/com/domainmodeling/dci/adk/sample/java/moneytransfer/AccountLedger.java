package com.domainmodeling.dci.adk.sample.java.moneytransfer;

import org.immutables.value.Value;

import java.math.BigDecimal;
import java.time.Instant;

@Value.Immutable
interface AccountLedger {
     Account account();
     BigDecimal originalBalance();

     @Value.Default
     default BigDecimal income() {
          return BigDecimal.ZERO;
     };

     @Value.Default
     default BigDecimal outcome() {
          return BigDecimal.ZERO;
     }

     @Value.Default
     default Instant creationTime() {
          return Instant.now();
     }
}
