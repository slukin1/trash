package com.sumsub.sns.core.widget.autocompletePhone;

import android.text.Editable;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.data.listener.b;
import com.sumsub.sns.core.widget.SNSTextInputEditText;
import com.sumsub.sns.internal.core.data.model.remote.c;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/sumsub/sns/core/widget/autocompletePhone/PhoneNumberKitV2$1$1", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$SNSCountryPickerCallBack;", "onItemSelected", "", "item", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneNumberKitV2$1$1 implements SNSCountryPicker.SNSCountryPickerCallBack {
    public final /* synthetic */ List<SNSTextInputEditText.Mask> $masks;
    public final /* synthetic */ PhoneNumberKitV2 this$0;

    public PhoneNumberKitV2$1$1(List<SNSTextInputEditText.Mask> list, PhoneNumberKitV2 phoneNumberKitV2) {
        this.$masks = list;
        this.this$0 = phoneNumberKitV2;
    }

    public /* synthetic */ void onDismiss() {
        b.a(this);
    }

    public void onItemSelected(SNSCountryPicker.CountryItem countryItem) {
        SNSTextInputEditText.Mask mask;
        Editable text;
        Editable text2;
        c cVar;
        String c11;
        T t11;
        List<SNSTextInputEditText.Mask> list = this.$masks;
        String str = null;
        if (list != null) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t11 = null;
                    break;
                }
                t11 = it2.next();
                Object payload = ((SNSTextInputEditText.Mask) t11).getPayload();
                SNSCountryPicker.CountryItem countryItem2 = payload instanceof SNSCountryPicker.CountryItem ? (SNSCountryPicker.CountryItem) payload : null;
                if (x.b(countryItem2 != null ? countryItem2.getCode() : null, countryItem.getCode())) {
                    break;
                }
            }
            mask = (SNSTextInputEditText.Mask) t11;
        } else {
            mask = null;
        }
        int i11 = 0;
        this.this$0.setCountry(countryItem, false);
        Object payload2 = mask != null ? mask.getPayload() : null;
        SNSCountryPicker.CountryItem countryItem3 = payload2 instanceof SNSCountryPicker.CountryItem ? (SNSCountryPicker.CountryItem) payload2 : null;
        if (countryItem3 != null) {
            PhoneNumberKitV2 phoneNumberKitV2 = this.this$0;
            Map access$getPhoneMasks = phoneNumberKitV2.getPhoneMasks();
            if (!(access$getPhoneMasks == null || (cVar = (c) access$getPhoneMasks.get(countryItem3.getCode())) == null || (c11 = cVar.c()) == null)) {
                str = StringsKt__StringsJVMKt.G(c11, " ", "", false, 4, (Object) null);
            }
            SNSTextInputEditText access$getEditText = phoneNumberKitV2.getEditText();
            if (!(access$getEditText == null || (text2 = access$getEditText.getText()) == null)) {
                text2.clear();
            }
            phoneNumberKitV2.manuallySelectedCountryKey = countryItem.getCode();
            SNSTextInputEditText access$getEditText2 = phoneNumberKitV2.getEditText();
            if (access$getEditText2 != null) {
                access$getEditText2.setText(str);
            }
            SNSTextInputEditText access$getEditText3 = phoneNumberKitV2.getEditText();
            if (access$getEditText3 != null) {
                SNSTextInputEditText access$getEditText4 = phoneNumberKitV2.getEditText();
                if (!(access$getEditText4 == null || (text = access$getEditText4.getText()) == null)) {
                    i11 = text.length();
                }
                access$getEditText3.setSelection(i11);
            }
        }
    }
}
