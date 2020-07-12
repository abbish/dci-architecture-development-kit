package com.domainmodeling.dci.adk.businessorientedmodel.oo.rfp;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.proposal.Proposal;
import com.domainmodeling.dci.adk.core.data.DCIData;

public interface RequestForProposal<P extends Proposal, R> extends DCIData {
    P propose(R command);
}
