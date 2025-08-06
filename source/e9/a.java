package e9;

import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import rx.functions.Action0;

public final /* synthetic */ class a implements Action0 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RequestCallback1 f54305b;

    public /* synthetic */ a(RequestCallback1 requestCallback1) {
        this.f54305b = requestCallback1;
    }

    public final void call() {
        BaseEasySubscriber.g(this.f54305b);
    }
}
