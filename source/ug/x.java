package ug;

import com.huobi.account.presenter.SecurityLinkStatusPresenter;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import rx.functions.Action1;

public final /* synthetic */ class x implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityLinkStatusPresenter f60659b;

    public /* synthetic */ x(SecurityLinkStatusPresenter securityLinkStatusPresenter) {
        this.f60659b = securityLinkStatusPresenter;
    }

    public final void call(Object obj) {
        this.f60659b.j0((SecurityStrategySet) obj);
    }
}
