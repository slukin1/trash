package cn.sharesdk.loopshare.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.mob.MobSDK;
import com.mob.tools.utils.ActivityTracker;
import java.util.Iterator;

public class AppStatus {

    /* renamed from: b  reason: collision with root package name */
    private static volatile AppStatus f13674b;

    /* renamed from: a  reason: collision with root package name */
    public int f13675a;

    /* renamed from: c  reason: collision with root package name */
    private int f13676c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f13677d = -1;

    /* renamed from: e  reason: collision with root package name */
    private ActivityTracker.Tracker f13678e = new ActivityTracker.Tracker() {
        public void onCreated(Activity activity, Bundle bundle) {
            OnAppStatusListener a11 = AppStatus.this.f13679f;
            if (a11 != null) {
                a11.onCreated(activity, bundle);
            }
        }

        public void onDestroyed(Activity activity) {
            OnAppStatusListener a11 = AppStatus.this.f13679f;
            if (a11 != null) {
                a11.onDestroyed(activity);
            }
        }

        public void onPaused(Activity activity) {
            OnAppStatusListener a11 = AppStatus.this.f13679f;
            if (a11 != null) {
                a11.onPaused(activity);
            }
        }

        public void onResumed(Activity activity) {
            AppStatus.this.b(false);
            OnAppStatusListener a11 = AppStatus.this.f13679f;
            if (a11 != null) {
                a11.onResumed(activity);
            }
        }

        public void onSaveInstanceState(Activity activity, Bundle bundle) {
            OnAppStatusListener a11 = AppStatus.this.f13679f;
            if (a11 != null) {
                a11.onSaveInstanceState(activity, bundle);
            }
        }

        public void onStarted(Activity activity) {
            OnAppStatusListener a11 = AppStatus.this.f13679f;
            if (a11 != null) {
                a11.onStarted(activity);
            }
        }

        public void onStopped(Activity activity) {
            AppStatus.this.b(true);
            OnAppStatusListener a11 = AppStatus.this.f13679f;
            if (a11 != null) {
                a11.onStopped(activity);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public OnAppStatusListener f13679f;

    public static abstract class OnAppStatusListener implements ActivityTracker.Tracker {
        public abstract void onAppStatusChanged(boolean z11);

        public void onDestroyed(Activity activity) {
        }

        public void onPaused(Activity activity) {
        }

        public void onResumed(Activity activity) {
        }

        public void onSaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onStarted(Activity activity) {
        }

        public void onStopped(Activity activity) {
        }
    }

    private AppStatus() {
        ActivityTracker.getInstance(MobSDK.getContext()).addTracker(this.f13678e);
    }

    private void d() {
        if (f.a()) {
            this.f13676c = 0;
            return;
        }
        this.f13676c = 1;
        f.a(true);
    }

    public boolean b() {
        if (-1 == this.f13676c) {
            synchronized (this) {
                if (-1 == this.f13676c) {
                    d();
                }
            }
        }
        return 1 == this.f13676c;
    }

    public int c() {
        int i11 = this.f13675a;
        if (i11 == 0) {
            int i12 = b() ? 1 : 2;
            this.f13675a = i12;
            return i12;
        } else if (1 != i11 && 2 != i11) {
            return i11;
        } else {
            this.f13675a = 3;
            return 3;
        }
    }

    public static AppStatus a() {
        if (f13674b == null) {
            synchronized (AppStatus.class) {
                if (f13674b == null) {
                    f13674b = new AppStatus();
                }
            }
        }
        return f13674b;
    }

    /* access modifiers changed from: private */
    public void b(boolean z11) {
        boolean z12;
        int i11 = this.f13677d;
        if (-1 == i11) {
            boolean z13 = !a(MobSDK.getContext());
            this.f13677d = z13 ^ true ? 1 : 0;
            a(z13);
            return;
        }
        if ((1 == i11) != z11 && z11 != (!a(MobSDK.getContext()))) {
            this.f13677d = z11 ? 1 : 0;
            a(z12);
        }
    }

    public void a(boolean z11) {
        OnAppStatusListener onAppStatusListener = this.f13679f;
        if (onAppStatusListener != null) {
            onAppStatusListener.onAppStatusChanged(z11);
        }
    }

    private boolean a(Context context) {
        boolean z11 = false;
        try {
            int myPid = Process.myPid();
            Iterator<ActivityManager.RunningAppProcessInfo> it2 = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it2.next();
                if (next.pid == myPid) {
                    if (next.importance == 100) {
                        z11 = true;
                    }
                }
            }
        } catch (Throwable th2) {
            MobLinkLog.getInstance().d(th2);
        }
        return !z11;
    }

    public void a(OnAppStatusListener onAppStatusListener) {
        this.f13679f = onAppStatusListener;
    }
}
