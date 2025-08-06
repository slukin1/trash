package androidx.test.internal.runner.listener;

import android.app.Instrumentation;
import androidx.test.internal.runner.InstrumentationConnection;
import androidx.test.internal.util.Checks;
import androidx.test.runner.MonitoringInstrumentation;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

public class ActivityFinisherRunListener extends RunListener {

    /* renamed from: a  reason: collision with root package name */
    public final Instrumentation f11567a;

    /* renamed from: b  reason: collision with root package name */
    public final MonitoringInstrumentation.ActivityFinisher f11568b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f11569c;

    public ActivityFinisherRunListener(Instrumentation instrumentation, MonitoringInstrumentation.ActivityFinisher activityFinisher, Runnable runnable) {
        this.f11567a = (Instrumentation) Checks.b(instrumentation);
        this.f11568b = (MonitoringInstrumentation.ActivityFinisher) Checks.b(activityFinisher);
        this.f11569c = (Runnable) Checks.b(runnable);
    }

    public void c(Description description) throws Exception {
        InstrumentationConnection.e().g();
        this.f11567a.runOnMainSync(this.f11568b);
        this.f11569c.run();
    }

    public void g(Description description) throws Exception {
        this.f11567a.runOnMainSync(this.f11568b);
        this.f11569c.run();
    }
}
