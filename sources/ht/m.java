package ht;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class m implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ m f54990b = new m();

    public final Object call(Object obj) {
        return ((Observable) obj).delay(10, TimeUnit.SECONDS);
    }
}
