package fv;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.huobi.woodpecker.model.AppNewBehaviorRecord;
import com.huobi.woodpecker.model.AppPageRecord;
import com.huobi.woodpecker.monitor.base.BaseLifecycleMonitor;
import com.huobi.woodpecker.utils.RecordUtil;
import java.util.Map;
import java.util.WeakHashMap;
import kv.e;
import vu.g;

public class c extends BaseLifecycleMonitor {

    /* renamed from: d  reason: collision with root package name */
    public static final String f22759d = c.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public final Map<Activity, AppPageRecord> f22760c;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AppPageRecord f22761b;

        public a(AppPageRecord appPageRecord) {
            this.f22761b = appPageRecord;
        }

        public void run() {
            iv.a.e().g();
            ((AppPageRecord.AppPageRecordData) this.f22761b.getData()).setStartMemory(iv.a.e().f());
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AppPageRecord f22763b;

        public b(AppPageRecord appPageRecord) {
            this.f22763b = appPageRecord;
        }

        public void run() {
            if (((AppPageRecord.AppPageRecordData) this.f22763b.getData()).getStartMemory() > 0.0f) {
                iv.a.e().g();
                ((AppPageRecord.AppPageRecordData) this.f22763b.getData()).setEndMemory(iv.a.e().f());
                long onCreatedTimeMs = ((AppPageRecord.AppPageRecordData) this.f22763b.getData()).getOnCreatedTimeMs();
                ((AppPageRecord.AppPageRecordData) this.f22763b.getData()).setPageLoadTimeMs(((AppPageRecord.AppPageRecordData) this.f22763b.getData()).getOnResumedTimeMs() - onCreatedTimeMs);
                RecordUtil.a(this.f22763b);
                if (e.l()) {
                    e.k(c.f22759d, "QA:" + "page=" + ((AppPageRecord.AppPageRecordData) this.f22763b.getData()).getPageName() + " , action=" + this.f22763b.getAction().action + " , startTime=" + ((AppPageRecord.AppPageRecordData) this.f22763b.getData()).getOnCreatedTimeMs() + " , endTime=" + ((AppPageRecord.AppPageRecordData) this.f22763b.getData()).getOnResumedTimeMs() + " , costTime=" + ((AppPageRecord.AppPageRecordData) this.f22763b.getData()).getPageLoadTimeMs());
                }
                wu.c.b(this.f22763b);
            }
        }
    }

    /* renamed from: fv.c$c  reason: collision with other inner class name */
    public static class C0186c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f22765a = new c((a) null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c i() {
        return C0186c.f22765a;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        super.onActivityCreated(activity, bundle);
        if (activity != null) {
            AppPageRecord appPageRecord = new AppPageRecord();
            ((AppPageRecord.AppPageRecordData) appPageRecord.getData()).setPageName(activity.getClass().getName());
            ((AppPageRecord.AppPageRecordData) appPageRecord.getData()).setOnCreatedTimeMs(SystemClock.elapsedRealtime());
            this.f22760c.put(activity, appPageRecord);
            g.d().i(new a(appPageRecord));
            e.c(f22759d, "ActivityLaunchMonitor#onActivityCreated");
        }
    }

    public void onActivityDestroyed(Activity activity) {
        super.onActivityDestroyed(activity);
        if (activity != null && this.f22760c.get(activity) != null) {
            this.f22760c.remove(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        super.onActivityPaused(activity);
        wu.c.b(new AppNewBehaviorRecord.PageExitBehavior(activity.getClass().getSimpleName()).create());
    }

    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        if (activity != null) {
            AppPageRecord appPageRecord = this.f22760c.get(activity);
            if (appPageRecord != null) {
                this.f22760c.remove(activity);
                ((AppPageRecord.AppPageRecordData) appPageRecord.getData()).setOnResumedTimeMs(SystemClock.elapsedRealtime());
                g.d().i(new b(appPageRecord));
                String str = f22759d;
                e.c(str, "ActivityLaunchMonitor#onActivityResumed " + appPageRecord.toString());
            }
            wu.c.b(new AppNewBehaviorRecord.PageEnterBehavior(activity.getClass().getSimpleName()).create());
        }
    }

    public c() {
        this.f22760c = new WeakHashMap();
    }
}
