package dt;

import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class h4 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54046b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observable f54047c;

    public /* synthetic */ h4(a5 a5Var, Observable observable) {
        this.f54046b = a5Var;
        this.f54047c = observable;
    }

    public final Object call(Object obj) {
        return this.f54046b.E0(this.f54047c, (Throwable) obj);
    }
}
