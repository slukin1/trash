package com.huobi.finance.ui;

import android.graphics.BitmapFactory;
import rx.functions.Func1;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ byte[] f47127b;

    public /* synthetic */ g(byte[] bArr) {
        this.f47127b = bArr;
    }

    public final Object call(Object obj) {
        return BitmapFactory.decodeByteArray(this.f47127b, 0, this.f47127b.length);
    }
}
