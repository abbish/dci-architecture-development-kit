package adk.data;

import adk.exception.DCIRoleInstanceBuildException;
import adk.role.DCIRole;
import adk.role.DCIRoleFactory;

public interface DCIData {
    default public <R extends DCIRole> R play(Class<R> roleClass) throws DCIRoleInstanceBuildException {
        return DCIRoleFactory.build(roleClass, this);
    }
}
