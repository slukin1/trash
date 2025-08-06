package de;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class g1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ g1 f53598b = new g1();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
