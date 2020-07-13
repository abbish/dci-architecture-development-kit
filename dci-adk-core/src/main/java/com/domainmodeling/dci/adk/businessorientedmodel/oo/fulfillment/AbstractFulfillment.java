package com.domainmodeling.dci.adk.businessorientedmodel.oo.fulfillment;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.contract.Contract;
import com.domainmodeling.dci.adk.businessorientedmodel.oo.evidence.Evidence;
import com.domainmodeling.dci.adk.core.role.AbstractDCIRole;

public abstract class AbstractFulfillment<C extends Contract, RE extends Evidence, RC> extends AbstractDCIRole<C> implements Fulfillment<C, RE, RC> {
    public AbstractFulfillment(C data) {
        super(data);
    }

    final public <CE extends Evidence, CC> RequestEvidenceConfirmation<CE, CC> withRequestConfirmation(RE requestEvidence, FulfillmentRequestConfirmation<C, RE, CE, CC> confirmHandler) {
        return confirmationCommand -> confirmHandler.confirm(data(), requestEvidence, confirmationCommand);
    }
}
