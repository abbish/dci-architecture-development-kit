package com.domainmodeling.dci.adk.sample.java.moneytransfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
public class AccountLedger {
    private Account account;
    private BigDecimal originalBalance;
    private BigDecimal income;
    private BigDecimal outcome;
    private Instant creationTime;

    public AccountLedger(Account account, BigDecimal originalBalance, BigDecimal income, BigDecimal outcome) {
        this.account = account;
        this.originalBalance = originalBalance;
        this.income = income;
        this.outcome = outcome;
        this.creationTime = Instant.now();
    }
}
