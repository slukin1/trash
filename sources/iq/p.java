package iq;

import com.huobi.points.entity.Points;
import com.huobi.points.entity.PointsAction;
import com.huobi.points.presenter.PointsHistoryDetailsPresenter;
import rx.functions.Action1;

public final /* synthetic */ class p implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PointsHistoryDetailsPresenter f55824b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PointsAction f55825c;

    public /* synthetic */ p(PointsHistoryDetailsPresenter pointsHistoryDetailsPresenter, PointsAction pointsAction) {
        this.f55824b = pointsHistoryDetailsPresenter;
        this.f55825c = pointsAction;
    }

    public final void call(Object obj) {
        this.f55824b.R(this.f55825c, (Points) obj);
    }
}
