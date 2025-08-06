package bj;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class u1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ u1 f12504b = new u1();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
