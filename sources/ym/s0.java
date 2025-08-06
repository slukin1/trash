package ym;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class s0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ s0 f61882b = new s0();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
