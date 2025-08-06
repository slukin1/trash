package ss;

import rx.functions.Func1;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f26156b;

    public /* synthetic */ g(long j11) {
        this.f26156b = j11;
    }

    public final Object call(Object obj) {
        return Long.valueOf(this.f26156b - (((Long) obj).longValue() * 1000));
    }
}
