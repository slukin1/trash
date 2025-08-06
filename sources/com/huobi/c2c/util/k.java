package com.huobi.c2c.util;

import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f43030b;

    public /* synthetic */ k(HBDialogFragment hBDialogFragment) {
        this.f43030b = hBDialogFragment;
    }

    public final void run() {
        this.f43030b.dismiss();
    }
}
