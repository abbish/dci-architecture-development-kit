package com.domainmodeling.dci.adk.businessorientedmodel.oo.proposal;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.contract.Contract;
import com.domainmodeling.dci.adk.core.data.DCIData;

public interface Proposal<D extends Contract, R> extends DCIData {
    D sign(R command);
}
