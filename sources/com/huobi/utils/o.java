package com.huobi.utils;

import i6.k;
import rx.functions.Func1;

public final /* synthetic */ class o implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f83760b;

    public /* synthetic */ o(String str) {
        this.f83760b = str;
    }

    public final Object call(Object obj) {
        return k.o("uploadUserLog", "上传信息成功 uid:" + this.f83760b);
    }
}
