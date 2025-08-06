package org.junit.internal.runners.model;

import java.lang.reflect.InvocationTargetException;

public abstract class ReflectiveCallable {
    public Object a() throws Throwable {
        try {
            return b();
        } catch (InvocationTargetException e11) {
            throw e11.getTargetException();
        }
    }

    public abstract Object b() throws Throwable;
}
