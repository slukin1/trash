package tq;

import com.hbg.lib.core.network.response.StringStatusResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e f37343b = new e();

    public final Object call(Object obj) {
        return Observable.create(new i((StringStatusResponse) obj));
    }
}
