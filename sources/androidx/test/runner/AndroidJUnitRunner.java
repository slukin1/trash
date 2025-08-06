package androidx.test.runner;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import androidx.test.internal.runner.RunnerArgs;
import androidx.test.internal.runner.TestExecutor;
import androidx.test.internal.runner.TestRequestBuilder;
import androidx.test.internal.runner.listener.ActivityFinisherRunListener;
import androidx.test.internal.runner.listener.CoverageListener;
import androidx.test.internal.runner.listener.DelayInjector;
import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import androidx.test.internal.runner.listener.LogRunListener;
import androidx.test.internal.runner.listener.SuiteAssignmentPrinter;
import androidx.test.internal.runner.tracker.AnalyticsBasedUsageTracker;
import androidx.test.internal.util.ReflectionUtil;
import androidx.test.orchestrator.instrumentationlistener.OrchestratedInstrumentationListener;
import androidx.test.runner.MonitoringInstrumentation;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;
import androidx.test.runner.lifecycle.ApplicationLifecycleMonitorRegistry;
import androidx.test.runner.screenshot.Screenshot;
import java.util.HashSet;
import org.junit.runner.Request;
import org.junit.runner.notification.RunListener;

public class AndroidJUnitRunner extends MonitoringInstrumentation implements OrchestratedInstrumentationListener.OnConnectListener {

    /* renamed from: r  reason: collision with root package name */
    public Bundle f11654r;

    /* renamed from: s  reason: collision with root package name */
    public InstrumentationResultPrinter f11655s = new InstrumentationResultPrinter();

    /* renamed from: t  reason: collision with root package name */
    public RunnerArgs f11656t;

    /* renamed from: u  reason: collision with root package name */
    public UsageTrackerFacilitator f11657u;

    /* renamed from: v  reason: collision with root package name */
    public OrchestratedInstrumentationListener f11658v;

    public final void A(RunnerArgs runnerArgs, TestExecutor.Builder builder) {
        if (runnerArgs.f11421f) {
            builder.c(G());
        } else if (runnerArgs.f11417b) {
            builder.c(new SuiteAssignmentPrinter());
        } else {
            builder.c(new LogRunListener());
            OrchestratedInstrumentationListener orchestratedInstrumentationListener = this.f11658v;
            if (orchestratedInstrumentationListener != null) {
                builder.c(orchestratedInstrumentationListener);
            } else {
                builder.c(G());
            }
            builder.c(new ActivityFinisherRunListener(this, new MonitoringInstrumentation.ActivityFinisher(), new Runnable() {
                public void run() {
                    AndroidJUnitRunner.this.v();
                }
            }));
            x(runnerArgs, builder);
            w(runnerArgs, builder);
        }
        z(runnerArgs, builder);
    }

    public final void B(RunnerArgs runnerArgs, TestExecutor.Builder builder) {
        z(runnerArgs, builder);
        if (runnerArgs.f11421f) {
            builder.c(G());
        } else if (runnerArgs.f11417b) {
            builder.c(new SuiteAssignmentPrinter());
        } else {
            builder.c(new LogRunListener());
            x(runnerArgs, builder);
            w(runnerArgs, builder);
            OrchestratedInstrumentationListener orchestratedInstrumentationListener = this.f11658v;
            if (orchestratedInstrumentationListener != null) {
                builder.c(orchestratedInstrumentationListener);
            } else {
                builder.c(G());
            }
            builder.c(new ActivityFinisherRunListener(this, new MonitoringInstrumentation.ActivityFinisher(), new Runnable() {
                public void run() {
                    AndroidJUnitRunner.this.v();
                }
            }));
        }
    }

    public final void C(RunnerArgs runnerArgs) {
        Screenshot.a(new HashSet(runnerArgs.f11441z));
    }

    public Request D(RunnerArgs runnerArgs, Bundle bundle) {
        TestRequestBuilder E = E(this, bundle);
        E.i(runnerArgs.f11438w);
        if (runnerArgs.f11438w.isEmpty()) {
            E.h(getContext().getPackageCodePath());
        }
        E.g(runnerArgs);
        I();
        return E.o();
    }

    public TestRequestBuilder E(Instrumentation instrumentation, Bundle bundle) {
        return new TestRequestBuilder(instrumentation, bundle);
    }

    public final Bundle F() {
        return this.f11654r;
    }

    public InstrumentationResultPrinter G() {
        return this.f11655s;
    }

    public final void H(Bundle bundle) {
        this.f11656t = new RunnerArgs.Builder().F(this).E(this, bundle).D();
    }

    public final void I() {
        Context targetContext = getTargetContext();
        if (targetContext != null) {
            this.f11657u.c(new AnalyticsBasedUsageTracker.Builder(targetContext).h());
        }
    }

    public final boolean J(RunnerArgs runnerArgs) {
        return runnerArgs.f11416a && !runnerArgs.B;
    }

    public void a() {
        start();
    }

    public void finish(int i11, Bundle bundle) {
        try {
            this.f11657u.b("AndroidJUnitRunner", "1.1.0");
            this.f11657u.a();
        } catch (RuntimeException e11) {
            Log.w("AndroidJUnitRunner", "Failed to send analytics.", e11);
        }
        super.finish(i11, bundle);
    }

    public void onCreate(Bundle bundle) {
        this.f11654r = bundle;
        H(bundle);
        if (J(this.f11656t)) {
            Log.i("AndroidJUnitRunner", "Waiting for debugger to connect...");
            Debug.waitForDebugger();
            Log.i("AndroidJUnitRunner", "Debugger connected.");
        }
        if (o(this.f11656t.f11440y)) {
            this.f11657u = new UsageTrackerFacilitator(this.f11656t);
        } else {
            this.f11657u = new UsageTrackerFacilitator(false);
        }
        super.onCreate(bundle);
        for (ApplicationLifecycleCallback a11 : this.f11656t.f11436u) {
            ApplicationLifecycleMonitorRegistry.a().a(a11);
        }
        C(this.f11656t);
        RunnerArgs runnerArgs = this.f11656t;
        if (runnerArgs.A == null || !o(runnerArgs.f11440y)) {
            start();
            return;
        }
        OrchestratedInstrumentationListener orchestratedInstrumentationListener = new OrchestratedInstrumentationListener(this);
        this.f11658v = orchestratedInstrumentationListener;
        orchestratedInstrumentationListener.k(getContext());
    }

    public boolean onException(Object obj, Throwable th2) {
        InstrumentationResultPrinter G = G();
        if (G != null) {
            G.n(th2);
        }
        return super.onException(obj, th2);
    }

    public void onStart() {
        q("androidx.test.espresso.web.bridge.JavaScriptBridge");
        super.onStart();
        RunnerArgs runnerArgs = this.f11656t;
        if (!runnerArgs.B || !o(runnerArgs.f11440y)) {
            RunnerArgs.TestArg testArg = this.f11656t.f11439x;
            if (testArg != null) {
                ReflectionUtil.a(testArg.f11468a, testArg.f11469b);
            }
            if (!o(this.f11656t.f11440y)) {
                Log.i("AndroidJUnitRunner", "Runner is idle...");
                return;
            }
            Bundle bundle = new Bundle();
            try {
                TestExecutor.Builder builder = new TestExecutor.Builder(this);
                y(this.f11656t, builder);
                bundle = builder.d().a(D(this.f11656t, F()));
            } catch (RuntimeException e11) {
                Log.e("AndroidJUnitRunner", "Fatal exception when running tests", e11);
                String valueOf = String.valueOf(Log.getStackTraceString(e11));
                bundle.putString("stream", valueOf.length() != 0 ? "Fatal exception when running tests\n".concat(valueOf) : new String("Fatal exception when running tests\n"));
            }
            finish(-1, bundle);
            return;
        }
        this.f11658v.j(D(this.f11656t, F()).a().getDescription());
        finish(-1, new Bundle());
    }

    public final void w(RunnerArgs runnerArgs, TestExecutor.Builder builder) {
        if (runnerArgs.f11418c) {
            builder.c(new CoverageListener(runnerArgs.f11419d));
        }
    }

    public final void x(RunnerArgs runnerArgs, TestExecutor.Builder builder) {
        int i11 = runnerArgs.f11420e;
        if (i11 > 0) {
            builder.c(new DelayInjector(i11));
        } else if (runnerArgs.f11421f && Build.VERSION.SDK_INT < 16) {
            builder.c(new DelayInjector(15));
        }
    }

    public final void y(RunnerArgs runnerArgs, TestExecutor.Builder builder) {
        if (runnerArgs.D) {
            B(runnerArgs, builder);
        } else {
            A(runnerArgs, builder);
        }
    }

    public final void z(RunnerArgs runnerArgs, TestExecutor.Builder builder) {
        for (RunListener c11 : runnerArgs.f11428m) {
            builder.c(c11);
        }
    }
}
