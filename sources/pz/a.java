package pz;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.util.Log;
import com.tencent.qcloud.tuicore.TUIConstants;
import dagger.android.AndroidInjector;
import dagger.internal.d;

public final class a {
    public static b a(Fragment fragment) {
        Fragment fragment2 = fragment;
        do {
            fragment2 = fragment2.getParentFragment();
            if (fragment2 == null) {
                Activity activity = fragment.getActivity();
                if (activity instanceof b) {
                    return (b) activity;
                }
                if (activity.getApplication() instanceof b) {
                    return (b) activity.getApplication();
                }
                throw new IllegalArgumentException(String.format("No injector was found for %s", new Object[]{fragment.getClass().getCanonicalName()}));
            }
        } while (!(fragment2 instanceof b));
        return (b) fragment2;
    }

    public static void b(Activity activity) {
        d.c(activity, "activity");
        Application application = activity.getApplication();
        if (application instanceof b) {
            g(activity, (b) application);
        } else {
            throw new RuntimeException(String.format("%s does not implement %s", new Object[]{application.getClass().getCanonicalName(), b.class.getCanonicalName()}));
        }
    }

    public static void c(Fragment fragment) {
        d.c(fragment, TUIConstants.TUIChat.FRAGMENT);
        b a11 = a(fragment);
        if (Log.isLoggable("dagger.android", 3)) {
            Log.d("dagger.android", String.format("An injector for %s was found in %s", new Object[]{fragment.getClass().getCanonicalName(), a11.getClass().getCanonicalName()}));
        }
        g(fragment, a11);
    }

    public static void d(Service service) {
        d.c(service, "service");
        Application application = service.getApplication();
        if (application instanceof b) {
            g(service, (b) application);
        } else {
            throw new RuntimeException(String.format("%s does not implement %s", new Object[]{application.getClass().getCanonicalName(), b.class.getCanonicalName()}));
        }
    }

    public static void e(BroadcastReceiver broadcastReceiver, Context context) {
        d.c(broadcastReceiver, "broadcastReceiver");
        d.c(context, "context");
        Application application = (Application) context.getApplicationContext();
        if (application instanceof b) {
            g(broadcastReceiver, (b) application);
        } else {
            throw new RuntimeException(String.format("%s does not implement %s", new Object[]{application.getClass().getCanonicalName(), b.class.getCanonicalName()}));
        }
    }

    public static void f(ContentProvider contentProvider) {
        d.c(contentProvider, "contentProvider");
        Application application = (Application) contentProvider.getContext().getApplicationContext();
        if (application instanceof b) {
            g(contentProvider, (b) application);
        } else {
            throw new RuntimeException(String.format("%s does not implement %s", new Object[]{application.getClass().getCanonicalName(), b.class.getCanonicalName()}));
        }
    }

    public static void g(Object obj, b bVar) {
        AndroidInjector<Object> a11 = bVar.a();
        d.d(a11, "%s.androidInjector() returned null", bVar.getClass());
        a11.inject(obj);
    }
}
