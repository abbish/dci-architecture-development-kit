package com.domainmodeling.dci.adk.sample.java.orderpayment;

import com.domainmodeling.dci.adk.core.exception.DCIRoleInstanceBuildException;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.PaymentEvidenceType;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.PaymentFulfillment;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.command.ConfirmationCommand;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.command.RequestCommand;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderPaymentTest {
    @Test
    public void shouldCreatePaymentFulfillmentEvidences() throws DCIRoleInstanceBuildException {

        Order order = Order.builder()
                .buyer("abbish")
                .seller("taobao")
                .items(List.of(
                        OrderItem.builder()
                                .product("iphone")
                                .qty(1)
                                .price(BigDecimal.valueOf(10))
                                .build(),
                        OrderItem.builder()
                                .product("macbook")
                                .qty(1)
                                .price(BigDecimal.valueOf(10))
                                .build()
                ))
                .status(OrderStatus.CREATED)
                .orderNo("10000001")
                .build();

        order.fulfill(PaymentFulfillment.class).request(RequestCommand.builder().build());
        assertEquals(OrderStatus.FULFILL_PAYMENT_REQUESTED, order.getStatus());
        assertEquals(true, order.hasEvidence(PaymentEvidenceType.REQUEST_EVIDENCE.toString()));
        assertEquals("order#10000001 payment requested",
                order.getEvidence(PaymentEvidenceType.REQUEST_EVIDENCE.toString()).get().getContent()
        );

        order.fulfill(PaymentFulfillment.class).confirm(ConfirmationCommand.builder().build());
        assertEquals(OrderStatus.FULFILL_PAYMENT_CONFIRMED, order.getStatus());
        assertEquals(true, order.hasEvidence(PaymentEvidenceType.CONFIRMATION_EVIDENCE.toString()));
        assertEquals("order#10000001 payment confirmed",
                order.getEvidence(PaymentEvidenceType.CONFIRMATION_EVIDENCE.toString()).get().getContent()
        );

    }
}