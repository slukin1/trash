package dt;

import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class l4 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54093b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observable f54094c;

    public /* synthetic */ l4(a5 a5Var, Observable observable) {
        this.f54093b = a5Var;
        this.f54094c = observable;
    }

    public final Object call(Object obj) {
        return this.f54093b.Q0(this.f54094c, (Throwable) obj);
    }
}
