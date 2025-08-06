package com.sumsub.sns.core.widget;

import android.content.Context;
import android.os.Bundle;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.widget.autocompletePhone.ValidationListener;
import com.sumsub.sns.internal.core.data.model.remote.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001BK\u0012\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0004\u0018\u0001`\u0017\u0012\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0015j\u0004\u0018\u0001`\u001c\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J4\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0016R.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0004\u0018\u0001`\u00178\u0004X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR.\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0015j\u0004\u0018\u0001`\u001c8\u0004X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0004X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010*\u001a\u0004\u0018\u00010\u001b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/sumsub/sns/core/widget/PhoneKit;", "", "Landroid/os/Bundle;", "outState", "", "saveInstanceState", "Landroid/content/Context;", "context", "detach", "Lcom/sumsub/sns/core/widget/SNSFlaggedInputLayout;", "input", "", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "countries", "defaultCountry", "savedInstanceState", "attachToInput", "country", "", "isUser", "setCountry", "", "", "Lcom/sumsub/sns/internal/core/data/model/CountryCodeToNameMap;", "Ljava/util/Map;", "getCountries", "()Ljava/util/Map;", "Lcom/sumsub/sns/internal/core/data/model/remote/c;", "Lcom/sumsub/sns/internal/core/data/model/PhoneCountryCodeWithMasks;", "phoneMasks", "getPhoneMasks", "Lcom/sumsub/sns/core/widget/autocompletePhone/ValidationListener;", "validListener", "Lcom/sumsub/sns/core/widget/autocompletePhone/ValidationListener;", "getValidListener", "()Lcom/sumsub/sns/core/widget/autocompletePhone/ValidationListener;", "isValid", "()Z", "getCountry", "()Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "getMask", "()Lcom/sumsub/sns/internal/core/data/model/remote/c;", "mask", "<init>", "(Ljava/util/Map;Ljava/util/Map;Lcom/sumsub/sns/core/widget/autocompletePhone/ValidationListener;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public abstract class PhoneKit {
    private final Map<String, String> countries;
    private final Map<String, c> phoneMasks;
    private final ValidationListener validListener;

    public PhoneKit(Map<String, String> map, Map<String, c> map2, ValidationListener validationListener) {
        this.countries = map;
        this.phoneMasks = map2;
        this.validListener = validationListener;
    }

    public static /* synthetic */ void attachToInput$default(PhoneKit phoneKit, SNSFlaggedInputLayout sNSFlaggedInputLayout, List list, SNSCountryPicker.CountryItem countryItem, Bundle bundle, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 8) != 0) {
                bundle = null;
            }
            phoneKit.attachToInput(sNSFlaggedInputLayout, list, countryItem, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachToInput");
    }

    public static /* synthetic */ void setCountry$default(PhoneKit phoneKit, SNSCountryPicker.CountryItem countryItem, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            phoneKit.setCountry(countryItem, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCountry");
    }

    public void attachToInput(SNSFlaggedInputLayout sNSFlaggedInputLayout, List<SNSCountryPicker.CountryItem> list, SNSCountryPicker.CountryItem countryItem, Bundle bundle) {
    }

    public void detach(Context context) {
    }

    public final Map<String, String> getCountries() {
        return this.countries;
    }

    public abstract SNSCountryPicker.CountryItem getCountry();

    public abstract c getMask();

    public final Map<String, c> getPhoneMasks() {
        return this.phoneMasks;
    }

    public final ValidationListener getValidListener() {
        return this.validListener;
    }

    public abstract boolean isValid();

    public void saveInstanceState(Bundle bundle) {
    }

    public void setCountry(SNSCountryPicker.CountryItem countryItem, boolean z11) {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhoneKit(Map map, Map map2, ValidationListener validationListener, int i11, r rVar) {
        this(map, map2, (i11 & 4) != 0 ? null : validationListener);
    }
}
