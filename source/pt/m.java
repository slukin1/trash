package pt;

import com.huobi.trade.bean.TradeHoldBean;
import com.huobi.tradenew.handler.TradeHoldViewHandler;
import rx.functions.Action1;
import v9.c;

public final /* synthetic */ class m implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeHoldBean f53241b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f53242c;

    public /* synthetic */ m(TradeHoldBean tradeHoldBean, c cVar) {
        this.f53241b = tradeHoldBean;
        this.f53242c = cVar;
    }

    public final void call(Object obj) {
        TradeHoldViewHandler.d(this.f53241b, this.f53242c, (Void) obj);
    }
}
