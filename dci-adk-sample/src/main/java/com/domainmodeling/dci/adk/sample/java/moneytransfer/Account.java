package com.domainmodeling.dci.adk.sample.java.moneytransfer;

import adk.data.DCIData;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;


@Getter
@AllArgsConstructor
final public class Account implements DCIData {
    private String name;
    private BigDecimal balance;
}
