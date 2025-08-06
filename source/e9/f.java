package e9;

import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RequestCallback1 f54310b;

    public /* synthetic */ f(RequestCallback1 requestCallback1) {
        this.f54310b = requestCallback1;
    }

    public final Object call(Object obj) {
        return RxJavaHelper.d(this.f54310b, obj);
    }
}
