package st;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class j0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ j0 f29220b = new j0();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(3000, TimeUnit.MILLISECONDS);
    }
}
