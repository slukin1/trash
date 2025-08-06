package com.sumsub.sns.core.widget.applicantData;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.sumsub.sns.R;
import com.sumsub.sns.core.common.b;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.widget.SNSH1TextView;
import com.sumsub.sns.internal.core.theme.d;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R(\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nRF\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataTitleView;", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView;", "Lcom/sumsub/sns/core/widget/SNSH1TextView;", "titleView", "Lcom/sumsub/sns/core/widget/SNSH1TextView;", "", "value", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "label", "Lkotlin/Function1;", "", "", "onLinkClicked", "Ld10/l;", "getOnLinkClicked", "()Ld10/l;", "setOnLinkClicked", "(Ld10/l;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSApplicantDataTitleView extends SNSApplicantDataBaseFieldView {
    private l<? super String, Unit> onLinkClicked;
    private final SNSH1TextView titleView;

    public SNSApplicantDataTitleView(Context context) {
        super(context, (AttributeSet) null, 0, 0, 14, (r) null);
        String c11;
        removeAllViews();
        SNSH1TextView sNSH1TextView = new SNSH1TextView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        sNSH1TextView.setPadding(sNSH1TextView.getPaddingLeft(), context.getResources().getDimensionPixelSize(R.dimen.sns_margin_medium), sNSH1TextView.getPaddingRight(), sNSH1TextView.getPaddingBottom());
        sNSH1TextView.setGravity(17);
        this.titleView = sNSH1TextView;
        sNSH1TextView.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        addView(sNSH1TextView);
        onInitializationFinished();
        a aVar = a.f31095a;
        d a11 = aVar.a();
        if (a11 != null && (c11 = aVar.c(a11, SNSMetricElement.SCREEN_HEADER_ALIGNMENT)) != null) {
            aVar.a((TextView) sNSH1TextView, c11);
        }
    }

    public CharSequence getLabel() {
        SNSH1TextView sNSH1TextView = this.titleView;
        if (sNSH1TextView != null) {
            return sNSH1TextView.getText();
        }
        return null;
    }

    public l<String, Unit> getOnLinkClicked() {
        return this.onLinkClicked;
    }

    public void setLabel(CharSequence charSequence) {
        SNSH1TextView sNSH1TextView = this.titleView;
        if (sNSH1TextView != null) {
            sNSH1TextView.setText(charSequence);
        }
    }

    public void setOnLinkClicked(l<? super String, Unit> lVar) {
        SNSH1TextView sNSH1TextView = this.titleView;
        if (sNSH1TextView != null) {
            b.a((TextView) sNSH1TextView, lVar);
        }
        this.onLinkClicked = lVar;
    }
}
