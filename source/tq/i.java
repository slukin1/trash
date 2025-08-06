package tq;

import com.hbg.lib.core.network.response.StringStatusResponse;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class i implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StringStatusResponse f37347b;

    public /* synthetic */ i(StringStatusResponse stringStatusResponse) {
        this.f37347b = stringStatusResponse;
    }

    public final void call(Object obj) {
        p.O(this.f37347b, (Subscriber) obj);
    }
}
