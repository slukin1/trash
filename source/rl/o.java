package rl;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class o implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ o f25757b = new o();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(10, TimeUnit.MINUTES);
    }
}
