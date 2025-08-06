package iq;

import com.huobi.points.presenter.PointsTransferPresenter;
import rx.functions.Action1;

public final /* synthetic */ class u implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PointsTransferPresenter f55833b;

    public /* synthetic */ u(PointsTransferPresenter pointsTransferPresenter) {
        this.f55833b = pointsTransferPresenter;
    }

    public final void call(Object obj) {
        this.f55833b.k0((Long) obj);
    }
}
