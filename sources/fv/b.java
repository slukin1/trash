package fv;

import android.app.Activity;
import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.a0;
import androidx.lifecycle.c0;
import androidx.lifecycle.u;
import com.huobi.woodpecker.model.AppPageBehaviorRecord;
import com.huobi.woodpecker.monitor.base.BaseLifecycleMonitor;
import com.huobi.woodpecker.utils.RecordUtil;
import fv.f;
import kv.e;
import wu.c;

public class b extends BaseLifecycleMonitor implements u, f.a {

    /* renamed from: g  reason: collision with root package name */
    public static final String f22753g = b.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    public static final b f22754h = new b();

    /* renamed from: c  reason: collision with root package name */
    public boolean f22755c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22756d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22757e = true;

    /* renamed from: f  reason: collision with root package name */
    public AppPageBehaviorRecord f22758f;

    public static b h() {
        return f22754h;
    }

    public void b(f.b bVar) {
        float f11 = (float) (bVar.f22791d - bVar.f22790c);
        if (f11 > bVar.b()) {
            long b11 = (long) (f11 - bVar.b());
            AppPageBehaviorRecord appPageBehaviorRecord = this.f22758f;
            if (appPageBehaviorRecord != null) {
                ((AppPageBehaviorRecord.AppPageBehaviorRecordData) appPageBehaviorRecord.getData()).addBlockDelta(b11);
            }
        }
    }

    public void d() {
        super.d();
        c0.l().getLifecycle().a(this);
    }

    public void e() {
        super.e();
        c0.l().getLifecycle().d(this);
    }

    public final void i() {
        AppPageBehaviorRecord appPageBehaviorRecord = new AppPageBehaviorRecord();
        this.f22758f = appPageBehaviorRecord;
        ((AppPageBehaviorRecord.AppPageBehaviorRecordData) appPageBehaviorRecord.getData()).setCb(this.f22756d);
        ((AppPageBehaviorRecord.AppPageBehaviorRecordData) this.f22758f.getData()).setSt(System.currentTimeMillis());
        f.m().n(this);
    }

    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        if (this.f22758f == null) {
            i();
        }
        AppPageBehaviorRecord.DataBehavior dataBehavior = new AppPageBehaviorRecord.DataBehavior();
        dataBehavior.setPageName(activity.getClass().getName());
        dataBehavior.setSt(SystemClock.elapsedRealtime());
        dataBehavior.setHashCode(activity.hashCode());
        ((AppPageBehaviorRecord.AppPageBehaviorRecordData) this.f22758f.getData()).getBhvr().add(dataBehavior);
        String str = f22753g;
        e.c(str, activity.hashCode() + " onActivityResumed " + activity.getClass().getSimpleName() + " " + dataBehavior.getSt());
    }

    public void onActivityStopped(Activity activity) {
        super.onActivityStopped(activity);
        AppPageBehaviorRecord appPageBehaviorRecord = this.f22758f;
        if (appPageBehaviorRecord != null) {
            for (int size = ((AppPageBehaviorRecord.AppPageBehaviorRecordData) appPageBehaviorRecord.getData()).getBhvr().size() - 1; size >= 0; size--) {
                AppPageBehaviorRecord.DataBehavior dataBehavior = ((AppPageBehaviorRecord.AppPageBehaviorRecordData) this.f22758f.getData()).getBhvr().get(size);
                if (dataBehavior.getHashCode() == activity.hashCode()) {
                    dataBehavior.setEt(SystemClock.elapsedRealtime());
                    if (e.l()) {
                        e.k(f22753g, "QA:" + "page=" + dataBehavior.getPageName() + " , action=" + this.f22758f.getAction() + " , startTime=" + dataBehavior.getSt() + " , endTime=" + dataBehavior.getEt() + " , costTime=" + (dataBehavior.getEt() - dataBehavior.getSt()));
                        return;
                    }
                    return;
                }
            }
        }
    }

    @a0(Lifecycle.Event.ON_STOP)
    public void onBackground() {
        this.f22757e = true;
        if (this.f22758f != null) {
            f.m().o(this);
            ((AppPageBehaviorRecord.AppPageBehaviorRecordData) this.f22758f.getData()).setEt(System.currentTimeMillis());
            RecordUtil.a(this.f22758f);
            c.b(this.f22758f);
        }
    }

    @a0(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        this.f22755c = true;
        e.m(f22753g, "onCreate!!!");
    }

    @a0(Lifecycle.Event.ON_START)
    public void onForeground() {
        if (this.f22755c) {
            this.f22755c = false;
            this.f22756d = true;
        } else {
            this.f22756d = false;
        }
        this.f22757e = true;
        i();
    }
}
