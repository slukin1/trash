package rt;

import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;

public final /* synthetic */ class w implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f25888b;

    public /* synthetic */ w(OrderPlaceBean orderPlaceBean) {
        this.f25888b = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return z.N(this.f25888b, (Long) obj);
    }
}
