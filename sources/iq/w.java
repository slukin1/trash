package iq;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.points.presenter.PointsTransferPresenter;
import rx.functions.Action1;

public final /* synthetic */ class w implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ w f55835b = new w();

    public final void call(Object obj) {
        PointsTransferPresenter.g0((APIStatusErrorException) obj);
    }
}
