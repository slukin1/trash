package cj;

import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f13087b;

    public /* synthetic */ a(long j11) {
        this.f13087b = j11;
    }

    public final Object call(Object obj) {
        return Long.valueOf(this.f13087b - (((Long) obj).longValue() * 1000));
    }
}
