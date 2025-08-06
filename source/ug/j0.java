package ug;

import com.huobi.account.presenter.SecurityLinkStep2Presenter;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import rx.functions.Func1;

public final /* synthetic */ class j0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityLinkStep2Presenter f60609b;

    public /* synthetic */ j0(SecurityLinkStep2Presenter securityLinkStep2Presenter) {
        this.f60609b = securityLinkStep2Presenter;
    }

    public final Object call(Object obj) {
        return this.f60609b.I0((CodeVerifyData) obj);
    }
}
