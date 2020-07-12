package com.domainmodeling.dci.adk.businessorientedmodel;

import com.domainmodeling.dci.adk.core.role.DCIRole;

public interface Fulfillment<D extends Contract, R, C> extends DCIRole<D> {
    D request(R command);

    D confirm(C command);
}
