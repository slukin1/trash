package et;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class r implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ r f54448b = new r();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(3000, TimeUnit.MILLISECONDS);
    }
}
