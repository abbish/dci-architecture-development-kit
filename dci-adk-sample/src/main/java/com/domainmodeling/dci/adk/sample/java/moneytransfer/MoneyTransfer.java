package com.domainmodeling.dci.adk.sample.java.moneytransfer;

import adk.context.DCIContext;
import adk.exception.BuildRoleInstanceFailed;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class MoneyTransfer implements DCIContext {

    private String from;
    private String to;

    public List<AccountLedger> transfer(BigDecimal amount) throws BuildRoleInstanceFailed {

        AccountTransferer fromAccount = ImmutableAccount.builder()
                .balance(BigDecimal.valueOf(100))
                .name(from)
                .build()
                .play(AccountTransferer.class);

        AccountTransferer toAccount = ImmutableAccount.builder()
                .balance(BigDecimal.valueOf(100))
                .name(to)
                .build()
                .play(AccountTransferer.class);

        List<AccountLedger> ledgers = Arrays.asList(
                fromAccount.outcome(BigDecimal.valueOf(10)),
                toAccount.income(BigDecimal.valueOf(10))
        );

        return ledgers;

    }

}
