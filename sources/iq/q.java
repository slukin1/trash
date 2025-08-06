package iq;

import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.points.presenter.PointsTransferPresenter;
import rx.functions.Action1;

public final /* synthetic */ class q implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PointsTransferPresenter f55827b;

    public /* synthetic */ q(PointsTransferPresenter pointsTransferPresenter) {
        this.f55827b = pointsTransferPresenter;
    }

    public final void call(Object obj) {
        this.f55827b.m0((CodeVerifyData) obj);
    }
}
