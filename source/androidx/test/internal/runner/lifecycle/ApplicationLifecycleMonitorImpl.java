package androidx.test.internal.runner.lifecycle;

import android.app.Application;
import android.util.Log;
import androidx.test.internal.util.Checks;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;
import androidx.test.runner.lifecycle.ApplicationLifecycleMonitor;
import androidx.test.runner.lifecycle.ApplicationStage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApplicationLifecycleMonitorImpl implements ApplicationLifecycleMonitor {

    /* renamed from: a  reason: collision with root package name */
    public final List<WeakReference<ApplicationLifecycleCallback>> f11566a = new ArrayList();

    public void a(ApplicationLifecycleCallback applicationLifecycleCallback) {
        Checks.b(applicationLifecycleCallback);
        synchronized (this.f11566a) {
            boolean z11 = true;
            Iterator<WeakReference<ApplicationLifecycleCallback>> it2 = this.f11566a.iterator();
            while (it2.hasNext()) {
                ApplicationLifecycleCallback applicationLifecycleCallback2 = (ApplicationLifecycleCallback) it2.next().get();
                if (applicationLifecycleCallback2 == null) {
                    it2.remove();
                } else if (applicationLifecycleCallback2 == applicationLifecycleCallback) {
                    z11 = false;
                }
            }
            if (z11) {
                this.f11566a.add(new WeakReference(applicationLifecycleCallback));
            }
        }
    }

    public void b(Application application, ApplicationStage applicationStage) {
        synchronized (this.f11566a) {
            Iterator<WeakReference<ApplicationLifecycleCallback>> it2 = this.f11566a.iterator();
            while (it2.hasNext()) {
                ApplicationLifecycleCallback applicationLifecycleCallback = (ApplicationLifecycleCallback) it2.next().get();
                if (applicationLifecycleCallback == null) {
                    it2.remove();
                } else {
                    try {
                        String valueOf = String.valueOf(applicationLifecycleCallback);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
                        sb2.append("running callback: ");
                        sb2.append(valueOf);
                        Log.d("ApplicationLifecycleMonitorImpl", sb2.toString());
                        applicationLifecycleCallback.a(application, applicationStage);
                        String valueOf2 = String.valueOf(applicationLifecycleCallback);
                        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 20);
                        sb3.append("callback completes: ");
                        sb3.append(valueOf2);
                        Log.d("ApplicationLifecycleMonitorImpl", sb3.toString());
                    } catch (RuntimeException e11) {
                        Log.e("ApplicationLifecycleMonitorImpl", String.format("Callback threw exception! (callback: %s stage: %s)", new Object[]{applicationLifecycleCallback, applicationStage}), e11);
                    }
                }
            }
        }
    }
}
