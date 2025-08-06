package bj;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class v1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ v1 f12513b = new v1();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
