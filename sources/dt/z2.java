package dt;

import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;

public final /* synthetic */ class z2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f54224b;

    public /* synthetic */ z2(OrderPlaceBean orderPlaceBean) {
        this.f54224b = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return d3.Q(this.f54224b, (Long) obj);
    }
}
