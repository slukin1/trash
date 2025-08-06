package com.huobi.utils;

import i6.k;
import rx.functions.Func1;

public final /* synthetic */ class n implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f83759b;

    public /* synthetic */ n(String str) {
        this.f83759b = str;
    }

    public final Object call(Object obj) {
        return k.o("uploadUserLog", "上传信息成功 uid:" + this.f83759b);
    }
}
