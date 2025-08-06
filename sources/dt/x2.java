package dt;

import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;

public final /* synthetic */ class x2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f54200b;

    public /* synthetic */ x2(OrderPlaceBean orderPlaceBean) {
        this.f54200b = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return d3.M(this.f54200b, (Long) obj);
    }
}
