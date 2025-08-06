package ug;

import com.huobi.account.presenter.SecurityRebindVerifySetup1Presenter;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import rx.functions.Action1;

public final /* synthetic */ class v0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityRebindVerifySetup1Presenter f60652b;

    public /* synthetic */ v0(SecurityRebindVerifySetup1Presenter securityRebindVerifySetup1Presenter) {
        this.f60652b = securityRebindVerifySetup1Presenter;
    }

    public final void call(Object obj) {
        this.f60652b.l0((CodeVerifyData) obj);
    }
}
