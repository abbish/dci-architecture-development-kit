package com.domainmodeling.dci.adk.sample.java.moneytransfer;

import adk.role.AbstractDCIRole;

import java.math.BigDecimal;

public class AccountTransferer extends AbstractDCIRole<Account> {

    protected AccountTransferer(Account data) {
        super(data);
    }

    public AccountLedger income(BigDecimal amount) {
        return new AccountLedger(new Account(
                data().getName(),
                data().getBalance().add(amount)),
                data().getBalance(), amount, BigDecimal.ZERO);
    }

    public AccountLedger outcome(BigDecimal amount) {
        return new AccountLedger(new Account(
                data().getName(),
                data().getBalance().subtract(amount)),
                data().getBalance(), BigDecimal.ZERO, amount);
    }
}
