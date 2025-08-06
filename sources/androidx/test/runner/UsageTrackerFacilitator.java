package androidx.test.runner;

import android.util.Log;
import androidx.test.internal.runner.RunnerArgs;
import androidx.test.internal.runner.tracker.UsageTracker;
import androidx.test.internal.runner.tracker.UsageTrackerRegistry;
import androidx.test.internal.util.Checks;

public class UsageTrackerFacilitator implements UsageTracker {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f11686a;

    public UsageTrackerFacilitator(RunnerArgs runnerArgs) {
        Checks.c(runnerArgs, "runnerArgs cannot be null!");
        boolean z11 = true;
        if (runnerArgs.A != null) {
            this.f11686a = (runnerArgs.f11435t || !runnerArgs.B) ? false : z11;
        } else {
            this.f11686a = !runnerArgs.f11435t;
        }
    }

    public void a() {
        if (d()) {
            UsageTrackerRegistry.a().a();
        }
    }

    public void b(String str, String str2) {
        if (d()) {
            UsageTrackerRegistry.a().b(str, str2);
        }
    }

    public void c(UsageTracker usageTracker) {
        if (usageTracker == null || !d()) {
            Log.i("UsageTrackerFacilitator", "Usage tracking disabled");
            UsageTrackerRegistry.b(new UsageTracker.NoOpUsageTracker());
            return;
        }
        Log.i("UsageTrackerFacilitator", "Usage tracking enabled");
        UsageTrackerRegistry.b(usageTracker);
    }

    public boolean d() {
        return this.f11686a;
    }

    public UsageTrackerFacilitator(boolean z11) {
        this.f11686a = z11;
    }
}
