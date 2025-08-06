package com.huobi.finance.presenter;

import com.huobi.finance.bean.FinanceRecordItem;
import rx.functions.Func1;

public final /* synthetic */ class s2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ s2 f46101b = new s2();

    public final Object call(Object obj) {
        return Boolean.valueOf(!((FinanceRecordItem) obj).getState().equals(FinanceRecordItem.STATE_PENDING_TINY_AMOUNT));
    }
}
