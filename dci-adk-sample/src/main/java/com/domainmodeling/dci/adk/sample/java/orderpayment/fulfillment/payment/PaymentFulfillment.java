package com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.fulfillment.AbstractFulfillment;
import com.domainmodeling.dci.adk.sample.java.orderpayment.Order;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.evidence.PaymentEvidenceType;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.request.PaymentRequestCommand;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.request.PaymentRequestEvidence;

import java.time.Instant;
import java.util.UUID;

public class PaymentFulfillment extends AbstractFulfillment<Order, PaymentRequestEvidence, PaymentRequestCommand> {
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
}
