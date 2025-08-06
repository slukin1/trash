package bn;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class v implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ v f12853b = new v();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
