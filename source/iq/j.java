package iq;

import com.huobi.points.entity.Points;
import com.huobi.points.presenter.PointsBuyPresenter;
import rx.functions.Action1;

public final /* synthetic */ class j implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PointsBuyPresenter f55811b;

    public /* synthetic */ j(PointsBuyPresenter pointsBuyPresenter) {
        this.f55811b = pointsBuyPresenter;
    }

    public final void call(Object obj) {
        this.f55811b.j0((Points) obj);
    }
}
