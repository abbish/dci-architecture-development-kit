package com.domainmodeling.dci.adk.sample.java.moneytransfer;

import adk.context.DCIContext;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class MoneyTransfer implements DCIContext {

    private String from;
    private String to;

    public List<AccountLedger> transfer(BigDecimal amount) {

        AccountTransferer fromAccount = new AccountTransferer(
                ImmutableAccount.builder()
                        .balance(BigDecimal.valueOf(100))
                        .name(from)
                        .build());

        AccountTransferer toAccount = new AccountTransferer(
                ImmutableAccount.builder()
                        .balance(BigDecimal.valueOf(100))
                        .name(to)
                        .build());

        List<AccountLedger> ledgers = Arrays.asList(
                fromAccount.outcome(BigDecimal.valueOf(10)),
                toAccount.income(BigDecimal.valueOf(10))
        );

        return ledgers;

    }

}
