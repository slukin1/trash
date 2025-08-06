package rt;

import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;

public final /* synthetic */ class v implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f25880b;

    public /* synthetic */ v(OrderPlaceBean orderPlaceBean) {
        this.f25880b = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return z.T(this.f25880b, (Long) obj);
    }
}
