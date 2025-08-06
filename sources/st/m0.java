package st;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class m0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ m0 f29227b = new m0();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(15, TimeUnit.SECONDS);
    }
}
