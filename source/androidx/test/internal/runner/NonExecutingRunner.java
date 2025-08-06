package androidx.test.internal.runner;

import java.util.ArrayList;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;
import v20.a;

class NonExecutingRunner extends Runner implements a {

    /* renamed from: a  reason: collision with root package name */
    public final Runner f11415a;

    public NonExecutingRunner(Runner runner) {
        this.f11415a = runner;
    }

    public void a(Filter filter) throws NoTestsRemainException {
        filter.a(this.f11415a);
    }

    public void b(RunNotifier runNotifier) {
        c(runNotifier, getDescription());
    }

    public final void c(RunNotifier runNotifier, Description description) {
        ArrayList<Description> children = description.getChildren();
        if (children.isEmpty()) {
            runNotifier.l(description);
            runNotifier.h(description);
            return;
        }
        for (Description c11 : children) {
            c(runNotifier, c11);
        }
    }

    public Description getDescription() {
        return this.f11415a.getDescription();
    }
}
