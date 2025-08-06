package ug;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.account.presenter.SecurityLinkStatusPresenter;
import rx.functions.Action1;

public final /* synthetic */ class w implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityLinkStatusPresenter f60656b;

    public /* synthetic */ w(SecurityLinkStatusPresenter securityLinkStatusPresenter) {
        this.f60656b = securityLinkStatusPresenter;
    }

    public final void call(Object obj) {
        this.f60656b.m0((APIStatusErrorException) obj);
    }
}
