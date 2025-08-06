package ug;

import c6.c;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.huobi.account.presenter.AccountPresenter;
import com.huobi.entity.UserTransInfo;

public final /* synthetic */ class h implements c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountPresenter f60601a;

    public /* synthetic */ h(AccountPresenter accountPresenter) {
        this.f60601a = accountPresenter;
    }

    public final void a(Object obj, Object obj2) {
        this.f60601a.I0((UserTransInfo) obj, (UnifyKycInfo) obj2);
    }
}
