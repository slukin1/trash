package com.sumsub.sns.core.widget.applicantData;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.sumsub.sns.R;
import com.sumsub.sns.core.common.b;
import com.sumsub.sns.core.widget.SNSTextInputEditText;
import com.sumsub.sns.internal.core.common.i;
import d10.a;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001SB1\b\u0007\u0012\u0006\u0010K\u001a\u00020J\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L\u0012\b\b\u0002\u0010O\u001a\u00020N\u0012\b\b\u0002\u0010P\u001a\u00020N¢\u0006\u0004\bQ\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0004J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0017R.\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00188@X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010!\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R$\u0010#\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"8V@VX\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010-\u001a\u0004\u0018\u00010(8&@&X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R2\u0010/\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020\u0002\u0018\u00010.8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u00107\u001a\u0004\u0018\u00010(2\b\u0010#\u001a\u0004\u0018\u00010(8F@FX\u000e¢\u0006\f\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R\u0016\u00109\u001a\u0004\u0018\u00010\u00188DX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u001aR(\u0010<\u001a\u0004\u0018\u00010(2\b\u0010#\u001a\u0004\u0018\u00010(8V@VX\u000e¢\u0006\f\u001a\u0004\b:\u0010*\"\u0004\b;\u0010,R(\u0010?\u001a\u0004\u0018\u00010(2\b\u0010#\u001a\u0004\u0018\u00010(8F@FX\u000e¢\u0006\f\u001a\u0004\b=\u0010*\"\u0004\b>\u0010,RF\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0002\u0018\u00010.2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0002\u0018\u00010.8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b@\u00100\u001a\u0004\bA\u00102\"\u0004\bB\u00104R*\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010C8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006T"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "onInitializationFinished", "onAttachedToWindow", "clear", "Lcom/google/android/material/textfield/TextInputLayout;", "<set-?>", "inputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "getInputLayout", "()Lcom/google/android/material/textfield/TextInputLayout;", "setInputLayout$idensic_mobile_sdk_aar_release", "(Lcom/google/android/material/textfield/TextInputLayout;)V", "Ljava/lang/Runnable;", "onSubmitForm", "Ljava/lang/Runnable;", "getOnSubmitForm", "()Ljava/lang/Runnable;", "setOnSubmitForm", "(Ljava/lang/Runnable;)V", "", "initizationFinishedCalled", "Z", "Landroid/widget/TextView;", "getTvExample", "()Landroid/widget/TextView;", "tvExample", "getTvLabel$idensic_mobile_sdk_aar_release", "tvLabel", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "editText", "", "value", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "label", "Lkotlin/Function1;", "textChangedCallback", "Ld10/l;", "getTextChangedCallback", "()Ld10/l;", "setTextChangedCallback", "(Ld10/l;)V", "getExample", "setExample", "example", "getTvError", "tvError", "getError", "setError", "error", "getHint", "setHint", "hint", "onLinkClicked", "getOnLinkClicked", "setOnLinkClicked", "Lkotlin/Function0;", "onClear", "Ld10/a;", "getOnClear", "()Ld10/a;", "setOnClear", "(Ld10/a;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Selectable", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public abstract class SNSApplicantDataBaseFieldView extends ConstraintLayout {
    private boolean initizationFinishedCalled;
    private TextInputLayout inputLayout;
    private a<Unit> onClear;
    private l<? super String, Unit> onLinkClicked;
    private Runnable onSubmitForm;
    private l<? super String, Unit> textChangedCallback;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView$Selectable;", "", "openSelector", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Selectable {
        void openSelector();
    }

    public SNSApplicantDataBaseFieldView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    private final TextView getTvExample() {
        return (TextView) findViewById(R.id.sns_example);
    }

    public void clear() {
        a<Unit> aVar = this.onClear;
        if (aVar != null) {
            aVar.invoke();
        }
        setOnLinkClicked((l<? super String, Unit>) null);
        this.textChangedCallback = null;
    }

    public final EditText getEditText() {
        TextInputLayout textInputLayout = this.inputLayout;
        if (textInputLayout != null) {
            return textInputLayout.getEditText();
        }
        return null;
    }

    public CharSequence getError() {
        TextInputLayout textInputLayout = this.inputLayout;
        if (textInputLayout != null) {
            return textInputLayout.getError();
        }
        return null;
    }

    public final CharSequence getExample() {
        TextView tvExample = getTvExample();
        if (tvExample != null) {
            return tvExample.getText();
        }
        return null;
    }

    public final CharSequence getHint() {
        EditText editText;
        TextInputLayout textInputLayout = this.inputLayout;
        if (textInputLayout == null || (editText = textInputLayout.getEditText()) == null) {
            return null;
        }
        return editText.getHint();
    }

    public final TextInputLayout getInputLayout() {
        return this.inputLayout;
    }

    public abstract CharSequence getLabel();

    public final a<Unit> getOnClear() {
        return this.onClear;
    }

    public l<String, Unit> getOnLinkClicked() {
        return this.onLinkClicked;
    }

    public final Runnable getOnSubmitForm() {
        return this.onSubmitForm;
    }

    public final l<String, Unit> getTextChangedCallback() {
        return this.textChangedCallback;
    }

    public final TextView getTvError() {
        return (TextView) findViewById(R.id.sns_error);
    }

    public final TextView getTvLabel$idensic_mobile_sdk_aar_release() {
        return (TextView) findViewById(R.id.sns_label);
    }

    public String getValue() {
        String rawText;
        TextInputLayout textInputLayout = this.inputLayout;
        Editable editable = null;
        EditText editText = textInputLayout != null ? textInputLayout.getEditText() : null;
        SNSTextInputEditText sNSTextInputEditText = editText instanceof SNSTextInputEditText ? (SNSTextInputEditText) editText : null;
        if (sNSTextInputEditText != null && (rawText = sNSTextInputEditText.getRawText()) != null) {
            return rawText;
        }
        if (editText != null) {
            editable = editText.getText();
        }
        return String.valueOf(editable);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.initizationFinishedCalled) {
            throw new IllegalStateException(("onInitializationFinished not called for " + i.a((Object) this)).toString());
        }
    }

    public final void onInitializationFinished() {
        this.initizationFinishedCalled = true;
        EditText editText = getEditText();
        if (editText != null) {
            editText.addTextChangedListener(new SNSApplicantDataBaseFieldView$onInitializationFinished$$inlined$addTextChangedListener$default$1(this));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        r0 = (r0 = r0.getEditText()).getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setError(java.lang.CharSequence r2) {
        /*
            r1 = this;
            com.google.android.material.textfield.TextInputLayout r0 = r1.inputLayout
            if (r0 != 0) goto L_0x0005
            goto L_0x0008
        L_0x0005:
            r0.setError(r2)
        L_0x0008:
            com.google.android.material.textfield.TextInputLayout r2 = r1.inputLayout
            if (r2 == 0) goto L_0x002b
            android.widget.EditText r2 = r2.getEditText()
            if (r2 == 0) goto L_0x002b
            com.google.android.material.textfield.TextInputLayout r0 = r1.inputLayout
            if (r0 == 0) goto L_0x0027
            android.widget.EditText r0 = r0.getEditText()
            if (r0 == 0) goto L_0x0027
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0027
            int r0 = r0.length()
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            r2.setSelection(r0)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView.setError(java.lang.CharSequence):void");
    }

    public final void setExample(CharSequence charSequence) {
        TextView tvExample = getTvExample();
        if (tvExample != null) {
            i.a(tvExample, charSequence);
        }
    }

    public final void setHint(CharSequence charSequence) {
        TextInputLayout textInputLayout = this.inputLayout;
        EditText editText = textInputLayout != null ? textInputLayout.getEditText() : null;
        if (editText != null) {
            editText.setHint(charSequence);
        }
    }

    public final void setInputLayout$idensic_mobile_sdk_aar_release(TextInputLayout textInputLayout) {
        this.inputLayout = textInputLayout;
    }

    public abstract void setLabel(CharSequence charSequence);

    public final void setOnClear(a<Unit> aVar) {
        this.onClear = aVar;
    }

    public void setOnLinkClicked(l<? super String, Unit> lVar) {
        TextView tvLabel$idensic_mobile_sdk_aar_release = getTvLabel$idensic_mobile_sdk_aar_release();
        if (tvLabel$idensic_mobile_sdk_aar_release != null) {
            b.a(tvLabel$idensic_mobile_sdk_aar_release, lVar);
        }
        TextView tvExample = getTvExample();
        if (tvExample != null) {
            b.a(tvExample, lVar);
        }
        this.onLinkClicked = lVar;
    }

    public final void setOnSubmitForm(Runnable runnable) {
        this.onSubmitForm = runnable;
    }

    public final void setTextChangedCallback(l<? super String, Unit> lVar) {
        this.textChangedCallback = lVar;
    }

    public void setValue(String str) {
        EditText editText;
        EditText editText2;
        TextInputLayout textInputLayout = this.inputLayout;
        if (!(textInputLayout == null || (editText2 = textInputLayout.getEditText()) == null)) {
            editText2.setText(str);
        }
        TextInputLayout textInputLayout2 = this.inputLayout;
        if (textInputLayout2 != null && (editText = textInputLayout2.getEditText()) != null) {
            editText.setSelection(str.length());
        }
    }

    public SNSApplicantDataBaseFieldView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSApplicantDataBaseFieldView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataBaseFieldView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_applicantDataFieldViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSApplicantDataFieldView : i12);
    }

    public SNSApplicantDataBaseFieldView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }
}
