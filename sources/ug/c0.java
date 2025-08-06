package ug;

import com.huobi.account.presenter.SecurityLinkStep2Presenter;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import rx.functions.Action1;

public final /* synthetic */ class c0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityLinkStep2Presenter f60580b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60581c;

    public /* synthetic */ c0(SecurityLinkStep2Presenter securityLinkStep2Presenter, String str) {
        this.f60580b = securityLinkStep2Presenter;
        this.f60581c = str;
    }

    public final void call(Object obj) {
        this.f60580b.C0(this.f60581c, (CodeVerifyData) obj);
    }
}
