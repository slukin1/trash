package st;

import com.huobi.index.bean.IndexFeature;
import com.huobi.tradenew.presenter.TradeBasePresenter;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeBasePresenter.h f29221b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IndexFeature f29222c;

    public /* synthetic */ k(TradeBasePresenter.h hVar, IndexFeature indexFeature) {
        this.f29221b = hVar;
        this.f29222c = indexFeature;
    }

    public final void run() {
        this.f29221b.b(this.f29222c);
    }
}
