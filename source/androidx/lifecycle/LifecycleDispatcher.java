package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

public final class LifecycleDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static final LifecycleDispatcher f9901a = new LifecycleDispatcher();

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicBoolean f9902b = new AtomicBoolean(false);

    public static final class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
            ReportFragment.f9938c.c(activity);
        }
    }

    public static final void a(Context context) {
        if (!f9902b.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
        }
    }
}
