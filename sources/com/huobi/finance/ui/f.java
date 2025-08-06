package com.huobi.finance.ui;

import android.graphics.BitmapFactory;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ byte[] f47110b;

    public /* synthetic */ f(byte[] bArr) {
        this.f47110b = bArr;
    }

    public final Object call(Object obj) {
        return BitmapFactory.decodeByteArray(this.f47110b, 0, this.f47110b.length);
    }
}
