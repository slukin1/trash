package androidx.test.orchestrator.instrumentationlistener;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.test.orchestrator.callback.OrchestratorCallback;
import androidx.test.orchestrator.junit.BundleJUnitUtils;
import androidx.test.orchestrator.listeners.OrchestrationListenerManager$TestEvent;
import java.util.Iterator;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public final class OrchestratedInstrumentationListener extends RunListener {

    /* renamed from: a  reason: collision with root package name */
    public final OnConnectListener f11621a;

    /* renamed from: b  reason: collision with root package name */
    public OrchestratorCallback f11622b;

    /* renamed from: c  reason: collision with root package name */
    public final ServiceConnection f11623c = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            OrchestratedInstrumentationListener.this.f11622b = OrchestratorCallback.Stub.g(iBinder);
            Log.i("OrchestrationListener", "OrchestrationListener connected to service");
            OrchestratedInstrumentationListener.this.f11621a.a();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            OrchestratedInstrumentationListener.this.f11622b = null;
            Log.i("OrchestrationListener", "OrchestrationListener disconnected from service");
        }
    };

    public interface OnConnectListener {
        void a();
    }

    public OrchestratedInstrumentationListener(OnConnectListener onConnectListener) {
        this.f11621a = onConnectListener;
    }

    public void a(Failure failure) {
        try {
            l(OrchestrationListenerManager$TestEvent.TEST_ASSUMPTION_FAILURE, BundleJUnitUtils.b(failure));
        } catch (RemoteException e11) {
            throw new IllegalStateException("Unable to send TestAssumptionFailure status, terminating", e11);
        }
    }

    public void b(Failure failure) {
        try {
            l(OrchestrationListenerManager$TestEvent.TEST_FAILURE, BundleJUnitUtils.b(failure));
        } catch (RemoteException e11) {
            throw new IllegalStateException("Unable to send TestFailure status, terminating", e11);
        }
    }

    public void c(Description description) {
        try {
            l(OrchestrationListenerManager$TestEvent.TEST_FINISHED, BundleJUnitUtils.a(description));
        } catch (RemoteException e11) {
            Log.e("OrchestrationListener", "Unable to send TestFinished Status to Orchestrator", e11);
        }
    }

    public void d(Description description) {
        try {
            l(OrchestrationListenerManager$TestEvent.TEST_IGNORED, BundleJUnitUtils.a(description));
        } catch (RemoteException e11) {
            Log.e("OrchestrationListener", "Unable to send TestIgnored Status to Orchestrator", e11);
        }
    }

    public void e(Result result) {
        try {
            l(OrchestrationListenerManager$TestEvent.TEST_RUN_FINISHED, BundleJUnitUtils.c(result));
        } catch (RemoteException e11) {
            Log.e("OrchestrationListener", "Unable to send TestRunFinished Status to Orchestrator", e11);
        }
    }

    public void f(Description description) {
        try {
            l(OrchestrationListenerManager$TestEvent.TEST_RUN_STARTED, BundleJUnitUtils.a(description));
        } catch (RemoteException e11) {
            Log.e("OrchestrationListener", "Unable to send TestRunStarted Status to Orchestrator", e11);
        }
    }

    public void g(Description description) {
        try {
            l(OrchestrationListenerManager$TestEvent.TEST_STARTED, BundleJUnitUtils.a(description));
        } catch (RemoteException e11) {
            Log.e("OrchestrationListener", "Unable to send TestStarted Status to Orchestrator", e11);
        }
    }

    public void i(String str) {
        OrchestratorCallback orchestratorCallback = this.f11622b;
        if (orchestratorCallback != null) {
            try {
                orchestratorCallback.b(str);
            } catch (RemoteException e11) {
                Log.e("OrchestrationListener", "Unable to send test", e11);
            }
        } else {
            throw new IllegalStateException("Unable to send test, callback is null");
        }
    }

    public void j(Description description) {
        if (!description.isEmpty()) {
            if (description.isTest()) {
                String className = description.getClassName();
                String methodName = description.getMethodName();
                StringBuilder sb2 = new StringBuilder(String.valueOf(className).length() + 1 + String.valueOf(methodName).length());
                sb2.append(className);
                sb2.append("#");
                sb2.append(methodName);
                i(sb2.toString());
                return;
            }
            Iterator<Description> it2 = description.getChildren().iterator();
            while (it2.hasNext()) {
                j(it2.next());
            }
        }
    }

    public void k(Context context) {
        Intent intent = new Intent("androidx.test.orchestrator.OrchestratorService");
        intent.setPackage("androidx.test.orchestrator");
        if (!context.bindService(intent, this.f11623c, 1)) {
            throw new RuntimeException("Cannot connect to androidx.test.orchestrator.OrchestratorService");
        }
    }

    public void l(OrchestrationListenerManager$TestEvent orchestrationListenerManager$TestEvent, Bundle bundle) throws RemoteException {
        if (this.f11622b != null) {
            bundle.putString("TestEvent", orchestrationListenerManager$TestEvent.toString());
            this.f11622b.f(bundle);
            return;
        }
        throw new IllegalStateException("Unable to send notification, callback is null");
    }
}
