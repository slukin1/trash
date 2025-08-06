package com.sumsub.sns.core.widget.applicantData;

import android.widget.CompoundButton;
import d10.l;

public final /* synthetic */ class a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSApplicantDataBoolFieldView f31209b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f31210c;

    public /* synthetic */ a(SNSApplicantDataBoolFieldView sNSApplicantDataBoolFieldView, l lVar) {
        this.f31209b = sNSApplicantDataBoolFieldView;
        this.f31210c = lVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        SNSApplicantDataBoolFieldView.m36_set_onCheckedChanged_$lambda0(this.f31209b, this.f31210c, compoundButton, z11);
    }
}
