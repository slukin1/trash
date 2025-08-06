package org.junit.runner;

import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

public class JUnitCore {

    /* renamed from: a  reason: collision with root package name */
    public final RunNotifier f25460a = new RunNotifier();

    public void a(RunListener runListener) {
        this.f25460a.d(runListener);
    }

    public void b(RunListener runListener) {
        this.f25460a.m(runListener);
    }

    public Result c(Request request) {
        return d(request.a());
    }

    public Result d(Runner runner) {
        Result result = new Result();
        RunListener createListener = result.createListener();
        this.f25460a.c(createListener);
        try {
            this.f25460a.k(runner.getDescription());
            runner.b(this.f25460a);
            this.f25460a.j(result);
            return result;
        } finally {
            b(createListener);
        }
    }
}
