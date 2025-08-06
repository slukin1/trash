package st;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class l0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ l0 f29225b = new l0();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5, TimeUnit.SECONDS);
    }
}
