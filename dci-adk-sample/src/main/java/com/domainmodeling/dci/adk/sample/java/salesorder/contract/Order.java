package com.domainmodeling.dci.adk.sample.java.salesorder.contract;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.contract.AbstractContract;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Order extends AbstractContract {
    private String orderNo;
    private String quotationNo;
    private String seller;
    private String buyer;
    private OrderStatus status;
    private List<OrderItem> items;
    private BigDecimal totalAmount;
}
