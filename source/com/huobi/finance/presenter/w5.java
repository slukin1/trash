package com.huobi.finance.presenter;

import com.huobi.finance.bean.OtcFinanceRecordItem;
import rx.functions.Func1;

public final /* synthetic */ class w5 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ w5 f46161b = new w5();

    public final Object call(Object obj) {
        return Long.valueOf(((OtcFinanceRecordItem) obj).getGmtCreate());
    }
}
