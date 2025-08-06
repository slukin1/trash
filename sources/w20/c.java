package w20;

import java.util.Collections;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

public class c extends b<Runner> {

    /* renamed from: f  reason: collision with root package name */
    public final List<Runner> f26303f;

    public c(Class<?> cls, List<Runner> list) throws InitializationError {
        super(cls);
        this.f26303f = Collections.unmodifiableList(list);
    }

    /* renamed from: B */
    public Description k(Runner runner) {
        return runner.getDescription();
    }

    /* renamed from: C */
    public void r(Runner runner, RunNotifier runNotifier) {
        runner.b(runNotifier);
    }

    public List<Runner> l() {
        return this.f26303f;
    }
}
