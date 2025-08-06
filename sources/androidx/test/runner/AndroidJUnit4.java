package androidx.test.runner;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;
import v20.a;

@Deprecated
public final class AndroidJUnit4 extends Runner implements a {

    /* renamed from: a  reason: collision with root package name */
    public final Runner f11653a;

    public void a(Filter filter) throws NoTestsRemainException {
        ((a) this.f11653a).a(filter);
    }

    public void b(RunNotifier runNotifier) {
        this.f11653a.b(runNotifier);
    }

    public Description getDescription() {
        return this.f11653a.getDescription();
    }
}
