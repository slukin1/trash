package ls;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e f58063b = new e();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(3000, TimeUnit.MILLISECONDS);
    }
}
