package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.sumsub.sns.R;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.internal.core.common.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0014\u0010\u0019\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bR(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8V@VX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSApplicantDataFieldView;", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "", "label", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "saveKeyListener", "Landroid/text/method/KeyListener;", "disableInput", "", "enableInput", "setEnabled", "enabled", "", "setMasks", "list", "", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class SNSApplicantDataFieldView extends SNSApplicantDataBaseFieldView {
    private KeyListener saveKeyListener;

    public SNSApplicantDataFieldView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-3$lambda-2  reason: not valid java name */
    public static final boolean m15lambda3$lambda2(SNSApplicantDataFieldView sNSApplicantDataFieldView, TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 == 5) {
            View focusSearch = textView.focusSearch(130);
            if (focusSearch instanceof SNSApplicantDataBaseFieldView.Selectable) {
                ((SNSApplicantDataBaseFieldView.Selectable) focusSearch).openSelector();
            } else if (focusSearch instanceof TextInputLayout) {
                EditText editText = ((TextInputLayout) focusSearch).getEditText();
                if (editText != null) {
                    editText.requestFocus();
                }
            } else if (focusSearch != null) {
                focusSearch.requestFocus();
            }
        } else if (i11 != 6) {
            return false;
        } else {
            Runnable onSubmitForm = sNSApplicantDataFieldView.getOnSubmitForm();
            if (onSubmitForm != null) {
                onSubmitForm.run();
            }
        }
        return true;
    }

    public final void disableInput() {
        EditText editText = getEditText();
        if ((editText != null ? editText.getKeyListener() : null) != null) {
            EditText editText2 = getEditText();
            this.saveKeyListener = editText2 != null ? editText2.getKeyListener() : null;
        }
        EditText editText3 = getEditText();
        if (editText3 != null) {
            editText3.setKeyListener((KeyListener) null);
        }
        TextInputLayout inputLayout = getInputLayout();
        EditText editText4 = inputLayout != null ? inputLayout.getEditText() : null;
        if (editText4 != null) {
            editText4.setKeyListener((KeyListener) null);
        }
    }

    public final void enableInput() {
        EditText editText;
        EditText editText2 = getEditText();
        if ((editText2 != null ? editText2.getKeyListener() : null) == null && (editText = getEditText()) != null) {
            editText.setKeyListener(this.saveKeyListener);
        }
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
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.SNSApplicantDataFieldView.getLabel():java.lang.CharSequence");
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

    public final void setMasks(List<String> list) {
        SNSTextInputEditText sNSTextInputEditText = (SNSTextInputEditText) findViewById(R.id.sns_editor);
        if (sNSTextInputEditText != null) {
            sNSTextInputEditText.setMasksString(list);
        }
    }

    public SNSApplicantDataFieldView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSApplicantDataFieldView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataFieldView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_applicantDataFieldViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSApplicantDataFieldView : i12);
    }

    public SNSApplicantDataFieldView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        EditText editText;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSApplicantDataFieldView, i11, i12);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SNSApplicantDataFieldView_sns_applicantDataFieldLayout, R.layout.sns_layout_applicant_data_field), this, true);
        obtainStyledAttributes.recycle();
        SNSTextInputEditText sNSTextInputEditText = (SNSTextInputEditText) findViewById(R.id.sns_editor);
        if (sNSTextInputEditText != null) {
            sNSTextInputEditText.setInputType(1);
            sNSTextInputEditText.setMaxLines(1);
            sNSTextInputEditText.setImeOptions(5);
            sNSTextInputEditText.setOnEditorActionListener(new a(this));
        }
        setInputLayout$idensic_mobile_sdk_aar_release((TextInputLayout) findViewById(R.id.sns_editor_layout));
        TextInputLayout inputLayout = getInputLayout();
        if (inputLayout != null) {
            inputLayout.setHintEnabled(false);
        }
        TextInputLayout inputLayout2 = getInputLayout();
        if (!(inputLayout2 == null || (editText = inputLayout2.getEditText()) == null)) {
            editText.addTextChangedListener(new SNSApplicantDataFieldView$special$$inlined$doAfterTextChanged$1(this));
        }
        onInitializationFinished();
    }
}
