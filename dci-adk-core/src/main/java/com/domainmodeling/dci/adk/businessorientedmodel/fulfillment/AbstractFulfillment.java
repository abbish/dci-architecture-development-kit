package com.domainmodeling.dci.adk.businessorientedmodel.fulfillment;

import com.domainmodeling.dci.adk.businessorientedmodel.contract.Contract;
import com.domainmodeling.dci.adk.businessorientedmodel.evidence.Evidence;
import com.domainmodeling.dci.adk.core.role.AbstractDCIRole;

public abstract class AbstractFulfillment<C extends Contract, RE extends Evidence, RC, CE extends Evidence, CC> extends AbstractDCIRole<C> implements Fulfillment<C, RE, RC, CE, CC> {
    public AbstractFulfillment(C data) {
        super(data);
    }
}
