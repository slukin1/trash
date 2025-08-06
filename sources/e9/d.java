package e9;

import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RequestCallback1 f54308b;

    public /* synthetic */ d(RequestCallback1 requestCallback1) {
        this.f54308b = requestCallback1;
    }

    public final void call(Object obj) {
        BaseEasySubscriber.h(this.f54308b, obj);
    }
}
