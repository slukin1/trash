package com.huawei.hms.stats;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {

    /* renamed from: f  reason: collision with root package name */
    private static final a f38459f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Object f38460a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f38461b = false;

    /* renamed from: c  reason: collision with root package name */
    private final List<Runnable> f38462c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final Handler f38463d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f38464e = new C0516a();

    /* renamed from: com.huawei.hms.stats.a$a  reason: collision with other inner class name */
    public class C0516a implements Runnable {
        public C0516a() {
        }

        public void run() {
            HMSLog.i("AnalyticsCacheManager", "Timeout execCacheBi.");
            if (!HiAnalyticsUtils.getInstance().getInitFlag()) {
                a.this.a();
            } else {
                a.this.b();
            }
        }
    }

    private a() {
    }

    public static a c() {
        return f38459f;
    }

    public void a(Runnable runnable) {
        synchronized (this.f38460a) {
            if (runnable != null) {
                if (!this.f38461b) {
                    if (this.f38462c.size() < 60) {
                        this.f38462c.add(runnable);
                        this.f38463d.removeCallbacks(this.f38464e);
                        this.f38463d.postDelayed(this.f38464e, 10000);
                    }
                }
            }
        }
    }

    public void b() {
        synchronized (this.f38460a) {
            HMSLog.i("AnalyticsCacheManager", "execCacheBi: cache size: " + this.f38462c.size());
            this.f38461b = true;
            try {
                Iterator<Runnable> it2 = this.f38462c.iterator();
                while (it2.hasNext()) {
                    it2.next().run();
                    it2.remove();
                }
            } catch (Throwable th2) {
                HMSLog.e("AnalyticsCacheManager", "<execCacheBi> failed. " + th2.getMessage());
                a();
            }
            this.f38461b = false;
        }
    }

    public void a() {
        synchronized (this.f38460a) {
            HMSLog.i("AnalyticsCacheManager", "clear AnalyticsCache.");
            this.f38462c.clear();
        }
    }
}
