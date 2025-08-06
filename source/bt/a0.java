package bt;

import com.huobi.order.bean.OrderBean;
import rx.functions.Func1;

public final /* synthetic */ class a0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ a0 f12872b = new a0();

    public final Object call(Object obj) {
        return Long.valueOf(((OrderBean) obj).getId());
    }
}
