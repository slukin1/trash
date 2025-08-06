package com.sumsub.sns.core.widget.applicantData;

import android.view.View;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSApplicantDataFileFieldView f31212b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SNSApplicantDataFileFieldView.Attachment f31213c;

    public /* synthetic */ c(SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView, SNSApplicantDataFileFieldView.Attachment attachment) {
        this.f31212b = sNSApplicantDataFileFieldView;
        this.f31213c = attachment;
    }

    public final void onClick(View view) {
        SNSApplicantDataFileFieldView.m37populateViewItems$lambda7$lambda6$lambda5(this.f31212b, this.f31213c, view);
    }
}
