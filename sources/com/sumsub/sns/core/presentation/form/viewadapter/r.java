package com.sumsub.sns.core.presentation.form.viewadapter;

import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSubtitleView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;

public final class r extends k<FormItem, SNSApplicantDataSubtitleView> {
    public r(SNSApplicantDataSubtitleView sNSApplicantDataSubtitleView) {
        super(sNSApplicantDataSubtitleView);
    }

    public void a(SNSApplicantDataSubtitleView sNSApplicantDataSubtitleView, FormItem formItem, int i11) {
        sNSApplicantDataSubtitleView.setLabel(formItem.d().x());
    }
}
