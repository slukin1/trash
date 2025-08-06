package e9;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RequestCallback1 f54306b;

    public /* synthetic */ b(RequestCallback1 requestCallback1) {
        this.f54306b = requestCallback1;
    }

    public final void call(Object obj) {
        BaseEasySubscriber.i(this.f54306b, (APIStatusErrorException) obj);
    }
}
