package r20;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class c extends Runner {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f25624a;

    public c(Class<?> cls) {
        this.f25624a = cls;
    }

    public void b(RunNotifier runNotifier) {
        runNotifier.i(getDescription());
    }

    public Description getDescription() {
        return Description.createSuiteDescription(this.f25624a);
    }
}
