package et;

import com.huobi.trade.presenter.TradeBasePresenter;
import rx.functions.Func1;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeBasePresenter f54433b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54434c;

    public /* synthetic */ g(TradeBasePresenter tradeBasePresenter, String str) {
        this.f54433b = tradeBasePresenter;
        this.f54434c = str;
    }

    public final Object call(Object obj) {
        return this.f54433b.e1(this.f54434c, (Long) obj);
    }
}
