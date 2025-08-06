package androidx.test.internal.runner.lifecycle;

import android.app.Activity;
import android.os.Looper;
import android.util.Log;
import androidx.test.internal.util.Checks;
import androidx.test.runner.lifecycle.ActivityLifecycleCallback;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.Stage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ActivityLifecycleMonitorImpl implements ActivityLifecycleMonitor {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f11561a;

    /* renamed from: b  reason: collision with root package name */
    public final List<WeakReference<ActivityLifecycleCallback>> f11562b;

    /* renamed from: c  reason: collision with root package name */
    public List<ActivityStatus> f11563c;

    public static class ActivityStatus {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<Activity> f11564a;

        /* renamed from: b  reason: collision with root package name */
        public Stage f11565b;

        public ActivityStatus(Activity activity, Stage stage) {
            this.f11564a = new WeakReference<>((Activity) Checks.b(activity));
            this.f11565b = (Stage) Checks.b(stage);
        }
    }

    public ActivityLifecycleMonitorImpl() {
        this(false);
    }

    public Collection<Activity> a(Stage stage) {
        b();
        Checks.b(stage);
        ArrayList arrayList = new ArrayList();
        Iterator<ActivityStatus> it2 = this.f11563c.iterator();
        while (it2.hasNext()) {
            ActivityStatus next = it2.next();
            Activity activity = (Activity) next.f11564a.get();
            if (activity == null) {
                it2.remove();
            } else if (stage == next.f11565b) {
                arrayList.add(activity);
            }
        }
        return arrayList;
    }

    public final void b() {
        if (!this.f11561a && !Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            throw new IllegalStateException("Querying activity state off main thread is not allowed.");
        }
    }

    public void c(Stage stage, Activity activity) {
        String valueOf = String.valueOf(activity);
        String valueOf2 = String.valueOf(stage);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 30 + valueOf2.length());
        sb2.append("Lifecycle status change: ");
        sb2.append(valueOf);
        sb2.append(" in: ");
        sb2.append(valueOf2);
        Log.d("LifecycleMonitor", sb2.toString());
        Iterator<ActivityStatus> it2 = this.f11563c.iterator();
        boolean z11 = true;
        while (it2.hasNext()) {
            ActivityStatus next = it2.next();
            Activity activity2 = (Activity) next.f11564a.get();
            if (activity2 == null) {
                it2.remove();
            } else if (activity == activity2) {
                Stage unused = next.f11565b = stage;
                z11 = false;
            }
        }
        if (z11) {
            this.f11563c.add(new ActivityStatus(activity, stage));
        }
        synchronized (this.f11562b) {
            Iterator<WeakReference<ActivityLifecycleCallback>> it3 = this.f11562b.iterator();
            while (it3.hasNext()) {
                ActivityLifecycleCallback activityLifecycleCallback = (ActivityLifecycleCallback) it3.next().get();
                if (activityLifecycleCallback == null) {
                    it3.remove();
                } else {
                    try {
                        String valueOf3 = String.valueOf(activityLifecycleCallback);
                        StringBuilder sb3 = new StringBuilder(valueOf3.length() + 18);
                        sb3.append("running callback: ");
                        sb3.append(valueOf3);
                        Log.d("LifecycleMonitor", sb3.toString());
                        activityLifecycleCallback.a(activity, stage);
                        String valueOf4 = String.valueOf(activityLifecycleCallback);
                        StringBuilder sb4 = new StringBuilder(valueOf4.length() + 20);
                        sb4.append("callback completes: ");
                        sb4.append(valueOf4);
                        Log.d("LifecycleMonitor", sb4.toString());
                    } catch (RuntimeException e11) {
                        Log.e("LifecycleMonitor", String.format("Callback threw exception! (callback: %s activity: %s stage: %s)", new Object[]{activityLifecycleCallback, activity, stage}), e11);
                    }
                }
            }
        }
    }

    public ActivityLifecycleMonitorImpl(boolean z11) {
        this.f11562b = new ArrayList();
        this.f11563c = new ArrayList();
        this.f11561a = z11;
    }
}
