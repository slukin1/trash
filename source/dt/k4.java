package dt;

import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class k4 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54085b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observable f54086c;

    public /* synthetic */ k4(a5 a5Var, Observable observable) {
        this.f54085b = a5Var;
        this.f54086c = observable;
    }

    public final Object call(Object obj) {
        return this.f54085b.X0(this.f54086c, (Throwable) obj);
    }
}
