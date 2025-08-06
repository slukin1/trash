package com.sumsub.sns.core.presentation.form.viewadapter;

import android.content.Context;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSectionView;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.data.source.applicant.remote.k;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;

public final class o extends k<FormItem, SNSApplicantDataSectionView> {
    public o(SNSApplicantDataSectionView sNSApplicantDataSectionView) {
        super(sNSApplicantDataSectionView);
    }

    public void a(SNSApplicantDataSectionView sNSApplicantDataSectionView, FormItem formItem, int i11) {
        k d11 = formItem.d();
        Context context = sNSApplicantDataSectionView.getContext();
        String l11 = d11.l();
        sNSApplicantDataSectionView.setDescription(l11 != null ? i.a((CharSequence) l11, context) : null);
    }
}
