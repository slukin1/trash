package ug;

import com.hbg.lib.network.hbg.core.bean.CustomerData;
import com.huobi.account.presenter.AccountPresenter;
import rx.functions.Action1;

public final /* synthetic */ class o implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccountPresenter f60628b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60629c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CustomerData f60630d;

    public /* synthetic */ o(AccountPresenter accountPresenter, String str, CustomerData customerData) {
        this.f60628b = accountPresenter;
        this.f60629c = str;
        this.f60630d = customerData;
    }

    public final void call(Object obj) {
        this.f60628b.S0(this.f60629c, this.f60630d, (Void) obj);
    }
}
