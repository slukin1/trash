package org.junit.internal.builders;

import junit.framework.TestCase;
import org.junit.internal.runners.b;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

public class JUnit3Builder extends RunnerBuilder {
    public Runner a(Class<?> cls) throws Throwable {
        if (c(cls)) {
            return new b(cls);
        }
        return null;
    }

    public boolean c(Class<?> cls) {
        return TestCase.class.isAssignableFrom(cls);
    }
}
