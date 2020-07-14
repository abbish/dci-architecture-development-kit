package com.domainmodeling.dci.adk.sample.java.salesorder;

import com.domainmodeling.dci.adk.core.exception.DCIRoleInstanceBuildException;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.Order;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.PaymentFulfillment;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.command.AlipayPaymentConfirmationCommand;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.command.WechatPaymentConfirmationCommand;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.confirmation.AlipayPaymentConfirmationPlayer;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.confirmation.WechatPaymentConfirmationPlayer;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.evidence.AlipayPaymentConfirmationEvidence;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.evidence.PaymentEvidenceType;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.evidence.WechatPaymentConfirmationEvidence;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.request.PaymentRequestCommand;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.request.PaymentRequestEvidence;
import com.domainmodeling.dci.adk.sample.java.salesorder.proposal.Quotation;
import com.domainmodeling.dci.adk.sample.java.salesorder.proposal.RequestForQuotation;
import com.domainmodeling.dci.adk.sample.java.salesorder.proposal.command.ProposeQuotationCommand;
import com.domainmodeling.dci.adk.sample.java.salesorder.proposal.command.SignQuotationCommand;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class OrderPaymentTest {
    @Test
    public void shouldCreatePaymentFulfillmentEvidences() throws DCIRoleInstanceBuildException {

        //rfp
        RequestForQuotation rfp = RequestForQuotation.builder()
                .buyer("abbish")
                .quotationRequestNo("RFP001")
                .createdAt(Instant.now())
                .items(Lists.newArrayList(RequestForQuotation.QuotationRequestItem.builder()
                        .product("iphone")
                        .qty(1)
                        .build()))
                .build();

        //proposal
        Quotation proposal = rfp.propose(ProposeQuotationCommand.builder()
                .seller("grace")
                .build());

        //contract
        Order order = proposal.sign(SignQuotationCommand.builder().build());

        //in fulfillment sub context
        PaymentRequestEvidence requestEvidence = order
                .fulfill(PaymentFulfillment.class)
                .request(PaymentRequestCommand.builder().build());

        assertEquals("order#001 payment requested",
                requestEvidence.getContent()
        );

        //in fulfillment sub context
        WechatPaymentConfirmationEvidence wechatConfirmationEvidence = (WechatPaymentConfirmationEvidence) order.fulfill(PaymentFulfillment.class)
                .requestConfirmation(requestEvidence)
                .withConfirmationPlayer(new WechatPaymentConfirmationPlayer())
                .confirm(WechatPaymentConfirmationCommand.builder().build());

        assertEquals("PRE:`order#001 payment requested` confirmed by wechat",
                wechatConfirmationEvidence.getContent()
        );

        //in fulfillment sub context
        AlipayPaymentConfirmationEvidence alipayConfirmationEvidence = (AlipayPaymentConfirmationEvidence) order.fulfill(PaymentFulfillment.class)
                .requestConfirmation(requestEvidence)
                .withConfirmationPlayer(new AlipayPaymentConfirmationPlayer())
                .confirm(AlipayPaymentConfirmationCommand.builder().build());

        assertEquals("PRE:`order#001 payment requested` confirmed by alipay",
                alipayConfirmationEvidence.getContent()
        );

        // lambda as confirmation handler
        AlipayPaymentConfirmationEvidence lambdaConfirmationEvidence = (AlipayPaymentConfirmationEvidence) order.fulfill(PaymentFulfillment.class)
                .requestConfirmation(requestEvidence)
                .withConfirmationPlayer((contract, requestEvidence1, confirmationCommand) -> AlipayPaymentConfirmationEvidence.builder()
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