package bt;

import com.huobi.order.bean.OrderBean;
import rx.functions.Func1;

public final /* synthetic */ class w implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f0 f12980b;

    public /* synthetic */ w(f0 f0Var) {
        this.f12980b = f0Var;
    }

    public final Object call(Object obj) {
        return this.f12980b.x((OrderBean) obj);
    }
}
