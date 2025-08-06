package com.sumsub.sns.core.widget.applicantData;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.sumsub.sns.R;
import com.sumsub.sns.core.common.b;
import com.sumsub.sns.internal.core.common.i;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001d¢\u0006\u0004\b \u0010!R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R(\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bRF\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00108V@VX\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataSectionView;", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView;", "Landroid/widget/TextView;", "getTvDescription", "()Landroid/widget/TextView;", "tvDescription", "", "value", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "label", "getDescription", "setDescription", "description", "Lkotlin/Function1;", "", "", "onLinkClicked", "Ld10/l;", "getOnLinkClicked", "()Ld10/l;", "setOnLinkClicked", "(Ld10/l;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSApplicantDataSectionView extends SNSApplicantDataBaseFieldView {
    private l<? super String, Unit> onLinkClicked;

    public SNSApplicantDataSectionView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    private final TextView getTvDescription() {
        return (TextView) findViewById(R.id.sns_description);
    }

    public final CharSequence getDescription() {
        TextView tvDescription = getTvDescription();
        if (tvDescription != null) {
            return tvDescription.getText();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence getLabel() {
        /*
            r1 = this;
            android.widget.TextView r0 = r1.getTvLabel$idensic_mobile_sdk_aar_release()
            if (r0 == 0) goto L_0x000c
            java.lang.CharSequence r0 = r0.getText()
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSectionView.getLabel():java.lang.CharSequence");
    }

    public l<String, Unit> getOnLinkClicked() {
        return super.getOnLinkClicked();
    }

    public final void setDescription(CharSequence charSequence) {
        TextView tvDescription = getTvDescription();
        if (tvDescription != null) {
            i.a(tvDescription, charSequence);
        }
    }

    public void setLabel(CharSequence charSequence) {
        TextView tvLabel$idensic_mobile_sdk_aar_release = getTvLabel$idensic_mobile_sdk_aar_release();
        if (tvLabel$idensic_mobile_sdk_aar_release != null) {
            i.a(tvLabel$idensic_mobile_sdk_aar_release, charSequence);
        }
    }

    public void setOnLinkClicked(l<? super String, Unit> lVar) {
        TextView tvLabel$idensic_mobile_sdk_aar_release = getTvLabel$idensic_mobile_sdk_aar_release();
        if (tvLabel$idensic_mobile_sdk_aar_release != null) {
            b.a(tvLabel$idensic_mobile_sdk_aar_release, lVar);
        }
        TextView tvDescription = getTvDescription();
        if (tvDescription != null) {
            b.a(tvDescription, lVar);
        }
        this.onLinkClicked = lVar;
    }

    public SNSApplicantDataSectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSApplicantDataSectionView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataSectionView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_applicantDataSectionViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSApplicantDataSectionView : i12);
    }

    public SNSApplicantDataSectionView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, 0, 8, (r) null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSApplicantDataSectionView, i11, i12);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SNSApplicantDataSectionView_sns_applicantDataSectionLayout, R.layout.sns_layout_applicant_data_section), this, true);
        obtainStyledAttributes.recycle();
        onInitializationFinished();
    }
}
