package bj;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class t1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ t1 f12499b = new t1();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
