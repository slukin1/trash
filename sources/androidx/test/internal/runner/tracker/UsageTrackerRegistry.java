package androidx.test.internal.runner.tracker;

import androidx.test.internal.runner.tracker.UsageTracker;
import androidx.test.internal.util.Checks;

public final class UsageTrackerRegistry {

    /* renamed from: a  reason: collision with root package name */
    public static volatile UsageTracker f11600a = new UsageTracker.NoOpUsageTracker();

    public static UsageTracker a() {
        return f11600a;
    }

    public static void b(UsageTracker usageTracker) {
        f11600a = (UsageTracker) Checks.b(usageTracker);
    }
}
