package ug;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.account.presenter.UpdateOtcTradePwdPresenter;
import rx.functions.Action1;

public final /* synthetic */ class a2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UpdateOtcTradePwdPresenter f60574b;

    public /* synthetic */ a2(UpdateOtcTradePwdPresenter updateOtcTradePwdPresenter) {
        this.f60574b = updateOtcTradePwdPresenter;
    }

    public final void call(Object obj) {
        this.f60574b.m0((APIStatusErrorException) obj);
    }
}
