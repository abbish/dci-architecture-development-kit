package com.domainmodeling.dci.adk.businessorientedmodel.oo.proposal;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.contract.Contract;
import com.domainmodeling.dci.adk.core.data.DCIData;

public interface Proposal<SC, C extends Contract> extends DCIData {
    C sign(SC signCommand);
}
