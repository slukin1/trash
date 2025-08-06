package bt;

import android.view.View;
import com.huobi.trade.handler.TradeOrderPositionsHandler;

public final /* synthetic */ class n2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeOrderPositionsHandler f12946b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12947c;

    public /* synthetic */ n2(TradeOrderPositionsHandler tradeOrderPositionsHandler, String str) {
        this.f12946b = tradeOrderPositionsHandler;
        this.f12947c = str;
    }

    public final void onClick(View view) {
        this.f12946b.i(this.f12947c, view);
    }
}
