package ug;

import com.huobi.account.presenter.SecurityLinkStatusPresenter;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import rx.functions.Func1;

public final /* synthetic */ class a0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityLinkStatusPresenter f60572b;

    public /* synthetic */ a0(SecurityLinkStatusPresenter securityLinkStatusPresenter) {
        this.f60572b = securityLinkStatusPresenter;
    }

    public final Object call(Object obj) {
        return this.f60572b.k0((CodeVerifyData) obj);
    }
}
