package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import junit.framework.Test;

public class c extends b {
    public c(Class<?> cls) throws Throwable {
        super(i(cls));
    }

    public static Test i(Class<?> cls) throws Throwable {
        try {
            Method method = cls.getMethod("suite", new Class[0]);
            if (Modifier.isStatic(method.getModifiers())) {
                return (Test) method.invoke((Object) null, new Object[0]);
            }
            throw new Exception(cls.getName() + ".suite() must be static");
        } catch (InvocationTargetException e11) {
            throw e11.getCause();
        }
    }
}
