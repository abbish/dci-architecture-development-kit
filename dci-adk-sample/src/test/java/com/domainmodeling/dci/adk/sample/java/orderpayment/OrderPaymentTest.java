package com.domainmodeling.dci.adk.sample.java.orderpayment;

import com.domainmodeling.dci.adk.core.exception.DCIRoleInstanceBuildException;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.PaymentFulfillment;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.command.AlipayPaymentConfirmationCommand;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.command.WechatPaymentConfirmationCommand;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.confirmation.AlipayPaymentConfirmation;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.confirmation.WechatPaymentConfirmation;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.evidence.AlipayPaymentConfirmationEvidence;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.evidence.PaymentEvidenceType;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.evidence.WechatPaymentConfirmationEvidence;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.request.PaymentRequestCommand;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.request.PaymentRequestEvidence;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class OrderPaymentTest {
    @Test
    public void shouldCreatePaymentFulfillmentEvidences() throws DCIRoleInstanceBuildException {


        //in main order context
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
                .totalAmount(BigDecimal.valueOf(20))
                .build();

        //in fulfillment sub context
        PaymentRequestEvidence requestEvidence = order
                .fulfill(PaymentFulfillment.class)
                .request(PaymentRequestCommand.builder().build());

        assertEquals("order#001 payment requested",
                requestEvidence.getContent()
        );

        //in fulfillment sub context
        WechatPaymentConfirmationEvidence wechatConfirmationEvidence = order.fulfill(PaymentFulfillment.class)
                .withRequestConfirmation(requestEvidence, new WechatPaymentConfirmation())
                .confirm(WechatPaymentConfirmationCommand.builder().build());

        assertEquals("PRE:`order#001 payment requested` confirmed by wechat",
                wechatConfirmationEvidence.getContent()
        );

        //in fulfillment sub context
        AlipayPaymentConfirmationEvidence alipayConfirmationEvidence = order.fulfill(PaymentFulfillment.class)
                .withRequestConfirmation(requestEvidence, new AlipayPaymentConfirmation())
                .confirm(AlipayPaymentConfirmationCommand.builder().build());

        assertEquals("PRE:`order#001 payment requested` confirmed by alipay",
                alipayConfirmationEvidence.getContent()
        );

        // lambda as confirmation handler
        AlipayPaymentConfirmationEvidence lambdaConfirmationEvidence = order.fulfill(PaymentFulfillment.class)
                .withRequestConfirmation(requestEvidence, (contract, requestEvidence1, confirmationCommand) -> AlipayPaymentConfirmationEvidence.builder()
                        .evidenceName(PaymentEvidenceType.CONFIRMATION_EVIDENCE.toString())
                        .content(String.format("PRE:`%s` confirmed by lambda", requestEvidence1.getContent()))
                        .createdAt(Instant.now())
                        .evidenceId(UUID.randomUUID().toString())
                        .build())
                .confirm(AlipayPaymentConfirmationCommand.builder().build());

        assertEquals("PRE:`order#001 payment requested` confirmed by lambda",
                lambdaConfirmationEvidence.getContent()
        );

        // merge sub context result to main context
        order.putEvidence(requestEvidence.getEvidenceName(), requestEvidence);
        order.putEvidence(wechatConfirmationEvidence.getEvidenceName(), wechatConfirmationEvidence);
        order.putEvidence(alipayConfirmationEvidence.getEvidenceName(), alipayConfirmationEvidence);
        order.putEvidence(lambdaConfirmationEvidence.getEvidenceName(), lambdaConfirmationEvidence);

        assertEquals(2, order.getEvidences().size());

    }
}