package com.huobi.c2c.util;

import com.hbg.lib.widgets.dialog.HBDialogFragment;
import rx.functions.Action1;

public final /* synthetic */ class l implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f43031b;

    public /* synthetic */ l(HBDialogFragment hBDialogFragment) {
        this.f43031b = hBDialogFragment;
    }

    public final void call(Object obj) {
        C2CDialogUtil.p(this.f43031b, obj);
    }
}
