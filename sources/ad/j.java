package ad;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class j implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ j f3527b = new j();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(5000, TimeUnit.MILLISECONDS);
    }
}
