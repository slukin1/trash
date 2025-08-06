package ug;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.SubscribeBox;
import com.huobi.account.presenter.AccountPresenter;
import rx.functions.Action1;

public final /* synthetic */ class n implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccountPresenter f60622b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SubscribeBox.MySubscribeBean f60623c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SubscribeBox.ListBean f60624d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f60625e;

    public /* synthetic */ n(AccountPresenter accountPresenter, SubscribeBox.MySubscribeBean mySubscribeBean, SubscribeBox.ListBean listBean, View view) {
        this.f60622b = accountPresenter;
        this.f60623c = mySubscribeBean;
        this.f60624d = listBean;
        this.f60625e = view;
    }

    public final void call(Object obj) {
        this.f60622b.W0(this.f60623c, this.f60624d, this.f60625e, (Void) obj);
    }
}
