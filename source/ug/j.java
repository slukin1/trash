package ug;

import com.hbg.lib.network.hbg.core.bean.AccountTaskResp;
import com.huobi.account.presenter.AccountPresenter;
import rx.functions.Action1;

public final /* synthetic */ class j implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccountTaskResp f60608b;

    public /* synthetic */ j(AccountTaskResp accountTaskResp) {
        this.f60608b = accountTaskResp;
    }

    public final void call(Object obj) {
        AccountPresenter.R0(this.f60608b, (Void) obj);
    }
}
