package dt;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.order.service.OrderService;
import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class c3 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f54003b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f54004c;

    public /* synthetic */ c3(String str, OrderPlaceBean orderPlaceBean) {
        this.f54003b = str;
        this.f54004c = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return ((OrderService) p.X(TradeType.PRO, OrderService.class)).proOrdersPlace(MapParamsBuilder.c().b(), d3.H(((Long) obj).longValue(), this.f54003b, this.f54004c));
    }
}
