package fv;

import android.util.Log;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.monitor.NewUserMonitor;
import kv.e;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f22793a = "g";

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final g f22794a = new g();
    }

    public static g c() {
        return b.f22794a;
    }

    public void a() {
        Log.d(f22793a, "HBWP::: appStart");
        f.m().f();
        ActionType.APP_START.register(d.h());
        ActionType.APP_NEW_USER.register(NewUserMonitor.c());
    }

    public void b(ActionType actionType) {
        if (actionType != null) {
            actionType.unRegisterAll();
        }
    }

    public void d() {
        e.c(f22793a, "HBWP::: sdkInit");
        ActionType.APP_START.register(d.h(), false);
        ActionType.APP_USER_BEHAVIOUR.register(b.h());
        ActionType.APP_ACTION_PERF.register(e.n());
        ActionType.APP_PAGE_PERF.register(c.i());
        ActionType.APP_PAGE_VIEW.register(a.h());
    }

    public g() {
    }
}
