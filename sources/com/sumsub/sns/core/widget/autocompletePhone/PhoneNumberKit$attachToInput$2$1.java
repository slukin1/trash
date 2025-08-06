package com.sumsub.sns.core.widget.autocompletePhone;

import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.data.listener.b;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/sumsub/sns/core/widget/autocompletePhone/PhoneNumberKit$attachToInput$2$1", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$SNSCountryPickerCallBack;", "onItemSelected", "", "item", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneNumberKit$attachToInput$2$1 implements SNSCountryPicker.SNSCountryPickerCallBack {
    public final /* synthetic */ PhoneNumberKit this$0;

    public PhoneNumberKit$attachToInput$2$1(PhoneNumberKit phoneNumberKit) {
        this.this$0 = phoneNumberKit;
    }

    public /* synthetic */ void onDismiss() {
        b.a(this);
    }

    public void onItemSelected(SNSCountryPicker.CountryItem countryItem) {
        this.this$0.setCountry(countryItem, true);
    }
}
