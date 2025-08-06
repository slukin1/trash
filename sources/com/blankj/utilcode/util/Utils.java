package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import java.util.Objects;

public final class Utils {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static Application f63533a;

    public static class ActivityLifecycleCallbacks {
        public void a(Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void b(Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void c(Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void d(Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void e(Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void f(Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void g(Activity activity, Lifecycle.Event event) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
    }

    public interface a<T> {
        void accept(T t11);
    }

    public interface b {
        void a(Activity activity);

        void b(Activity activity);
    }

    public static Application a() {
        Application application = f63533a;
        if (application != null) {
            return application;
        }
        b(a0.i());
        Objects.requireNonNull(f63533a, "reflect failed.");
        Log.i("Utils", a0.j() + " reflect app success.");
        return f63533a;
    }

    public static void b(Application application) {
        if (application == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application2 = f63533a;
        if (application2 == null) {
            f63533a = application;
            a0.u(application);
            a0.F();
        } else if (!application2.equals(application)) {
            a0.K(f63533a);
            f63533a = application;
            a0.u(application);
        }
    }
}
