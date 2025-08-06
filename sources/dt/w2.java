package dt;

import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.trade.prime.service.PrimeService;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class w2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f54188b;

    public /* synthetic */ w2(OrderPlaceBean orderPlaceBean) {
        this.f54188b = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return ((PrimeService) p.C(PrimeService.class)).bidOrderPlace(d3.H(((Long) obj).longValue(), "spot-android", this.f54188b));
    }
}
