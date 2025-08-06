package dt;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.order.service.OrderService;
import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class t2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f54154b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f54155c;

    public /* synthetic */ t2(String str, OrderPlaceBean orderPlaceBean) {
        this.f54154b = str;
        this.f54155c = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return ((OrderService) p.X(TradeType.PRO, OrderService.class)).proOrdersPlace(MapParamsBuilder.c().b(), d3.H(((Long) obj).longValue(), this.f54154b, this.f54155c));
    }
}
