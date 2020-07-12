package com.domainmodeling.dci.adk.sample.java.orderpayment.fulfillment.payment.evidence;

import com.domainmodeling.dci.adk.businessorientedmodel.evidence.Evidence;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class PaymentConfirmationEvidence implements Evidence<String> {
    private String evidenceName;
    private String evidenceId;
    private Instant createdAt;
    private String content;
}
