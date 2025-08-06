package bt;

import com.huobi.trade.bean.TradeHoldBean;
import com.huobi.trade.handler.TradeHoldViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class f2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeHoldBean f12899b;

    public /* synthetic */ f2(TradeHoldBean tradeHoldBean) {
        this.f12899b = tradeHoldBean;
    }

    public final void call(Object obj) {
        TradeHoldViewHandler.d(this.f12899b, (Void) obj);
    }
}
