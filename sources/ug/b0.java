package ug;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.account.presenter.SecurityLinkStep2Presenter;
import rx.functions.Action1;

public final /* synthetic */ class b0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityLinkStep2Presenter f60576b;

    public /* synthetic */ b0(SecurityLinkStep2Presenter securityLinkStep2Presenter) {
        this.f60576b = securityLinkStep2Presenter;
    }

    public final void call(Object obj) {
        this.f60576b.D0((APIStatusErrorException) obj);
    }
}
