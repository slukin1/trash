package com.tencent.wxop.stat;

import com.tencent.wxop.stat.b.l;
import java.util.TimerTask;

final class ag extends TimerTask {

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ af f50965de;

    public ag(af afVar) {
        this.f50965de = afVar;
    }

    public final void run() {
        if (c.k()) {
            l.av().b((Object) "TimerTask run");
        }
        e.q(this.f50965de.f50964h);
        cancel();
        this.f50965de.ah();
    }
}
