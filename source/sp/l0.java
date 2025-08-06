package sp;

import rx.functions.Func1;

public final /* synthetic */ class l0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f26043b;

    public /* synthetic */ l0(int i11) {
        this.f26043b = i11;
    }

    public final Object call(Object obj) {
        return Long.valueOf(((long) this.f26043b) - ((Long) obj).longValue());
    }
}
