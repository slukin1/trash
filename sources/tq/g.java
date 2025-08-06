package tq;

import com.hbg.lib.core.network.response.IntStatusResponse;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class g implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IntStatusResponse f37345b;

    public /* synthetic */ g(IntStatusResponse intStatusResponse) {
        this.f37345b = intStatusResponse;
    }

    public final void call(Object obj) {
        p.I(this.f37345b, (Subscriber) obj);
    }
}
