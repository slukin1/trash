package com.sumsub.sns.core.data.listener;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSCountryPickerDialog;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSDefaultCountryPicker;", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker;", "()V", "pickCountry", "", "context", "Landroid/content/Context;", "items", "", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "callback", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$SNSCountryPickerCallBack;", "requestKey", "", "resultKey", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSDefaultCountryPicker implements SNSCountryPicker {
    public void pickCountry(Context context, List<SNSCountryPicker.CountryItem> list, SNSCountryPicker.SNSCountryPickerCallBack sNSCountryPickerCallBack, String str, String str2) {
        FragmentManager supportFragmentManager;
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null && supportFragmentManager.m0(SNSCountryPickerDialog.TAG) == null) {
            SNSCountryPickerDialog newInstance = SNSCountryPickerDialog.Companion.newInstance((SNSCountryPicker.CountryItem[]) list.toArray(new SNSCountryPicker.CountryItem[0]), str, str2);
            newInstance.setCountryPickerCallBack(sNSCountryPickerCallBack);
            newInstance.show(supportFragmentManager, SNSCountryPickerDialog.TAG);
        }
    }
}
