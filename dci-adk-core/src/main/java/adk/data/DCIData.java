package adk.data;

import adk.role.DCIRole;

import java.lang.reflect.InvocationTargetException;

public interface DCIData {
    default public <R extends DCIRole> R play(Class<R> roleClass) {
        try {
            return roleClass.getConstructor(DCIData.class).newInstance(this);
        } catch (NoSuchMethodException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        } catch (InvocationTargetException e) {
            return null;
        } catch (InstantiationException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
