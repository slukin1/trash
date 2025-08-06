package ug;

import com.huobi.account.presenter.SecurityRebindVerifySetup1Presenter;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import rx.functions.Action1;

public final /* synthetic */ class x0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityRebindVerifySetup1Presenter f60660b;

    public /* synthetic */ x0(SecurityRebindVerifySetup1Presenter securityRebindVerifySetup1Presenter) {
        this.f60660b = securityRebindVerifySetup1Presenter;
    }

    public final void call(Object obj) {
        this.f60660b.j0((CodeVerifyData) obj);
    }
}
