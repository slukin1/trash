package com.huobi.utils;

import android.content.Context;
import android.util.Pair;
import rx.functions.Func1;

public final /* synthetic */ class l implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f83757b;

    public /* synthetic */ l(Context context) {
        this.f83757b = context;
    }

    public final Object call(Object obj) {
        return AutoUploadLogHelper.I(this.f83757b, (Pair) obj);
    }
}
