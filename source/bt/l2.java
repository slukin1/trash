package bt;

import android.view.View;
import com.huobi.trade.handler.TradeOrderPositionsHandler;

public final /* synthetic */ class l2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeOrderPositionsHandler f12933b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12934c;

    public /* synthetic */ l2(TradeOrderPositionsHandler tradeOrderPositionsHandler, String str) {
        this.f12933b = tradeOrderPositionsHandler;
        this.f12934c = str;
    }

    public final void onClick(View view) {
        this.f12933b.g(this.f12934c, view);
    }
}
