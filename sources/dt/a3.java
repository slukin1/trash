package dt;

import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;

public final /* synthetic */ class a3 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f53986b;

    public /* synthetic */ a3(OrderPlaceBean orderPlaceBean) {
        this.f53986b = orderPlaceBean;
    }

    public final Object call(Object obj) {
        return d3.S(this.f53986b, (Long) obj);
    }
}
