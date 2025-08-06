package ug;

import com.huobi.account.presenter.SecurityLinkStep2Presenter;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import rx.functions.Func1;

public final /* synthetic */ class h0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityLinkStep2Presenter f60602b;

    public /* synthetic */ h0(SecurityLinkStep2Presenter securityLinkStep2Presenter) {
        this.f60602b = securityLinkStep2Presenter;
    }

    public final Object call(Object obj) {
        return this.f60602b.J0((CodeVerifyData) obj);
    }
}
