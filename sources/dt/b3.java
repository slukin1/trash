package dt;

import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;

public final /* synthetic */ class b3 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f53992b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f53993c;

    public /* synthetic */ b3(OrderPlaceBean orderPlaceBean, String str) {
        this.f53992b = orderPlaceBean;
        this.f53993c = str;
    }

    public final Object call(Object obj) {
        return d3.L(this.f53992b, this.f53993c, (Long) obj);
    }
}
