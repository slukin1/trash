package iq;

import com.hbg.lib.core.network.response.AliTokenStringStatusResponse;
import com.huobi.points.presenter.PointsBuyPresenter;
import rx.functions.Func1;

public final /* synthetic */ class n implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PointsBuyPresenter.b f55820b;

    public /* synthetic */ n(PointsBuyPresenter.b bVar) {
        this.f55820b = bVar;
    }

    public final Object call(Object obj) {
        return this.f55820b.e((AliTokenStringStatusResponse) obj);
    }
}
