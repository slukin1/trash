package com.sumsub.sns.core.widget.applicantData;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sumsub.sns.R;
import com.sumsub.sns.internal.core.common.i;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8V@VX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataTextAreaFieldView;", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "", "label", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "setEnabled", "", "enabled", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSApplicantDataTextAreaFieldView extends SNSApplicantDataBaseFieldView {
    public SNSApplicantDataTextAreaFieldView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
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
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataTextAreaFieldView.getLabel():java.lang.CharSequence");
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        TextInputLayout inputLayout = getInputLayout();
        if (inputLayout != null) {
            inputLayout.setEnabled(z11);
        }
    }

    public void setLabel(CharSequence charSequence) {
        TextView tvLabel$idensic_mobile_sdk_aar_release = getTvLabel$idensic_mobile_sdk_aar_release();
        if (tvLabel$idensic_mobile_sdk_aar_release != null) {
            i.a(tvLabel$idensic_mobile_sdk_aar_release, charSequence);
        }
    }

    public SNSApplicantDataTextAreaFieldView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSApplicantDataTextAreaFieldView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataTextAreaFieldView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_applicantDataTextAreaFieldViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSApplicantDataTextAreaFieldView : i12);
    }

    public SNSApplicantDataTextAreaFieldView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, 0, 8, (r) null);
        EditText editText;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSApplicantDataTextAreaFieldView, i11, i12);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SNSApplicantDataTextAreaFieldView_sns_applicantDataTextAreaFieldLayout, R.layout.sns_layout_applicant_data_text_area_field), this, true);
        obtainStyledAttributes.recycle();
        TextInputEditText textInputEditText = (TextInputEditText) findViewById(R.id.sns_editor);
        if (textInputEditText != null) {
            textInputEditText.setInputType(131073);
        }
        setInputLayout$idensic_mobile_sdk_aar_release((TextInputLayout) findViewById(R.id.sns_editor_layout));
        TextInputLayout inputLayout = getInputLayout();
        if (inputLayout != null) {
            inputLayout.setHintEnabled(false);
        }
        TextInputLayout inputLayout2 = getInputLayout();
        if (!(inputLayout2 == null || (editText = inputLayout2.getEditText()) == null)) {
            editText.addTextChangedListener(new SNSApplicantDataTextAreaFieldView$special$$inlined$doAfterTextChanged$1(this));
        }
        onInitializationFinished();
    }
}
