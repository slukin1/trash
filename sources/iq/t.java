package iq;

import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.points.presenter.PointsTransferPresenter;
import rx.functions.Action1;

public final /* synthetic */ class t implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PointsTransferPresenter f55832b;

    public /* synthetic */ t(PointsTransferPresenter pointsTransferPresenter) {
        this.f55832b = pointsTransferPresenter;
    }

    public final void call(Object obj) {
        this.f55832b.l0((TradeRiskReminder) obj);
    }
}
