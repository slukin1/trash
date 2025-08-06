package com.sumsub.sns.core.widget.applicantData;

import android.content.DialogInterface;

public final /* synthetic */ class j implements DialogInterface.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSApplicantDataSelectionFieldView f31221b;

    public /* synthetic */ j(SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView) {
        this.f31221b = sNSApplicantDataSelectionFieldView;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        SNSApplicantDataSelectionFieldView.m46showDialog$lambda4(this.f31221b, dialogInterface);
    }
}
