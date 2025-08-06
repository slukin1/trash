package vu;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.a0;
import androidx.lifecycle.u;
import com.huobi.woodpecker.model.AppNewBehaviorRecord;
import com.huobi.woodpecker.utils.RecordUtil;
import fv.f;
import kv.e;
import wu.c;

public class a implements u, f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f23405c = new a();

    /* renamed from: b  reason: collision with root package name */
    public boolean f23406b = false;

    public static a a() {
        return f23405c;
    }

    public void b(f.b bVar) {
        long j11 = bVar.f22791d - bVar.f22790c;
        if (j11 >= 1000000000) {
            c.b(new AppNewBehaviorRecord.BlockUiBehavior(((long) (((float) j11) - bVar.b())) / 1000000).create());
        }
    }

    @a0(Lifecycle.Event.ON_STOP)
    public void onBackground() {
        e.m("WP_ApplicationLifecycleListener", "onBackground");
        d.k().e();
        f.m().o(this);
        c.b(new AppNewBehaviorRecord.BackgroundBehavior().create());
    }

    @a0(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        this.f23406b = true;
        e.m("WP_ApplicationLifecycleListener", "onCreate!!!");
    }

    @a0(Lifecycle.Event.ON_START)
    public void onForeground() {
        f.m().n(this);
        if (this.f23406b) {
            e.m("WP_ApplicationLifecycleListener", "onForeground first no refresh config!");
            this.f23406b = false;
            c.b(new AppNewBehaviorRecord.ForegroundBehavior().create());
            return;
        }
        RecordUtil.c();
        c.b(new AppNewBehaviorRecord.ForegroundBehavior().create());
        e.m("WP_ApplicationLifecycleListener", "onForeground");
        d.k().f();
    }
}
