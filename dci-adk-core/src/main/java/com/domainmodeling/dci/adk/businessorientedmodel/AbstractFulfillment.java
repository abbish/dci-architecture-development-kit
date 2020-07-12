package com.domainmodeling.dci.adk.businessorientedmodel;

import com.domainmodeling.dci.adk.core.role.AbstractDCIRole;

public abstract class AbstractFulfillment<D extends Contract, RC, CC> extends AbstractDCIRole<D> implements Fulfillment<D, RC, CC> {
    public AbstractFulfillment(D data) {
        super(data);
    }
}
