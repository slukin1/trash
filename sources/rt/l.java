package rt;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.order.service.OrderService;
import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class l implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f25845b;

    public /* synthetic */ l(OrderPlaceBean orderPlaceBean) {
        this.f25845b = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return ((OrderService) p.X(TradeType.PRO, OrderService.class)).proOrdersPlace(MapParamsBuilder.c().b(), z.G(((Long) obj).longValue(), "c2c-margin-android", this.f25845b));
    }
}
