package bn;

import rx.functions.Func1;

public final /* synthetic */ class g0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f12825b;

    public /* synthetic */ g0(long j11) {
        this.f12825b = j11;
    }

    public final Object call(Object obj) {
        return Long.valueOf(this.f12825b - (((Long) obj).longValue() * 1000));
    }
}
