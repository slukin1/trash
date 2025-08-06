package ug;

import com.huobi.account.presenter.SecuritySetPresenter;
import com.huobi.login.usercenter.data.source.bean.SecuritySetData;
import rx.functions.Action1;

public final /* synthetic */ class s1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecuritySetPresenter f60644b;

    public /* synthetic */ s1(SecuritySetPresenter securitySetPresenter) {
        this.f60644b = securitySetPresenter;
    }

    public final void call(Object obj) {
        this.f60644b.Y((SecuritySetData) obj);
    }
}
