package com.business.common.airdrop.view;

import com.hbg.lib.network.hbg.core.bean.AirdropDetailBean;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class e implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AirdropDetailBean f64331a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f64332b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f64333c;

    public /* synthetic */ e(AirdropDetailBean airdropDetailBean, int i11, String str) {
        this.f64331a = airdropDetailBean;
        this.f64332b = i11;
        this.f64333c = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        AirdropView.H(this.f64331a, this.f64332b, this.f64333c, hBDialogFragment);
    }
}
