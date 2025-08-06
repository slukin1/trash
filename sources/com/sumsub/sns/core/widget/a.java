package com.sumsub.sns.core.widget;

import android.view.KeyEvent;
import android.widget.TextView;

public final /* synthetic */ class a implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSApplicantDataFieldView f31207b;

    public /* synthetic */ a(SNSApplicantDataFieldView sNSApplicantDataFieldView) {
        this.f31207b = sNSApplicantDataFieldView;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return SNSApplicantDataFieldView.m15lambda3$lambda2(this.f31207b, textView, i11, keyEvent);
    }
}
