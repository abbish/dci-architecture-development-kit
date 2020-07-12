package com.domainmodeling.dci.adk.sample.java.orderpayment;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderItem {
    private String product;
    private Integer qty;
    private BigDecimal price;
}
