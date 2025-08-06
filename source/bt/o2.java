package bt;

import android.view.View;
import com.huobi.trade.handler.TradeOrderPositionsHandler;

public final /* synthetic */ class o2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeOrderPositionsHandler f12953b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12954c;

    public /* synthetic */ o2(TradeOrderPositionsHandler tradeOrderPositionsHandler, String str) {
        this.f12953b = tradeOrderPositionsHandler;
        this.f12954c = str;
    }

    public final void onClick(View view) {
        this.f12953b.j(this.f12954c, view);
    }
}
