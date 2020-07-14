package com.domainmodeling.dci.adk.sample.java.salesorder.proposal;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.proposal.Proposal;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.Order;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.OrderItem;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.OrderStatus;
import com.domainmodeling.dci.adk.sample.java.salesorder.proposal.command.SignQuotationCommand;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@SuperBuilder
public class Quotation implements Proposal<SignQuotationCommand, Order> {

    private String quotationNo;
    private String quotationRequestNo;
    private Instant createdAt;
    private Instant signedAt;
    private String buyer;
    private String seller;
    private List<QuotationItem> items;

    @Override
    public Order sign(SignQuotationCommand signCommand) {

        this.signedAt = Instant.now();

        return Order.builder()
                .quotationNo(quotationNo)
                .buyer(buyer)
                .seller(seller)
                .items(items.stream().map(i -> OrderItem.builder()
                        .product(i.product)
                        .price(i.price)
                        .qty(i.qty)
                        .build()).collect(Collectors.toList()))
                .status(OrderStatus.CREATED)
                .orderNo("001")
                .totalAmount(BigDecimal.valueOf(20))
                .build();
    }

    @Data
    @Builder
    public static class QuotationItem {
        private String product;
        private Integer qty;
        private BigDecimal price;
    }
}
