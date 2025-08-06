package com.hbg.lib.core.util;

import android.app.Activity;
import android.graphics.Bitmap;
import rx.functions.Action1;

public final /* synthetic */ class i0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f68711b;

    public /* synthetic */ i0(Activity activity) {
        this.f68711b = activity;
    }

    public final void call(Object obj) {
        SaveImageUtils.i((Bitmap) obj, this.f68711b);
    }
}
