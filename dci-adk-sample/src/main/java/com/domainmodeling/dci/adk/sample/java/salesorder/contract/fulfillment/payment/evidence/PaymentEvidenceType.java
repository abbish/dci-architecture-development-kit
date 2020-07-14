package com.domainmodeling.dci.adk.sample.java.salesorder.contract.fulfillment.payment.evidence;

public enum PaymentEvidenceType {
    REQUEST_EVIDENCE("payment-request-evidence"),
    CONFIRMATION_EVIDENCE("payment-confirmation-evidence");

    private String value;

    PaymentEvidenceType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
