package com.huobi.utils;

import android.content.Context;
import android.util.Pair;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f83739b;

    public /* synthetic */ e(Context context) {
        this.f83739b = context;
    }

    public final Object call(Object obj) {
        return AutoUploadLogHelper.u(this.f83739b, (Pair) obj);
    }
}
