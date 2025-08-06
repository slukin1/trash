package rt;

import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;

public final /* synthetic */ class n implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f25850b;

    public /* synthetic */ n(OrderPlaceBean orderPlaceBean) {
        this.f25850b = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return z.L(this.f25850b, (Long) obj);
    }
}
