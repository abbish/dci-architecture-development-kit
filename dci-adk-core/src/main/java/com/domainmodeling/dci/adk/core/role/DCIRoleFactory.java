package com.domainmodeling.dci.adk.core.role;

import com.domainmodeling.dci.adk.core.data.DCIData;
import com.domainmodeling.dci.adk.core.exception.DCIRoleInstanceBuildException;

import java.lang.reflect.Constructor;

final public class DCIRoleFactory {
    static public <R extends DCIRole, D extends DCIData> R build(Class<R> roleClass, D data) throws DCIRoleInstanceBuildException {
       try {
           Constructor<R> constructor = roleClass.getConstructor(data.getClass());
           return (R) constructor.newInstance(data);
       }
       catch (NoSuchMethodException e) {
           throw new DCIRoleInstanceBuildException(
                   String.format("No matched constructor found in role class %s, the role %s declared DCIData type should be %s", roleClass.getSimpleName(), roleClass.getSimpleName(), data.getClass().getSimpleName())
           );
       }
       catch (Exception e) {
           throw new DCIRoleInstanceBuildException(
                   String.format("Build role class %s instance was failed, the reason is: %s", roleClass.getSimpleName(), e.getMessage())
           );
       }
    }
}
