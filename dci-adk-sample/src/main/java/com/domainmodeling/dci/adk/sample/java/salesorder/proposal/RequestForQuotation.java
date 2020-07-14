package com.domainmodeling.dci.adk.sample.java.salesorder.proposal;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.rfp.RequestForProposal;
import com.domainmodeling.dci.adk.sample.java.salesorder.proposal.command.ProposeQuotationCommand;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class RequestForQuotation implements RequestForProposal<ProposeQuotationCommand, Quotation> {

    private String quotationRequestNo;
    private Instant createdAt;
    private Instant proposedAt;
    private String buyer;
    private List<QuotationRequestItem> items;

    @Override
    public Quotation propose(ProposeQuotationCommand proposeCommand) {
        return Quotation.builder()
                .quotationNo("001")
                .buyer(buyer)
                .seller(proposeCommand.getSeller())
                .quotationRequestNo(quotationRequestNo)
                .items(items.stream().map(i -> Quotation.QuotationItem.builder()
                        .product(i.getProduct())
                        .qty(i.getQty())
                        .price(BigDecimal.valueOf(10))
                        .build()).collect(Collectors.toList()))
                .createdAt(Instant.now())
                .build();
    }

    @Data
    @Builder
    public static class QuotationRequestItem {
        private String product;
        private Integer qty;
    }
}
