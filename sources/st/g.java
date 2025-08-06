package st;

import com.huobi.tradenew.presenter.TradeBasePresenter;
import rx.functions.Func1;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeBasePresenter f29212b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f29213c;

    public /* synthetic */ g(TradeBasePresenter tradeBasePresenter, String str) {
        this.f29212b = tradeBasePresenter;
        this.f29213c = str;
    }

    public final Object call(Object obj) {
        return this.f29212b.k1(this.f29213c, (Long) obj);
    }
}
