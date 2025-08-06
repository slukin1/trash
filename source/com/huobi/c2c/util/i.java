package com.huobi.c2c.util;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class i implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f43027a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f43028b;

    public /* synthetic */ i(FragmentActivity fragmentActivity, String str) {
        this.f43027a = fragmentActivity;
        this.f43028b = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        C2CDialogUtil.r(this.f43027a, this.f43028b, hBDialogFragment);
    }
}
