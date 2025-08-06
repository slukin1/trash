package androidx.test.platform.app;

import android.app.Instrumentation;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

public final class InstrumentationRegistry {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<Instrumentation> f11639a = new AtomicReference<>((Object) null);

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReference<Bundle> f11640b = new AtomicReference<>((Object) null);

    public static Instrumentation a() {
        Instrumentation instrumentation = f11639a.get();
        if (instrumentation != null) {
            return instrumentation;
        }
        throw new IllegalStateException("No instrumentation registered! Must run under a registering instrumentation.");
    }

    public static void b(Instrumentation instrumentation, Bundle bundle) {
        f11639a.set(instrumentation);
        f11640b.set(new Bundle(bundle));
    }
}
