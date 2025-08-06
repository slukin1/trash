package ug;

import com.huobi.account.presenter.SecurityLinkStep2Presenter;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import rx.functions.Func1;

public final /* synthetic */ class i0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityLinkStep2Presenter f60606b;

    public /* synthetic */ i0(SecurityLinkStep2Presenter securityLinkStep2Presenter) {
        this.f60606b = securityLinkStep2Presenter;
    }

    public final Object call(Object obj) {
        return this.f60606b.N0((CodeVerifyData) obj);
    }
}
