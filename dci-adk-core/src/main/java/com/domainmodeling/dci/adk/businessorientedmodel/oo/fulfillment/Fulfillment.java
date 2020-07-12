package com.domainmodeling.dci.adk.businessorientedmodel.oo.fulfillment;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.contract.Contract;
import com.domainmodeling.dci.adk.businessorientedmodel.oo.evidence.Evidence;
import com.domainmodeling.dci.adk.core.role.DCIRole;

public interface Fulfillment<C extends Contract, RE extends Evidence, RC, CE extends Evidence, CC> extends DCIRole<C> {
    RE request(RC command);

    CE confirm(RE requestEvidence, CC command);
}
