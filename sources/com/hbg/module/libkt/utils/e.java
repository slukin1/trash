package com.hbg.module.libkt.utils;

import android.content.Context;
import android.widget.PopupWindow;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f24872b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f24873c;

    public /* synthetic */ e(Context context, PopupWindow popupWindow) {
        this.f24872b = context;
        this.f24873c = popupWindow;
    }

    public final void run() {
        f.f(this.f24872b, this.f24873c);
    }
}
