package com.sumsub.sns.core.widget.applicantData;

import android.content.Context;
import android.util.AttributeSet;
import com.sumsub.sns.R;
import com.sumsub.sns.core.widget.SNSSubtitle2TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataDescriptionView;", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "label", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "subtitleView", "Lcom/sumsub/sns/core/widget/SNSSubtitle2TextView;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSApplicantDataDescriptionView extends SNSApplicantDataBaseFieldView {
    private final SNSSubtitle2TextView subtitleView;

    public SNSApplicantDataDescriptionView(Context context) {
        super(context, (AttributeSet) null, 0, 0, 14, (r) null);
        removeAllViews();
        SNSSubtitle2TextView sNSSubtitle2TextView = new SNSSubtitle2TextView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        sNSSubtitle2TextView.setPadding(sNSSubtitle2TextView.getPaddingLeft(), context.getResources().getDimensionPixelSize(R.dimen.sns_margin_medium), sNSSubtitle2TextView.getPaddingRight(), sNSSubtitle2TextView.getPaddingBottom());
        this.subtitleView = sNSSubtitle2TextView;
        addView(sNSSubtitle2TextView);
        onInitializationFinished();
    }

    public CharSequence getLabel() {
        return this.subtitleView.getText();
    }

    public void setLabel(CharSequence charSequence) {
        this.subtitleView.setText(charSequence);
    }
}
