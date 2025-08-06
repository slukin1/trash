package rt;

import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.tradenew.prime.service.PrimeService;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class m implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f25847b;

    public /* synthetic */ m(OrderPlaceBean orderPlaceBean) {
        this.f25847b = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return ((PrimeService) p.C(PrimeService.class)).bidOrderPlace(z.G(((Long) obj).longValue(), "spot-android", this.f25847b));
    }
}
