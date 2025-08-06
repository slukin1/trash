package com.huobi.utils;

import java.util.ArrayList;
import rx.functions.Func1;

public final /* synthetic */ class t implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f83778b;

    public /* synthetic */ t(String str) {
        this.f83778b = str;
    }

    public final Object call(Object obj) {
        return AutoUploadLogHelper.C(this.f83778b, (ArrayList) obj);
    }
}
