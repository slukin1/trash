package bt;

import com.huobi.order.bean.ExchangeOpenOrderItem;
import com.huobi.order.bean.OrderBean;
import rx.functions.Func1;
import s9.a;

public final /* synthetic */ class y implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ y f12986b = new y();

    public final Object call(Object obj) {
        return OrderBean.from((ExchangeOpenOrderItem) ((a) obj));
    }
}
