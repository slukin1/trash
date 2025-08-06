package ug;

import com.huobi.account.presenter.UpdateOtcTradePwdPresenter;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import rx.functions.Action1;

public final /* synthetic */ class b2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UpdateOtcTradePwdPresenter f60578b;

    public /* synthetic */ b2(UpdateOtcTradePwdPresenter updateOtcTradePwdPresenter) {
        this.f60578b = updateOtcTradePwdPresenter;
    }

    public final void call(Object obj) {
        this.f60578b.h0((SecurityStrategySet) obj);
    }
}
