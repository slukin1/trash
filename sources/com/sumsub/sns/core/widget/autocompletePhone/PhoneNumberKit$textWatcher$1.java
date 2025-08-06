package com.sumsub.sns.core.widget.autocompletePhone;

import com.sumsub.sns.core.widget.SNSFlaggedInputLayout;
import com.sumsub.sns.core.widget.autocompletePhone.util.PhoneNumberTextWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"com/sumsub/sns/core/widget/autocompletePhone/PhoneNumberKit$textWatcher$1", "Lcom/sumsub/sns/core/widget/autocompletePhone/util/PhoneNumberTextWatcher;", "onTextChanged", "", "text", "", "start", "", "before", "count", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneNumberKit$textWatcher$1 extends PhoneNumberTextWatcher {
    public final /* synthetic */ PhoneNumberKit this$0;

    public PhoneNumberKit$textWatcher$1(PhoneNumberKit phoneNumberKit) {
        this.this$0 = phoneNumberKit;
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        SNSFlaggedInputLayout access$getInput$p = this.this$0.input;
        if (!x.b(access$getInput$p != null ? access$getInput$p.getTag() : null, "#")) {
            this.this$0.phoneNumberViewController.onTextChanged(String.valueOf(charSequence));
        }
    }
}
