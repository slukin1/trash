package qs;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class x0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ x0 f70462b = new x0();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
