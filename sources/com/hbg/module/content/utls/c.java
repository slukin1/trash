package com.hbg.module.content.utls;

import android.widget.PopupWindow;

public final /* synthetic */ class c implements PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f18845b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f18846c;

    public /* synthetic */ c(e eVar, String str) {
        this.f18845b = eVar;
        this.f18846c = str;
    }

    public final void onDismiss() {
        e.g(this.f18845b, this.f18846c);
    }
}
