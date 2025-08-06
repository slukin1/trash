package st;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class y implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ y f29253b = new y();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5, TimeUnit.SECONDS);
    }
}
