package com.domainmodeling.dci.adk.businessorientedmodel.rfp;

import com.domainmodeling.dci.adk.businessorientedmodel.proposal.Proposal;
import com.domainmodeling.dci.adk.core.data.DCIData;

public interface RequestForProposal<P extends Proposal, R> extends DCIData {
    P propose(R command);
}
