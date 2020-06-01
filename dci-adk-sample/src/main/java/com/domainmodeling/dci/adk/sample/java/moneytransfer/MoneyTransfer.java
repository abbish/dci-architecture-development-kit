package com.domainmodeling.dci.adk.sample.java.moneytransfer;

import adk.context.DCIContext;
import adk.exception.DCIRoleInstanceBuildException;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class MoneyTransfer implements DCIContext {

    private final String from;
    private final String to;

    public List<AccountLedger> transfer(BigDecimal amount) throws DCIRoleInstanceBuildException {

        Account fromAccount = ImmutableAccount.builder()
                .balance(BigDecimal.valueOf(100))
                .name(from)
                .build();

        Account toAccount = ImmutableAccount.builder()
                .balance(BigDecimal.valueOf(100))
                .name(to)
                .build();

        List<AccountLedger> ledgers = Arrays.asList(
                fromAccount.play(AccountTransferer.class).outcome(amount),
                toAccount.play(AccountTransferer.class).income(amount)
        );

        return ledgers;
    }
}
