package adk.data;

import adk.exception.BuildRoleInstanceFailed;
import adk.role.AbstractDCIRole;
import adk.role.DCIRole;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public interface DCIData {
    default public <R extends DCIRole> R play(Class<R> roleClass) throws BuildRoleInstanceFailed {
        try {
            Constructor<R> constructor = (Constructor<R>) roleClass.getConstructors()[0];
            return constructor.newInstance(this);
        } catch (Exception e) {
            throw new BuildRoleInstanceFailed(e.getMessage());
        }
    }
}
