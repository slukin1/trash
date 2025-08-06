package e9;

import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RequestCallback1 f54307b;

    public /* synthetic */ c(RequestCallback1 requestCallback1) {
        this.f54307b = requestCallback1;
    }

    public final void call(Object obj) {
        BaseEasySubscriber.j(this.f54307b, (Throwable) obj);
    }
}
