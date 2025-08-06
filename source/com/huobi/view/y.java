package com.huobi.view;

import android.view.View;

public final /* synthetic */ class y implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonCaptchaDialog f19124b;

    public /* synthetic */ y(CommonCaptchaDialog commonCaptchaDialog) {
        this.f19124b = commonCaptchaDialog;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f19124b.lambda$addEvent$2(view, z11);
    }
}
