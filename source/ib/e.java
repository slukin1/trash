package ib;

import com.hbg.lite.record.bean.OtcTradingHouseOrderList;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e f55038b = new e();

    public final Object call(Object obj) {
        return Long.valueOf(((OtcTradingHouseOrderList) obj).d().getOrderId());
    }
}
