package com.sumsub.sns.videoident.presentation;

import android.view.View;
import com.sumsub.sns.internal.videoident.presentation.SNSViewState;

public final /* synthetic */ class n implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSViewState.e f40348b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SNSVideoIdentFragment f40349c;

    public /* synthetic */ n(SNSViewState.e eVar, SNSVideoIdentFragment sNSVideoIdentFragment) {
        this.f40348b = eVar;
        this.f40349c = sNSVideoIdentFragment;
    }

    public final void onClick(View view) {
        SNSVideoIdentFragment.m2303updateBottomPrimaryButton$lambda65(this.f40348b, this.f40349c, view);
    }
}
