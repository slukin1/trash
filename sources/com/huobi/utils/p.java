package com.huobi.utils;

import i6.k;
import rx.functions.Func1;

public final /* synthetic */ class p implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f83761b;

    public /* synthetic */ p(String str) {
        this.f83761b = str;
    }

    public final Object call(Object obj) {
        return k.o("uploadUserLog", "上传信息失败 uid:" + this.f83761b);
    }
}
