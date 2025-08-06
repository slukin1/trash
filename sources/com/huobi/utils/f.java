package com.huobi.utils;

import java.util.ArrayList;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f83742b;

    public /* synthetic */ f(String str) {
        this.f83742b = str;
    }

    public final Object call(Object obj) {
        return AutoUploadLogHelper.v(this.f83742b, (ArrayList) obj);
    }
}
