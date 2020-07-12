package com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment;

import com.domainmodeling.dci.adk.businessorientedmodel.AbstractFulfillment;
import com.domainmodeling.dci.adk.sample.java.orderpayment.Order;
import com.domainmodeling.dci.adk.sample.java.orderpayment.OrderStatus;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.command.ConfirmationCommand;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.command.RequestCommand;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.evidence.ConfirmationEvidence;
import com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.evidence.RequestEvidence;

import java.time.Instant;
import java.util.UUID;

public class PaymentFulfillment extends AbstractFulfillment<Order, RequestCommand, ConfirmationCommand> {
    public PaymentFulfillment(Order data) {
        super(data);
    }

    @Override
    public Order request(RequestCommand requestCommand) {
        // ......
        // do some payment request logic
        // ......

        data().setStatus(OrderStatus.FULFILL_PAYMENT_REQUESTED);
        data().putEvidence(
                PaymentEvidenceType.REQUEST_EVIDENCE.toString(),
                RequestEvidence.builder()
                        .evidenceName(PaymentEvidenceType.REQUEST_EVIDENCE.toString())
                        .content(String.format("order#%s payment requested", data().getOrderNo()))
                        .createdAt(Instant.now())
                        .evidenceId(UUID.randomUUID().toString())
                        .build()
        );

        return data();
    }

    @Override
    public Order confirm(ConfirmationCommand confirmCommand) {
        // ......
        // do some payment confirmation logic
        // ......

        data().setStatus(OrderStatus.FULFILL_PAYMENT_CONFIRMED);
        data().putEvidence(
                PaymentEvidenceType.CONFIRMATION_EVIDENCE.toString(),
                ConfirmationEvidence.builder()
                        .evidenceName(PaymentEvidenceType.CONFIRMATION_EVIDENCE.toString())
                        .content(String.format("order#%s payment confirmed", data().getOrderNo()))
                        .createdAt(Instant.now())
                        .evidenceId(UUID.randomUUID().toString())
                        .build()
        );

        return data();
    }
}
