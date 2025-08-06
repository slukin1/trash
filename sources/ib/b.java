package ib;

import com.hbg.lite.record.bean.OtcOrderList;
import rx.functions.Func1;

public final /* synthetic */ class b implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ b f55035b = new b();

    public final Object call(Object obj) {
        return Long.valueOf(((OtcOrderList) obj).d().getOrderId());
    }
}
