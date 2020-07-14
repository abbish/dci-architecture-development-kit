package com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.confirmation;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.fulfillment.FulfillmentRequestConfirmation;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.Order;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.command.WechatPaymentConfirmationCommand;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.evidence.PaymentEvidenceType;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.evidence.WechatPaymentConfirmationEvidence;
import com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.request.PaymentRequestEvidence;

import java.time.Instant;
import java.util.UUID;

public class WechatPaymentConfirmation implements FulfillmentRequestConfirmation<Order, PaymentRequestEvidence, WechatPaymentConfirmationEvidence, WechatPaymentConfirmationCommand> {
    @Override
    public WechatPaymentConfirmationEvidence confirm(Order contract, PaymentRequestEvidence requestEvidence, WechatPaymentConfirmationCommand confirmationCommand) {
        return WechatPaymentConfirmationEvidence.builder()
                .evidenceName(PaymentEvidenceType.CONFIRMATION_EVIDENCE.toString())
                .content(String.format("PRE:`%s` confirmed by wechat", requestEvidence.getContent()))
                .createdAt(Instant.now())
                .evidenceId(UUID.randomUUID().toString())
                .build();
    }
}
