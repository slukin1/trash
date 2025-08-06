package com.sumsub.sns.core.data.listener;

import android.content.Context;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import java.util.List;

public final /* synthetic */ class a {
    public static /* synthetic */ void a(SNSCountryPicker sNSCountryPicker, Context context, List list, SNSCountryPicker.SNSCountryPickerCallBack sNSCountryPickerCallBack, String str, String str2, int i11, Object obj) {
        if (obj == null) {
            sNSCountryPicker.pickCountry(context, list, sNSCountryPickerCallBack, (i11 & 8) != 0 ? null : str, (i11 & 16) != 0 ? null : str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pickCountry");
    }
}
