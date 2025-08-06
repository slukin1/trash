package com.sumsub.sns.core.widget.autocompletePhone;

import com.sumsub.sns.core.widget.PhoneKit;
import com.sumsub.sns.core.widget.SNSFlaggedInputLayout;
import com.sumsub.sns.internal.core.data.model.remote.c;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a^\u0010\u000e\u001a\u00020\r2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\u0004\u0018\u0001`\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSFlaggedInputLayout;", "input", "", "", "Lcom/sumsub/sns/internal/core/data/model/CountryCodeToNameMap;", "countries", "Lcom/sumsub/sns/internal/core/data/model/remote/c;", "Lcom/sumsub/sns/internal/core/data/model/PhoneCountryCodeWithMasks;", "phoneMasks", "Lcom/sumsub/sns/core/widget/autocompletePhone/ValidationListener;", "validationListener", "", "initialValue", "Lcom/sumsub/sns/core/widget/PhoneKit;", "getPhoneKit", "idensic-mobile-sdk-aar_release"}, k = 2, mv = {1, 7, 1})
public final class PhoneKitProviderKt {
    public static final PhoneKit getPhoneKit(SNSFlaggedInputLayout sNSFlaggedInputLayout, Map<String, String> map, Map<String, c> map2, ValidationListener validationListener, CharSequence charSequence) {
        return new PhoneNumberKitV2(sNSFlaggedInputLayout, map, map2, validationListener, charSequence);
    }

    public static /* synthetic */ PhoneKit getPhoneKit$default(SNSFlaggedInputLayout sNSFlaggedInputLayout, Map map, Map map2, ValidationListener validationListener, CharSequence charSequence, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            charSequence = null;
        }
        return getPhoneKit(sNSFlaggedInputLayout, map, map2, validationListener, charSequence);
    }
}
