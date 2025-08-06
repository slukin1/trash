package bt;

import android.view.View;
import com.huobi.trade.handler.TradeOrderPositionsHandler;

public final /* synthetic */ class m2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeOrderPositionsHandler f12940b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12941c;

    public /* synthetic */ m2(TradeOrderPositionsHandler tradeOrderPositionsHandler, String str) {
        this.f12940b = tradeOrderPositionsHandler;
        this.f12941c = str;
    }

    public final void onClick(View view) {
        this.f12940b.h(this.f12941c, view);
    }
}
