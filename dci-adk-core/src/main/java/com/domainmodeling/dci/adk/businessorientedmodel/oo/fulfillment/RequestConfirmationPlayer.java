package com.domainmodeling.dci.adk.businessorientedmodel.oo.fulfillment;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.contract.Contract;
import com.domainmodeling.dci.adk.businessorientedmodel.oo.evidence.Evidence;

@FunctionalInterface
public interface RequestConfirmationPlayer<C extends Contract, RE extends Evidence, CE extends Evidence, CC> {
    CE confirm(C contract, RE requestEvidence, CC confirmationCommand);
}
