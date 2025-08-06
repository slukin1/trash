package androidx.test.runner.intent;

import java.util.concurrent.atomic.AtomicReference;

public final class IntentMonitorRegistry {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<IntentMonitor> f11687a = new AtomicReference<>((Object) null);

    public static void a(IntentMonitor intentMonitor) {
        f11687a.set(intentMonitor);
    }
}
