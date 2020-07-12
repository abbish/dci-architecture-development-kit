package com.domainmodeling.dci.adk.businessorientedmodel.oo.fulfillment;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.contract.Contract;
import com.domainmodeling.dci.adk.businessorientedmodel.oo.evidence.Evidence;
import com.domainmodeling.dci.adk.core.role.AbstractDCIRole;

public abstract class AbstractFulfillment<C extends Contract, RE extends Evidence, RC, CE extends Evidence, CC> extends AbstractDCIRole<C> implements Fulfillment<C, RE, RC, CE, CC> {
    public AbstractFulfillment(C data) {
        super(data);
    }

    final public RequestEvidenceConfirmation<CE, CC> withRequestEvidence(RE requestEvidence) {
        return confirmationCommand -> this.confirm(requestEvidence, confirmationCommand);
    }
}
