package com.domainmodeling.dci.adk.sample.java.orderpayment;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.contract.AbstractContract;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class Order extends AbstractContract {
    private String orderNo;
    private String seller;
    private String buyer;
    private OrderStatus status;
    private List<OrderItem> items;
    private BigDecimal totalAmount;
}
