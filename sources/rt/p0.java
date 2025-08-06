package rt;

import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class p0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f25863b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observable f25864c;

    public /* synthetic */ p0(d1 d1Var, Observable observable) {
        this.f25863b = d1Var;
        this.f25864c = observable;
    }

    public final Object call(Object obj) {
        return this.f25863b.e0(this.f25864c, (Throwable) obj);
    }
}
