package r20;

import java.util.Arrays;
import org.junit.internal.builders.IgnoredBuilder;
import org.junit.internal.builders.JUnit3Builder;
import org.junit.internal.builders.JUnit4Builder;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

public class a extends RunnerBuilder {

    /* renamed from: b  reason: collision with root package name */
    public final boolean f25622b;

    public a(boolean z11) {
        this.f25622b = z11;
    }

    public Runner a(Class<?> cls) throws Throwable {
        for (RunnerBuilder b11 : Arrays.asList(new RunnerBuilder[]{d(), c(), g(), e(), f()})) {
            Runner b12 = b11.b(cls);
            if (b12 != null) {
                return b12;
            }
        }
        return null;
    }

    public b c() {
        throw null;
    }

    public IgnoredBuilder d() {
        throw null;
    }

    public JUnit3Builder e() {
        throw null;
    }

    public JUnit4Builder f() {
        throw null;
    }

    public RunnerBuilder g() {
        throw null;
    }
}
