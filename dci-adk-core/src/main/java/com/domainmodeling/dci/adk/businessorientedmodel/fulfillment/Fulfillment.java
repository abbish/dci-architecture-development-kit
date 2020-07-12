package com.domainmodeling.dci.adk.businessorientedmodel.fulfillment;

import com.domainmodeling.dci.adk.businessorientedmodel.contract.Contract;
import com.domainmodeling.dci.adk.businessorientedmodel.evidence.Evidence;
import com.domainmodeling.dci.adk.core.role.DCIRole;

public interface Fulfillment<C extends Contract, RE extends Evidence, RC, CE extends Evidence, CC> extends DCIRole<C> {
    RE request(RC command);

    CE confirm(RE requestEvidence, CC command);
}
