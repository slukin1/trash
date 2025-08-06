package rq;

import com.huobi.index.bean.IndexFeature;
import com.huobi.quicktrade.trade.presenter.QuickTradeBasePresenter;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickTradeBasePresenter.a f25783b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IndexFeature f25784c;

    public /* synthetic */ c(QuickTradeBasePresenter.a aVar, IndexFeature indexFeature) {
        this.f25783b = aVar;
        this.f25784c = indexFeature;
    }

    public final void run() {
        this.f25783b.b(this.f25784c);
    }
}
