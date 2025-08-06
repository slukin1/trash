package com.sumsub.sns.core.widget.applicantData;

import android.content.Context;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSApplicantDataSelectionCountryFieldView f31218b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f31219c;

    public /* synthetic */ h(SNSApplicantDataSelectionCountryFieldView sNSApplicantDataSelectionCountryFieldView, Context context) {
        this.f31218b = sNSApplicantDataSelectionCountryFieldView;
        this.f31219c = context;
    }

    public final void run() {
        SNSApplicantDataSelectionCountryFieldView.m42picker$lambda3(this.f31218b, this.f31219c);
    }
}
