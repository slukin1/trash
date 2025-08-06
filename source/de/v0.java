package de;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class v0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ v0 f53621b = new v0();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(15, TimeUnit.SECONDS);
    }
}
