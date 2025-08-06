package com.sumsub.sns.core.widget.applicantData;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.widget.PhoneKit;
import com.sumsub.sns.core.widget.SNSFlaggedInputLayout;
import com.sumsub.sns.core.widget.autocompletePhone.Constants;
import com.sumsub.sns.internal.core.common.i;
import d10.a;
import d10.l;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010+\u001a\u00020*\u0012\b\b\u0002\u0010,\u001a\u00020*¢\u0006\u0004\b-\u0010.J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f8V@VX\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006/"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataPhoneFieldView;", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView;", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "country", "", "setCountry", "Lcom/sumsub/sns/core/widget/SNSFlaggedInputLayout;", "getPhoneInputLayout", "()Lcom/sumsub/sns/core/widget/SNSFlaggedInputLayout;", "phoneInputLayout", "", "isValid", "()Z", "Lkotlin/Function0;", "phoneNumberValidator", "Ld10/a;", "getPhoneNumberValidator", "()Ld10/a;", "setPhoneNumberValidator", "(Ld10/a;)V", "", "getPurePhoneNumber", "()Ljava/lang/String;", "purePhoneNumber", "Lkotlin/Function1;", "phoneNumberPurifier", "Ld10/l;", "getPhoneNumberPurifier", "()Ld10/l;", "setPhoneNumberPurifier", "(Ld10/l;)V", "", "value", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "label", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSApplicantDataPhoneFieldView extends SNSApplicantDataBaseFieldView {
    private l<? super String, String> phoneNumberPurifier;
    private a<Boolean> phoneNumberValidator;

    public SNSApplicantDataPhoneFieldView(Context context) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView.getLabel():java.lang.CharSequence");
    }

    public final SNSFlaggedInputLayout getPhoneInputLayout() {
        return (SNSFlaggedInputLayout) getInputLayout();
    }

    public final l<String, String> getPhoneNumberPurifier() {
        return this.phoneNumberPurifier;
    }

    public final a<Boolean> getPhoneNumberValidator() {
        return this.phoneNumberValidator;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.invoke(getValue());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getPurePhoneNumber() {
        /*
            r2 = this;
            d10.l<? super java.lang.String, java.lang.String> r0 = r2.phoneNumberPurifier
            if (r0 == 0) goto L_0x0010
            java.lang.String r1 = r2.getValue()
            java.lang.Object r0 = r0.invoke(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0014
        L_0x0010:
            java.lang.String r0 = r2.getValue()
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView.getPurePhoneNumber():java.lang.String");
    }

    public final boolean isValid() {
        a<Boolean> aVar = this.phoneNumberValidator;
        if (aVar != null) {
            return aVar.invoke().booleanValue();
        }
        return !StringsKt__StringsJVMKt.z(getPurePhoneNumber());
    }

    public final void setCountry(SNSCountryPicker.CountryItem countryItem) {
        Object tag = getPhoneInputLayout().getTag(Constants.INSTANCE.getTOOLKIT_TAG());
        PhoneKit phoneKit = tag instanceof PhoneKit ? (PhoneKit) tag : null;
        if (phoneKit != null) {
            phoneKit.setCountry(countryItem, true);
        }
    }

    public void setLabel(CharSequence charSequence) {
        TextView tvLabel$idensic_mobile_sdk_aar_release = getTvLabel$idensic_mobile_sdk_aar_release();
        if (tvLabel$idensic_mobile_sdk_aar_release != null) {
            i.a(tvLabel$idensic_mobile_sdk_aar_release, charSequence);
        }
    }

    public final void setPhoneNumberPurifier(l<? super String, String> lVar) {
        this.phoneNumberPurifier = lVar;
    }

    public final void setPhoneNumberValidator(a<Boolean> aVar) {
        this.phoneNumberValidator = aVar;
    }

    public SNSApplicantDataPhoneFieldView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSApplicantDataPhoneFieldView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataPhoneFieldView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_applicantDataPhoneFieldLayout : i11, (i13 & 8) != 0 ? R.style.Widget_SNSApplicantDataFieldView_Phone : i12);
    }

    public SNSApplicantDataPhoneFieldView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, 0, 8, (r) null);
        EditText editText;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSApplicantDataPhoneFieldView, i11, i12);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SNSApplicantDataPhoneFieldView_sns_applicantDataPhoneFieldLayout, R.layout.sns_layout_applicant_data_phone_field), this, true);
        obtainStyledAttributes.recycle();
        EditText editText2 = getEditText();
        if (editText2 != null) {
            editText2.setInputType(3);
        }
        EditText editText3 = getEditText();
        if (editText3 != null) {
            editText3.setFilters(new AnonymousClass2[]{new InputFilter() {
                public CharSequence filter(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
                    StringBuilder sb2 = new StringBuilder();
                    int length = charSequence.length();
                    for (int i15 = 0; i15 < length; i15++) {
                        char charAt = charSequence.charAt(i15);
                        if (Character.isDigit(charAt) || charAt == '+') {
                            sb2.append(charAt);
                        }
                    }
                    return sb2;
                }
            }});
        }
        setInputLayout$idensic_mobile_sdk_aar_release((TextInputLayout) findViewById(R.id.sns_phone));
        TextInputLayout inputLayout = getInputLayout();
        if (!(inputLayout == null || (editText = inputLayout.getEditText()) == null)) {
            editText.addTextChangedListener(new SNSApplicantDataPhoneFieldView$special$$inlined$doAfterTextChanged$1(this));
        }
        onInitializationFinished();
    }
}
