package rt;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.order.service.OrderService;
import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class x implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f25896b;

    public /* synthetic */ x(OrderPlaceBean orderPlaceBean) {
        this.f25896b = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return ((OrderService) p.X(TradeType.PRO, OrderService.class)).proOrdersPlace(MapParamsBuilder.c().b(), z.G(((Long) obj).longValue(), "spot-android", this.f25896b));
    }
}
