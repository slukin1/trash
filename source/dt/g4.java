package dt;

import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class g4 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54034b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observable f54035c;

    public /* synthetic */ g4(a5 a5Var, Observable observable) {
        this.f54034b = a5Var;
        this.f54035c = observable;
    }

    public final Object call(Object obj) {
        return this.f54034b.m1(this.f54035c, (Throwable) obj);
    }
}
