package dt;

import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class j4 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54071b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observable f54072c;

    public /* synthetic */ j4(a5 a5Var, Observable observable) {
        this.f54071b = a5Var;
        this.f54072c = observable;
    }

    public final Object call(Object obj) {
        return this.f54071b.K0(this.f54072c, (Throwable) obj);
    }
}
