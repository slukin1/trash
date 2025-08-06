package com.sumsub.sns.core.presentation.form.viewadapter;

import android.content.Context;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataDescriptionView;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.data.source.applicant.remote.k;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;

public final class g extends k<FormItem, SNSApplicantDataDescriptionView> {
    public g(SNSApplicantDataDescriptionView sNSApplicantDataDescriptionView) {
        super(sNSApplicantDataDescriptionView);
    }

    public void a(SNSApplicantDataDescriptionView sNSApplicantDataDescriptionView, FormItem formItem, int i11) {
        k d11 = formItem.d();
        Context context = sNSApplicantDataDescriptionView.getContext();
        String x11 = d11.x();
        sNSApplicantDataDescriptionView.setLabel(x11 != null ? i.a((CharSequence) x11, context) : null);
    }
}
