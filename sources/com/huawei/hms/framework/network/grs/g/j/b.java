package com.huawei.hms.framework.network.grs.g.j;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.g.d;
import java.util.concurrent.Future;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Future<d> f38082a;

    /* renamed from: b  reason: collision with root package name */
    private final long f38083b = SystemClock.elapsedRealtime();

    public b(Future<d> future) {
        this.f38082a = future;
    }

    public Future<d> a() {
        return this.f38082a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.f38083b <= 300000;
    }
}
