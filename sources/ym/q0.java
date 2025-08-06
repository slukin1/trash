package ym;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class q0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ q0 f61874b = new q0();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
