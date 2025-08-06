package de;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class i0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ i0 f53602b = new i0();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(15, TimeUnit.SECONDS);
    }
}
