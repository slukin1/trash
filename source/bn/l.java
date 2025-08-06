package bn;

import rx.functions.Func1;

public final /* synthetic */ class l implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f12834b;

    public /* synthetic */ l(long j11) {
        this.f12834b = j11;
    }

    public final Object call(Object obj) {
        return Long.valueOf(this.f12834b - (((Long) obj).longValue() * 1000));
    }
}
