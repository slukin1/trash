package ug;

import com.huobi.account.bean.KnapsackItem;
import com.huobi.account.presenter.AccountPresenter;
import rx.functions.Action1;

public final /* synthetic */ class l implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KnapsackItem f60614b;

    public /* synthetic */ l(KnapsackItem knapsackItem) {
        this.f60614b = knapsackItem;
    }

    public final void call(Object obj) {
        AccountPresenter.U0(this.f60614b, (Void) obj);
    }
}
