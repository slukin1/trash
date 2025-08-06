package androidx.test.runner.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

public final class ApplicationLifecycleMonitorRegistry {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<ApplicationLifecycleMonitor> f11693a = new AtomicReference<>((Object) null);

    public static ApplicationLifecycleMonitor a() {
        ApplicationLifecycleMonitor applicationLifecycleMonitor = f11693a.get();
        if (applicationLifecycleMonitor != null) {
            return applicationLifecycleMonitor;
        }
        throw new IllegalStateException("No lifecycle monitor registered! Are you running under an Instrumentation which registers lifecycle monitors?");
    }

    public static void b(ApplicationLifecycleMonitor applicationLifecycleMonitor) {
        f11693a.set(applicationLifecycleMonitor);
    }
}
