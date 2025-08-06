package rt;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.order.service.OrderService;
import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class y implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f25904b;

    public /* synthetic */ y(OrderPlaceBean orderPlaceBean) {
        this.f25904b = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return ((OrderService) p.X(TradeType.PRO, OrderService.class)).proOrdersPlace(MapParamsBuilder.c().b(), z.G(((Long) obj).longValue(), "margin-android", this.f25904b));
    }
}
