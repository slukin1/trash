package com.sumsub.sns.core.widget.applicantData;

import android.widget.CompoundButton;

public final /* synthetic */ class e implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSApplicantDataRadioGroupView f31215b;

    public /* synthetic */ e(SNSApplicantDataRadioGroupView sNSApplicantDataRadioGroupView) {
        this.f31215b = sNSApplicantDataRadioGroupView;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        SNSApplicantDataRadioGroupView.m40_set_items_$lambda4$lambda3$lambda2(this.f31215b, compoundButton, z11);
    }
}
