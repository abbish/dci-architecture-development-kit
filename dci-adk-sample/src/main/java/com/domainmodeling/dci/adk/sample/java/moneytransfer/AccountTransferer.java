package com.domainmodeling.dci.adk.sample.java.moneytransfer;

import adk.role.AbstractDCIRole;

import java.math.BigDecimal;
import java.time.Instant;

public class AccountTransferer extends AbstractDCIRole<Account> {

    protected AccountTransferer(Account data) {
        super(data);
    }

    public ImmutableAccountLedger income(BigDecimal amount) {
        return ImmutableAccountLedger.builder()
                .account(ImmutableAccount.copyOf(data())
                        .withBalance(data().balance().add(amount)))
                .income(amount)
                .originalBalance(data().balance())
                .build();
    }

    public ImmutableAccountLedger outcome(BigDecimal amount) {
        return ImmutableAccountLedger.builder()
                .account(ImmutableAccount.copyOf(data())
                        .withBalance(data().balance().subtract(amount)))
                .outcome(amount)
                .originalBalance(data().balance())
                .build();
    }

}
