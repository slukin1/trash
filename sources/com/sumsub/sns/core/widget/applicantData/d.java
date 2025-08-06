package com.sumsub.sns.core.widget.applicantData;

import android.widget.CompoundButton;

public final /* synthetic */ class d implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSApplicantDataMutilselectFieldView f31214b;

    public /* synthetic */ d(SNSApplicantDataMutilselectFieldView sNSApplicantDataMutilselectFieldView) {
        this.f31214b = sNSApplicantDataMutilselectFieldView;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        SNSApplicantDataMutilselectFieldView.m39_set_items_$lambda5$lambda4$lambda3(this.f31214b, compoundButton, z11);
    }
}
