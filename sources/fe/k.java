package fe;

import com.hbg.module.kline.view.KlineViewWrapper;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class k implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KlineViewWrapper f54494b;

    public /* synthetic */ k(KlineViewWrapper klineViewWrapper) {
        this.f54494b = klineViewWrapper;
    }

    public final void call(Object obj) {
        this.f54494b.t((Subscriber) obj);
    }
}
