package bn;

import rx.functions.Func1;

public final /* synthetic */ class w implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f12854b;

    public /* synthetic */ w(long j11) {
        this.f12854b = j11;
    }

    public final Object call(Object obj) {
        return Long.valueOf(this.f12854b - (((Long) obj).longValue() * 1000));
    }
}
