package rt;

import com.huobi.trade.bean.OrderPlaceBean;
import rx.functions.Func1;

public final /* synthetic */ class p implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f25861b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f25862c;

    public /* synthetic */ p(OrderPlaceBean orderPlaceBean, String str) {
        this.f25861b = orderPlaceBean;
        this.f25862c = str;
    }

    public final Object call(Object obj) {
        return z.K(this.f25861b, this.f25862c, (Long) obj);
    }
}
