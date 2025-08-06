package bj;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class x1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ x1 f12525b = new x1();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
