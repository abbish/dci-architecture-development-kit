package com.domainmodeling.dci.adk.businessorientedmodel;

import com.domainmodeling.dci.adk.core.data.DCIData;
import com.domainmodeling.dci.adk.core.exception.DCIRoleInstanceBuildException;

public interface Fulfillable extends DCIData {
    default public <R extends Fulfillment> R fulfill(Class<R> fulfillmentClass) throws DCIRoleInstanceBuildException {
        return play(fulfillmentClass);
    }
}
