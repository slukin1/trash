package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.l;
import java.util.Timer;

public class af {

    /* renamed from: dd  reason: collision with root package name */
    private static volatile af f50962dd;

    /* renamed from: dc  reason: collision with root package name */
    private Timer f50963dc = null;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Context f50964h = null;

    private af(Context context) {
        this.f50964h = context.getApplicationContext();
        this.f50963dc = new Timer(false);
    }

    public static af Y(Context context) {
        if (f50962dd == null) {
            synchronized (af.class) {
                if (f50962dd == null) {
                    f50962dd = new af(context);
                }
            }
        }
        return f50962dd;
    }

    public final void ah() {
        if (c.j() == d.PERIOD) {
            long u11 = (long) (c.u() * 60 * 1000);
            if (c.k()) {
                b av2 = l.av();
                av2.b((Object) "setupPeriodTimer delay:" + u11);
            }
            ag agVar = new ag(this);
            if (this.f50963dc != null) {
                if (c.k()) {
                    b av3 = l.av();
                    av3.b((Object) "setupPeriodTimer schedule delay:" + u11);
                }
                this.f50963dc.schedule(agVar, u11);
            } else if (c.k()) {
                l.av().c("setupPeriodTimer schedule timer == null");
            }
        }
    }
}
