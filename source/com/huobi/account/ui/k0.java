package com.huobi.account.ui;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.account.entity.MultipleAccountData;
import com.huobi.account.ui.MultipleAccountActivity;

public final /* synthetic */ class k0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultipleAccountActivity.a f41728a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MultipleAccountData f41729b;

    public /* synthetic */ k0(MultipleAccountActivity.a aVar, MultipleAccountData multipleAccountData) {
        this.f41728a = aVar;
        this.f41729b = multipleAccountData;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f41728a.e(this.f41729b, hBDialogFragment);
    }
}
