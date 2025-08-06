package ug;

import com.huobi.account.presenter.UpdateOtcTradePwdPresenter;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import rx.functions.Action1;

public final /* synthetic */ class c2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UpdateOtcTradePwdPresenter f60583b;

    public /* synthetic */ c2(UpdateOtcTradePwdPresenter updateOtcTradePwdPresenter) {
        this.f60583b = updateOtcTradePwdPresenter;
    }

    public final void call(Object obj) {
        this.f60583b.i0((UserSecurityInfoData) obj);
    }
}
