package com.domainmodeling.dci.adk.core.data;

import com.domainmodeling.dci.adk.core.exception.DCIRoleInstanceBuildException;
import com.domainmodeling.dci.adk.core.role.DCIRole;
import com.domainmodeling.dci.adk.core.role.DCIRoleFactory;

public interface DCIData {
    default public <R extends DCIRole> R play(Class<R> roleClass) throws DCIRoleInstanceBuildException {
        return DCIRoleFactory.build(roleClass, this);
    }
}
