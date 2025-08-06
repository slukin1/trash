package bt;

import android.view.View;
import com.huobi.trade.handler.TradeGuideListItemHandler;
import ws.e;

public final /* synthetic */ class d2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f12890b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12891c;

    public /* synthetic */ d2(e eVar, int i11) {
        this.f12890b = eVar;
        this.f12891c = i11;
    }

    public final void onClick(View view) {
        TradeGuideListItemHandler.d(this.f12890b, this.f12891c, view);
    }
}
