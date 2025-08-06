package hb;

import com.hbg.lite.market.widget.TradingCurveView;
import java.util.List;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradingCurveView f54923b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f54924c;

    public /* synthetic */ i(TradingCurveView tradingCurveView, List list) {
        this.f54923b = tradingCurveView;
        this.f54924c = list;
    }

    public final void run() {
        this.f54923b.l(this.f54924c);
    }
}
