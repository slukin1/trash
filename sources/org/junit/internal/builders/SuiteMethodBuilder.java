package org.junit.internal.builders;

import org.junit.internal.runners.c;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

public class SuiteMethodBuilder extends RunnerBuilder {
    public Runner a(Class<?> cls) throws Throwable {
        if (c(cls)) {
            return new c(cls);
        }
        return null;
    }

    public boolean c(Class<?> cls) {
        try {
            cls.getMethod("suite", new Class[0]);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }
}
