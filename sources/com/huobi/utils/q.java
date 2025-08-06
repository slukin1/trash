package com.huobi.utils;

import i6.k;
import rx.functions.Func1;

public final /* synthetic */ class q implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f83763b;

    public /* synthetic */ q(String str) {
        this.f83763b = str;
    }

    public final Object call(Object obj) {
        return k.o("uploadUserLog", "上传信息失败 uid:" + this.f83763b);
    }
}
