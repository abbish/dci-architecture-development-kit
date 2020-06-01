package adk.role;

import adk.data.DCIData;
import adk.exception.DCIRoleInstanceBuildException;

import java.lang.reflect.Constructor;

final public class DCIRoleFactory {
    static public <R extends DCIRole, D extends DCIData> R build(Class<R> roleClass, D data) throws DCIRoleInstanceBuildException {
       try {
           Constructor constructor = roleClass.getConstructor(data.getClass());
           return (R) constructor.newInstance(data);

       }
       catch (NoSuchMethodException e) {
           throw new DCIRoleInstanceBuildException(
                   String.format("No matched constructor found in role class %s, the role %s declared DCIData type should be %s", roleClass.getName(), roleClass.getSimpleName(), data.getClass().getName())
           );
       }
       catch (Exception e) {
           throw new DCIRoleInstanceBuildException(
                   String.format("Build role class %s instance was failed, the reason is: %s", roleClass.getName(), e.getMessage())
           );
       }
    }
}
