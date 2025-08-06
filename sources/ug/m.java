package ug;

import com.hbg.lib.network.hbg.core.bean.CustomerData;
import com.huobi.account.presenter.AccountPresenter;
import rx.functions.Action1;

public final /* synthetic */ class m implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccountPresenter f60617b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CustomerData f60618c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f60619d;

    public /* synthetic */ m(AccountPresenter accountPresenter, CustomerData customerData, String str) {
        this.f60617b = accountPresenter;
        this.f60618c = customerData;
        this.f60619d = str;
    }

    public final void call(Object obj) {
        this.f60617b.T0(this.f60618c, this.f60619d, (Void) obj);
    }
}
