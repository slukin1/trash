package com.huobi.finance.presenter;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class m9 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f46003a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f46004b;

    public /* synthetic */ m9(UnifyTransferPresenter unifyTransferPresenter, String str) {
        this.f46003a = unifyTransferPresenter;
        this.f46004b = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f46003a.B2(this.f46004b, hBDialogFragment);
    }
}
