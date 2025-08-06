package com.huobi.finance.presenter;

import com.huobi.finance.bean.ExamInfo;
import rx.functions.Func1;

public final /* synthetic */ class s7 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExamInfo f46106b;

    public /* synthetic */ s7(ExamInfo examInfo) {
        this.f46106b = examInfo;
    }

    public final Object call(Object obj) {
        return Long.valueOf((this.f46106b.getIdle() / 1000) - ((Long) obj).longValue());
    }
}
