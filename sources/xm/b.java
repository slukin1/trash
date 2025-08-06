package xm;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.huobi.lifecycle.PagePathRecordEvent;
import com.huobi.utils.e0;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tg.r;

public class b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e  reason: collision with root package name */
    public static final b f76816e = new b();

    /* renamed from: f  reason: collision with root package name */
    public static final SimpleDateFormat f76817f = new SimpleDateFormat("MM-ddHH:mm");

    /* renamed from: b  reason: collision with root package name */
    public long f76818b;

    /* renamed from: c  reason: collision with root package name */
    public long f76819c;

    /* renamed from: d  reason: collision with root package name */
    public e0<PagePathRecordEvent> f76820d = new e0<>(30);

    public static b a() {
        return f76816e;
    }

    public final String b(Activity activity) {
        String localClassName = activity.getLocalClassName();
        try {
            List asList = Arrays.asList(activity.getLocalClassName().split("\\."));
            return (String) asList.get(asList.size() - 1);
        } catch (Exception e11) {
            e11.printStackTrace();
            return localClassName;
        }
    }

    public final void c(String str, String str2, long j11) {
        PagePathRecordEvent pagePathRecordEvent = new PagePathRecordEvent();
        pagePathRecordEvent.e(f76817f.format(new Date()));
        pagePathRecordEvent.c(str);
        pagePathRecordEvent.b(str2);
        pagePathRecordEvent.d(r.x().F0() ^ true ? 1 : 0);
        pagePathRecordEvent.a(j11);
        this.f76820d.offer(pagePathRecordEvent);
    }

    public void d() {
        this.f76818b = 0;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        c(b(activity), "Created", -1);
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.f76819c = System.currentTimeMillis();
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        long max = Math.max(System.currentTimeMillis() - this.f76819c, this.f76818b);
        this.f76818b = max;
        if (max > 600000) {
            d();
        }
        c(b(activity), "Started", TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - this.f76819c));
    }

    public void onActivityStopped(Activity activity) {
        c(b(activity), "Stopped", -1);
    }
}
