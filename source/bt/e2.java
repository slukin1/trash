package bt;

import com.huobi.trade.bean.TradeHoldBeanNew;
import com.huobi.trade.handler.TradeHoldNewViewHandler;
import rx.functions.Action1;
import v9.c;

public final /* synthetic */ class e2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeHoldBeanNew f12895b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f12896c;

    public /* synthetic */ e2(TradeHoldBeanNew tradeHoldBeanNew, c cVar) {
        this.f12895b = tradeHoldBeanNew;
        this.f12896c = cVar;
    }

    public final void call(Object obj) {
        TradeHoldNewViewHandler.d(this.f12895b, this.f12896c, (Void) obj);
    }
}
