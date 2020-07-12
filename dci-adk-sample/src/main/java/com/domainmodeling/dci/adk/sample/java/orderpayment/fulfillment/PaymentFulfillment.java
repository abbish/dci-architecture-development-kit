package com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.fulfillment.AbstractFulfillment;
import com.domainmodeling.dci.adk.sample.java.orderpayment.Order;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.command.PaymentConfirmationCommand;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.command.PaymentRequestCommand;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.evidence.PaymentConfirmationEvidence;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.evidence.PaymentRequestEvidence;

import java.time.Instant;
import java.util.UUID;

public class PaymentFulfillment extends AbstractFulfillment<Order, PaymentRequestEvidence, PaymentRequestCommand, PaymentConfirmationEvidence, PaymentConfirmationCommand> {
    public PaymentFulfillment(Order data) {
        super(data);
    }

    @Override
    public PaymentRequestEvidence request(PaymentRequestCommand requestCommand) {
        // ......
        // do some payment request logic
        // ......

        return PaymentRequestEvidence.builder()
                .evidenceName(PaymentEvidenceType.REQUEST_EVIDENCE.toString())
                .content(String.format("order#%s payment requested", data().getOrderNo()))
                .createdAt(Instant.now())
                .evidenceId(UUID.randomUUID().toString())
                .build();

    }

    @Override
    public PaymentConfirmationEvidence confirm(PaymentRequestEvidence requestEvidence, PaymentConfirmationCommand command) {
        return PaymentConfirmationEvidence.builder()
                .evidenceName(PaymentEvidenceType.CONFIRMATION_EVIDENCE.toString())
                .content(String.format("order#%s payment confirmed", data().getOrderNo()))
                .createdAt(Instant.now())
                .evidenceId(UUID.randomUUID().toString())
                .build();
    }
}
