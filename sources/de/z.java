package de;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class z implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ z f53628b = new z();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
