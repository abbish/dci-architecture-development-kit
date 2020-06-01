package adk.role;

import adk.data.DCIData;
import adk.exception.DCIRoleInstanceBuildException;

import java.lang.reflect.Constructor;

final public class DCIRoleFactory {
    static public <R extends DCIRole> R build(Class<R> roleClass, DCIData data) throws DCIRoleInstanceBuildException {
       try {
           Constructor<?>[] constructors = roleClass.getConstructors();

           if(constructors.length != 1) {
               throw new DCIRoleInstanceBuildException(String.format("Role class %s only one constructor allowed", roleClass.getName()));
           }

           Constructor<R> constructor = (Constructor<R>) roleClass.getConstructors()[0];

           return constructor.newInstance(data);

       } catch (Exception e) {
           throw new DCIRoleInstanceBuildException(
                   String.format("Build role class %s instance was failed, reason: %s", roleClass.getName(), e.getMessage())
           );
       }
    }
}
