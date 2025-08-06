package ce;

import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.module.kline.presenter.MarketInfoOrderPresenter;
import rx.functions.Action1;

public final /* synthetic */ class h implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoOrderPresenter f13077b;

    public /* synthetic */ h(MarketInfoOrderPresenter marketInfoOrderPresenter) {
        this.f13077b = marketInfoOrderPresenter;
    }

    public final void call(Object obj) {
        this.f13077b.q0((TradeBuySellData) obj);
    }
}
