package org.junit.internal.builders;

import o20.h;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;
import r20.c;

public class IgnoredBuilder extends RunnerBuilder {
    public Runner a(Class<?> cls) {
        if (cls.getAnnotation(h.class) != null) {
            return new c(cls);
        }
        return null;
    }
}
