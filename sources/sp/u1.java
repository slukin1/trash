package sp;

import rx.functions.Func1;

public final /* synthetic */ class u1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f26096b;

    public /* synthetic */ u1(long j11) {
        this.f26096b = j11;
    }

    public final Object call(Object obj) {
        return Long.valueOf(this.f26096b - ((Long) obj).longValue());
    }
}
