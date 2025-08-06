package com.sumsub.sns.core.widget;

import android.view.View;

public final /* synthetic */ class e implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSDateInputLayout f31240b;

    public /* synthetic */ e(SNSDateInputLayout sNSDateInputLayout) {
        this.f31240b = sNSDateInputLayout;
    }

    public final void onFocusChange(View view, boolean z11) {
        SNSDateInputLayout.m18addView$lambda0(this.f31240b, view, z11);
    }
}
