package iq;

import com.hbg.lib.core.network.response.AliTokenStringStatusResponse;
import com.huobi.points.presenter.PointsBuyPresenter;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class m implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PointsBuyPresenter.b f55817b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AliTokenStringStatusResponse f55818c;

    public /* synthetic */ m(PointsBuyPresenter.b bVar, AliTokenStringStatusResponse aliTokenStringStatusResponse) {
        this.f55817b = bVar;
        this.f55818c = aliTokenStringStatusResponse;
    }

    public final void call(Object obj) {
        this.f55817b.d(this.f55818c, (Subscriber) obj);
    }
}
