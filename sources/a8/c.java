package a8;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class c implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ c f3494b = new c();

    public final Object call(Object obj) {
        return Observable.just(Arrays.asList(((String) obj).split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
    }
}
