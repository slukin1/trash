package com.sumsub.sns.core.widget.applicantData;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.sumsub.sns.R;
import com.sumsub.sns.core.widget.SNSCheckGroup;
import com.sumsub.sns.core.widget.SNSStepViewExtensionsKt;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\b\b\u0002\u0010(\u001a\u00020&¢\u0006\u0004\b)\u0010*R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR(\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058F@FX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011RF\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBoolFieldView;", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView;", "Lcom/google/android/material/checkbox/MaterialCheckBox;", "checkBox", "Lcom/google/android/material/checkbox/MaterialCheckBox;", "", "isUpdating", "Z", "Lcom/sumsub/sns/core/widget/SNSCheckGroup;", "getCheckGroup", "()Lcom/sumsub/sns/core/widget/SNSCheckGroup;", "checkGroup", "", "value", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "label", "isChecked", "()Z", "setChecked", "(Z)V", "getError", "setError", "error", "Lkotlin/Function1;", "", "onCheckedChanged", "Ld10/l;", "getOnCheckedChanged", "()Ld10/l;", "setOnCheckedChanged", "(Ld10/l;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSApplicantDataBoolFieldView extends SNSApplicantDataBaseFieldView {
    private MaterialCheckBox checkBox;
    private boolean isUpdating;
    private l<? super Boolean, Unit> onCheckedChanged;

    public SNSApplicantDataBoolFieldView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: _set_onCheckedChanged_$lambda-0  reason: not valid java name */
    public static final void m36_set_onCheckedChanged_$lambda0(SNSApplicantDataBoolFieldView sNSApplicantDataBoolFieldView, l lVar, CompoundButton compoundButton, boolean z11) {
        sNSApplicantDataBoolFieldView.setError((CharSequence) null);
        if (!sNSApplicantDataBoolFieldView.isUpdating && lVar != null) {
            lVar.invoke(Boolean.valueOf(z11));
        }
    }

    private final SNSCheckGroup getCheckGroup() {
        return (SNSCheckGroup) findViewById(R.id.sns_data_bool);
    }

    public CharSequence getError() {
        TextView tvError = getTvError();
        if (tvError != null) {
            return tvError.getText();
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
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBoolFieldView.getLabel():java.lang.CharSequence");
    }

    public final l<Boolean, Unit> getOnCheckedChanged() {
        return this.onCheckedChanged;
    }

    public final boolean isChecked() {
        MaterialCheckBox materialCheckBox = this.checkBox;
        return materialCheckBox != null && materialCheckBox.isChecked();
    }

    public final void setChecked(boolean z11) {
        this.isUpdating = true;
        MaterialCheckBox materialCheckBox = this.checkBox;
        if (materialCheckBox != null) {
            materialCheckBox.setChecked(z11);
        }
        this.isUpdating = false;
    }

    public void setError(CharSequence charSequence) {
        SNSStepState sNSStepState;
        TextView tvError = getTvError();
        if (tvError != null) {
            i.a(tvError, charSequence);
        }
        SNSCheckGroup checkGroup = getCheckGroup();
        if (checkGroup != null) {
            if (charSequence == null || charSequence.length() == 0) {
                sNSStepState = SNSStepState.INIT;
            } else {
                sNSStepState = SNSStepState.REJECTED;
            }
            SNSStepViewExtensionsKt.setSnsStepState(checkGroup, sNSStepState);
        }
    }

    public void setLabel(CharSequence charSequence) {
        TextView tvLabel$idensic_mobile_sdk_aar_release = getTvLabel$idensic_mobile_sdk_aar_release();
        if (tvLabel$idensic_mobile_sdk_aar_release != null) {
            i.a(tvLabel$idensic_mobile_sdk_aar_release, charSequence);
        }
    }

    public final void setOnCheckedChanged(l<? super Boolean, Unit> lVar) {
        MaterialCheckBox materialCheckBox = this.checkBox;
        if (materialCheckBox != null) {
            materialCheckBox.setOnCheckedChangeListener(new a(this, lVar));
        }
        this.onCheckedChanged = lVar;
    }

    public SNSApplicantDataBoolFieldView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSApplicantDataBoolFieldView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataBoolFieldView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_applicantDataBoolFieldViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSApplicantDataBoolFieldView : i12);
    }

    public SNSApplicantDataBoolFieldView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, 0, 8, (r) null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSApplicantDataBoolFieldView, i11, i12);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SNSApplicantDataBoolFieldView_sns_applicantDataBoolFieldLayout, R.layout.sns_layout_applicant_data_bool_field), this, true);
        obtainStyledAttributes.recycle();
        this.checkBox = new MaterialCheckBox(context);
        SNSCheckGroup checkGroup = getCheckGroup();
        if (checkGroup != null) {
            checkGroup.addView(this.checkBox);
        }
        onInitializationFinished();
    }
}
