package rt;

import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class q0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f25866b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observable f25867c;

    public /* synthetic */ q0(d1 d1Var, Observable observable) {
        this.f25866b = d1Var;
        this.f25867c = observable;
    }

    public final Object call(Object obj) {
        return this.f25866b.V(this.f25867c, (Throwable) obj);
    }
}
