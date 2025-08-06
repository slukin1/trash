package com.huobi.finance.presenter;

import com.huobi.finance.bean.OtcFinanceRecordItem;
import rx.functions.Func1;

public final /* synthetic */ class k6 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ k6 f45956b = new k6();

    public final Object call(Object obj) {
        return Long.valueOf(((OtcFinanceRecordItem) obj).getGmtCreate());
    }
}
