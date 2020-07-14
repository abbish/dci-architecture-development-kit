package com.domainmodeling.dci.adk.businessorientedmodel.oo.rfp;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.proposal.Proposal;
import com.domainmodeling.dci.adk.core.data.DCIData;

public interface RequestForProposal<PC, P extends Proposal> extends DCIData {
    P propose(PC proposeCommand);
}
