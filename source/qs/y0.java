package qs;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class y0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ y0 f70466b = new y0();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
