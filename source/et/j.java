package et;

import com.huobi.index.bean.IndexFeature;
import com.huobi.trade.presenter.TradeBasePresenter;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeBasePresenter.g f54439b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IndexFeature f54440c;

    public /* synthetic */ j(TradeBasePresenter.g gVar, IndexFeature indexFeature) {
        this.f54439b = gVar;
        this.f54440c = indexFeature;
    }

    public final void run() {
        this.f54439b.b(this.f54440c);
    }
}
