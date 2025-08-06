package ug;

import com.huobi.account.presenter.SecurityLinkStep2Presenter;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import rx.functions.Action1;

public final /* synthetic */ class q0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityLinkStep2Presenter f60637b;

    public /* synthetic */ q0(SecurityLinkStep2Presenter securityLinkStep2Presenter) {
        this.f60637b = securityLinkStep2Presenter;
    }

    public final void call(Object obj) {
        this.f60637b.z0((CodeVerifyData) obj);
    }
}
