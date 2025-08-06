package bn;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class x implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ x f12855b = new x();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
