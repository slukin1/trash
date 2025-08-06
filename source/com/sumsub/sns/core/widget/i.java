package com.sumsub.sns.core.widget;

import android.view.View;

public final /* synthetic */ class i implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSDateTimeInputLayout f31248b;

    public /* synthetic */ i(SNSDateTimeInputLayout sNSDateTimeInputLayout) {
        this.f31248b = sNSDateTimeInputLayout;
    }

    public final void onFocusChange(View view, boolean z11) {
        SNSDateTimeInputLayout.m21addView$lambda0(this.f31248b, view, z11);
    }
}
