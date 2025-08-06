package xm;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import bh.j;
import com.huobi.activity.StartFlashActivity;
import i6.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f76821a = true;

    public class a implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Class<StartFlashActivity> cls = StartFlashActivity.class;
            if (c.f76821a) {
                boolean unused = c.f76821a = false;
                if (activity.getClass() != cls) {
                    k.n("process recycled go flash");
                    activity.startActivity(new Intent(activity, cls));
                    activity.finish();
                }
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static void c() {
        j.c().registerActivityLifecycleCallbacks(new a());
    }

    public static void d(boolean z11) {
        f76821a = z11;
    }
}
