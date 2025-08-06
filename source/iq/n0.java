package iq;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.points.presenter.TransferToMePresenter;
import rx.functions.Action1;

public final /* synthetic */ class n0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ n0 f55821b = new n0();

    public final void call(Object obj) {
        TransferToMePresenter.g0((APIStatusErrorException) obj);
    }
}
