package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

public class a extends Runner {

    /* renamed from: a  reason: collision with root package name */
    public final List<Throwable> f25428a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f25429b;

    public a(Class<?> cls, Throwable th2) {
        Objects.requireNonNull(cls, "Test class cannot be null");
        this.f25429b = cls;
        this.f25428a = d(th2);
    }

    public void b(RunNotifier runNotifier) {
        for (Throwable e11 : this.f25428a) {
            e(e11, runNotifier);
        }
    }

    public final Description c(Throwable th2) {
        return Description.createTestDescription(this.f25429b, "initializationError");
    }

    public final List<Throwable> d(Throwable th2) {
        if (th2 instanceof InvocationTargetException) {
            return d(th2.getCause());
        }
        if (th2 instanceof InitializationError) {
            return ((InitializationError) th2).getCauses();
        }
        if (th2 instanceof InitializationError) {
            return ((InitializationError) th2).getCauses();
        }
        return Arrays.asList(new Throwable[]{th2});
    }

    public final void e(Throwable th2, RunNotifier runNotifier) {
        Description c11 = c(th2);
        runNotifier.l(c11);
        runNotifier.f(new Failure(c11, th2));
        runNotifier.h(c11);
    }

    public Description getDescription() {
        Description createSuiteDescription = Description.createSuiteDescription(this.f25429b);
        for (Throwable c11 : this.f25428a) {
            createSuiteDescription.addChild(c(c11));
        }
        return createSuiteDescription;
    }
}
