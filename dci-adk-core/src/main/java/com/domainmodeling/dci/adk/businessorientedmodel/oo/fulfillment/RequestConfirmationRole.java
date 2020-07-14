package com.domainmodeling.dci.adk.businessorientedmodel.oo.fulfillment;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.evidence.Evidence;

@FunctionalInterface
public interface RequestConfirmationRole<RCP extends RequestConfirmationPlayer, CE extends Evidence, CC> {
    public RequestEvidenceConfirmation<CE, CC> withConfirmationPlayer(RCP player);
}
