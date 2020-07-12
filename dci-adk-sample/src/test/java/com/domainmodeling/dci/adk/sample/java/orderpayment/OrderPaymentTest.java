package com.domainmodeling.dci.adk.sample.java.orderpayment;

import com.domainmodeling.dci.adk.core.exception.DCIRoleInstanceBuildException;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.PaymentFulfillment;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.command.PaymentConfirmationCommand;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.command.PaymentRequestCommand;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.evidence.PaymentConfirmationEvidence;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.evidence.PaymentRequestEvidence;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderPaymentTest {
    @Test
    public void shouldCreatePaymentFulfillmentEvidences() throws DCIRoleInstanceBuildException, InvocationTargetException, IllegalAccessException {

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
                .orderNo("001")
                .build();

        PaymentRequestEvidence requestEvidence = order
                .fulfill(PaymentFulfillment.class)
                .request(PaymentRequestCommand.builder().build());

        assertEquals("order#001 payment requested",
                requestEvidence.getContent()
        );

        PaymentConfirmationEvidence confirmationEvidence = order.fulfill(PaymentFulfillment.class)
                .withRequestEvidence(requestEvidence)
                .confirm(PaymentConfirmationCommand.builder().build());

        assertEquals("order#001 payment confirmed",
                confirmationEvidence.getContent()
        );

        // merge evidence to order
        order.putEvidence(requestEvidence.getEvidenceName(), requestEvidence);
        order.putEvidence(confirmationEvidence.getEvidenceName(), confirmationEvidence);

        assertEquals(2, order.getEvidences().size());

    }
}