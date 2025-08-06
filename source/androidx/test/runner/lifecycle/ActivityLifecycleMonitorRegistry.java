package androidx.test.runner.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

public final class ActivityLifecycleMonitorRegistry {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<ActivityLifecycleMonitor> f11692a = new AtomicReference<>((Object) null);

    public static ActivityLifecycleMonitor a() {
        ActivityLifecycleMonitor activityLifecycleMonitor = f11692a.get();
        if (activityLifecycleMonitor != null) {
            return activityLifecycleMonitor;
        }
        throw new IllegalStateException("No lifecycle monitor registered! Are you running under an Instrumentation which registers lifecycle monitors?");
    }

    public static void b(ActivityLifecycleMonitor activityLifecycleMonitor) {
        f11692a.set(activityLifecycleMonitor);
    }
}
