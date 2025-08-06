package com.huobi.trade.helper;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.trade.helper.w;
import u6.g;

public final /* synthetic */ class u implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f82079a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f82080b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f82081c;

    public /* synthetic */ u(FragmentActivity fragmentActivity, g gVar, String str) {
        this.f82079a = fragmentActivity;
        this.f82080b = gVar;
        this.f82081c = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        w.a.d(this.f82079a, this.f82080b, this.f82081c, hBDialogFragment);
    }
}
