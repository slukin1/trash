package androidx.test;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

@Deprecated
public final class InstrumentationRegistry {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<Instrumentation> f11067a = new AtomicReference<>((Object) null);

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReference<Bundle> f11068b = new AtomicReference<>((Object) null);

    @Deprecated
    public static Instrumentation a() {
        Instrumentation instrumentation = f11067a.get();
        if (instrumentation != null) {
            return instrumentation;
        }
        throw new IllegalStateException("No instrumentation registered! Must run under a registering instrumentation.");
    }

    @Deprecated
    public static Context b() {
        return a().getTargetContext();
    }

    @Deprecated
    public static void c(Instrumentation instrumentation, Bundle bundle) {
        f11067a.set(instrumentation);
        f11068b.set(new Bundle(bundle));
    }
}
