package hb;

import com.hbg.lite.market.widget.TradingCurveView;
import java.util.List;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradingCurveView f54925b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f54926c;

    public /* synthetic */ j(TradingCurveView tradingCurveView, List list) {
        this.f54925b = tradingCurveView;
        this.f54926c = list;
    }

    public final void run() {
        this.f54925b.m(this.f54926c);
    }
}
