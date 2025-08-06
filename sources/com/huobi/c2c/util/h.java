package com.huobi.c2c.util;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class h implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f43025a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f43026b;

    public /* synthetic */ h(int i11, FragmentActivity fragmentActivity) {
        this.f43025a = i11;
        this.f43026b = fragmentActivity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        C2CDialogUtil.m(this.f43025a, this.f43026b, hBDialogFragment);
    }
}
