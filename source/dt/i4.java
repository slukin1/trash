package dt;

import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class i4 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54058b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observable f54059c;

    public /* synthetic */ i4(a5 a5Var, Observable observable) {
        this.f54058b = a5Var;
        this.f54059c = observable;
    }

    public final Object call(Object obj) {
        return this.f54058b.z0(this.f54059c, (Throwable) obj);
    }
}
