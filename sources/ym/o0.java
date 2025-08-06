package ym;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class o0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ o0 f61870b = new o0();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
