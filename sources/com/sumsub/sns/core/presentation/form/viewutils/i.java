package com.sumsub.sns.core.presentation.form.viewutils;

import android.content.Context;
import android.util.AttributeSet;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSectionView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import kotlin.jvm.internal.r;

public final class i {
    public static final SNSApplicantDataBaseFieldView a(FormItem.l lVar, Context context) {
        SNSApplicantDataSectionView sNSApplicantDataSectionView = new SNSApplicantDataSectionView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        String l11 = lVar.d().l();
        sNSApplicantDataSectionView.setDescription(l11 != null ? com.sumsub.sns.internal.core.common.i.a((CharSequence) l11, context) : null);
        return sNSApplicantDataSectionView;
    }
}
