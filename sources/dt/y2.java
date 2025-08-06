package dt;

import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;

public final /* synthetic */ class y2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f54212b;

    public /* synthetic */ y2(OrderPlaceBean orderPlaceBean) {
        this.f54212b = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return d3.P(this.f54212b, (Long) obj);
    }
}
