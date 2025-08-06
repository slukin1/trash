package ug;

import com.hbg.lib.network.hbg.core.bean.SubscribeBox;
import com.huobi.account.presenter.AccountPresenter;
import rx.functions.Action1;

public final /* synthetic */ class k implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscribeBox.MySubscribeBean f60611b;

    public /* synthetic */ k(SubscribeBox.MySubscribeBean mySubscribeBean) {
        this.f60611b = mySubscribeBean;
    }

    public final void call(Object obj) {
        AccountPresenter.V0(this.f60611b, (Void) obj);
    }
}
