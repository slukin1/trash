package org.junit.runners.model;

import java.util.HashSet;
import java.util.Set;
import org.junit.internal.runners.a;
import org.junit.runner.Runner;

public abstract class RunnerBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final Set<Class<?>> f25487a = new HashSet();

    public abstract Runner a(Class<?> cls) throws Throwable;

    public Runner b(Class<?> cls) {
        try {
            return a(cls);
        } catch (Throwable th2) {
            return new a(cls, th2);
        }
    }
}
