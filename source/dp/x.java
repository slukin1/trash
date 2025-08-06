package dp;

import rx.functions.Func1;

public final /* synthetic */ class x implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f53888b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f53889c;

    public /* synthetic */ x(int i11, int i12) {
        this.f53888b = i11;
        this.f53889c = i12;
    }

    public final Object call(Object obj) {
        return Long.valueOf((((long) this.f53888b) - ((Long) obj).longValue()) + ((long) this.f53889c));
    }
}
