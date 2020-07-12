package com.domainmodeling.dci.adk.businessorientedmodel.proposal;

import com.domainmodeling.dci.adk.businessorientedmodel.contract.Contract;
import com.domainmodeling.dci.adk.core.data.DCIData;

public interface Proposal<D extends Contract, R> extends DCIData {
    D sign(R command);
}
