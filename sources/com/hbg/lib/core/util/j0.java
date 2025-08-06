package com.hbg.lib.core.util;

import android.app.Activity;
import rx.functions.Func1;

public final /* synthetic */ class j0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f68715b;

    public /* synthetic */ j0(Activity activity) {
        this.f68715b = activity;
    }

    public final Object call(Object obj) {
        return SaveImageUtils.c(this.f68715b, (String) obj);
    }
}
