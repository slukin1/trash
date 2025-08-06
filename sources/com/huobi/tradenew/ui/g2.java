package com.huobi.tradenew.ui;

import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

public final /* synthetic */ class g2 implements PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WindowManager.LayoutParams f83410b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Window f83411c;

    public /* synthetic */ g2(WindowManager.LayoutParams layoutParams, Window window) {
        this.f83410b = layoutParams;
        this.f83411c = window;
    }

    public final void onDismiss() {
        TradeSpotPopUtil.e(this.f83410b, this.f83411c);
    }
}
