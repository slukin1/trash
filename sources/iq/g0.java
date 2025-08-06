package iq;

import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.points.presenter.TransferToMePresenter;
import rx.functions.Action1;

public final /* synthetic */ class g0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransferToMePresenter f55806b;

    public /* synthetic */ g0(TransferToMePresenter transferToMePresenter) {
        this.f55806b = transferToMePresenter;
    }

    public final void call(Object obj) {
        this.f55806b.r0((CodeVerifyData) obj);
    }
}
