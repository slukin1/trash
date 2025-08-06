package com.sumsub.sns.core.presentation.form.viewadapter;

import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataTitleView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;

public final class t extends k<FormItem, SNSApplicantDataTitleView> {
    public t(SNSApplicantDataTitleView sNSApplicantDataTitleView) {
        super(sNSApplicantDataTitleView);
    }

    public void a(SNSApplicantDataTitleView sNSApplicantDataTitleView, FormItem formItem, int i11) {
        sNSApplicantDataTitleView.setLabel(formItem.d().x());
    }
}
