package com.sumsub.sns.internal.core.common;

import android.os.SystemClock;
import d10.a;
import java.util.ArrayList;
import kotlin.Unit;

public final class b1 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Long> f31992a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f31993b = true;

    public final long a(a<Unit> aVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        aVar.invoke();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        this.f31992a.add(Long.valueOf(elapsedRealtime2));
        this.f31993b = false;
        return elapsedRealtime2;
    }

    public final void b() {
        if (!this.f31993b) {
            CollectionsKt__MutableCollectionsJVMKt.y(this.f31992a);
            this.f31993b = true;
        }
    }

    public final long c() {
        return a(50.0d);
    }

    public final long d() {
        return a(100.0d);
    }

    public final long e() {
        return a(99.0d);
    }

    public final void f() {
        this.f31992a.clear();
        this.f31993b = true;
    }

    public final Object a() {
        Double valueOf = Double.valueOf(CollectionsKt___CollectionsKt.Q(this.f31992a));
        if (!(!Double.isNaN(valueOf.doubleValue()))) {
            valueOf = null;
        }
        if (valueOf == null) {
            return -1;
        }
        return valueOf;
    }

    public final long a(double d11) {
        b();
        int a11 = MathKt__MathJVMKt.a((d11 / 100.0d) * ((double) (this.f31992a.size() - 1)));
        ArrayList<Long> arrayList = this.f31992a;
        return ((a11 < 0 || a11 > CollectionsKt__CollectionsKt.m(arrayList)) ? -1L : arrayList.get(a11)).longValue();
    }
}
