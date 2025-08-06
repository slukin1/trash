package com.sumsub.sns.core.widget.autocompletePhone;

import android.text.TextWatcher;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"com/sumsub/sns/core/widget/autocompletePhone/PhoneNumberKitV2$special$$inlined$addTextChangedListener$default$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "s", "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
public final class PhoneNumberKitV2$special$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    public final /* synthetic */ ValidationListener $validListener$inlined;
    public final /* synthetic */ PhoneNumberKitV2 this$0;

    public PhoneNumberKitV2$special$$inlined$addTextChangedListener$default$1(ValidationListener validationListener, PhoneNumberKitV2 phoneNumberKitV2) {
        this.$validListener$inlined = validationListener;
        this.this$0 = phoneNumberKitV2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r1 = r1.getRawText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void afterTextChanged(android.text.Editable r3) {
        /*
            r2 = this;
            com.sumsub.sns.core.widget.autocompletePhone.ValidationListener r3 = r2.$validListener$inlined
            if (r3 == 0) goto L_0x0021
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2 r0 = r2.this$0
            boolean r0 = r0.isValid()
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2 r1 = r2.this$0
            com.sumsub.sns.core.widget.SNSTextInputEditText r1 = r1.getEditText()
            if (r1 == 0) goto L_0x001d
            java.lang.String r1 = r1.getRawText()
            if (r1 == 0) goto L_0x001d
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.z(r1)
            goto L_0x001e
        L_0x001d:
            r1 = 0
        L_0x001e:
            r3.onValidate(r0, r1)
        L_0x0021:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2$special$$inlined$addTextChangedListener$default$1.afterTextChanged(android.text.Editable):void");
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }
}
