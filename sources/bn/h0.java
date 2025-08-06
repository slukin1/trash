package bn;

import rx.functions.Func1;

public final /* synthetic */ class h0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f12827b;

    public /* synthetic */ h0(long j11) {
        this.f12827b = j11;
    }

    public final Object call(Object obj) {
        return Long.valueOf(this.f12827b - (((Long) obj).longValue() * 1000));
    }
}
