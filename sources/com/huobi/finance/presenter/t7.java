package com.huobi.finance.presenter;

import com.huobi.finance.bean.ExamInfo;
import rx.functions.Func1;

public final /* synthetic */ class t7 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ t7 f46121b = new t7();

    public final Object call(Object obj) {
        return ((ExamInfo) obj).setCountDown(((ExamInfo) obj).getIdle() / 1000);
    }
}
