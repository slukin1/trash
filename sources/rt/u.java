package rt;

import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;

public final /* synthetic */ class u implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f25878b;

    public /* synthetic */ u(OrderPlaceBean orderPlaceBean) {
        this.f25878b = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return z.S(this.f25878b, (Long) obj);
    }
}
