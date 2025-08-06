package de;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class y implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ y f53626b = new y();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
