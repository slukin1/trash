package com.sumsub.sns.core.widget.autocompletePhone.bottomsheet;

import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.analytics.f;
import com.sumsub.sns.internal.core.analytics.o;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSCountryPickerDialog$countryPickerCallBack$1", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$PickerCallBack;", "onCancel", "", "onDialogClose", "onDismiss", "onItemSelected", "item", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Item;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSCountryPickerDialog$countryPickerCallBack$1 implements SNSPickerDialog.PickerCallBack {
    public final /* synthetic */ SNSCountryPicker.SNSCountryPickerCallBack $value;

    public SNSCountryPickerDialog$countryPickerCallBack$1(SNSCountryPicker.SNSCountryPickerCallBack sNSCountryPickerCallBack) {
        this.$value = sNSCountryPickerCallBack;
    }

    public void onCancel() {
        o.a(f.a(0, 1, (Object) null).a(Screen.CountriesScreen).a().m().c(), false, 1, (Object) null);
    }

    public void onDialogClose() {
        e.b(this);
        o.a(f.a(0, 1, (Object) null).a(Screen.CountriesScreen).a().o().c(), false, 1, (Object) null);
    }

    public void onDismiss() {
        SNSCountryPicker.SNSCountryPickerCallBack sNSCountryPickerCallBack = this.$value;
        if (sNSCountryPickerCallBack != null) {
            sNSCountryPickerCallBack.onDismiss();
        }
    }

    public void onItemSelected(SNSPickerDialog.Item item) {
        SNSCountryPicker.SNSCountryPickerCallBack sNSCountryPickerCallBack = this.$value;
        if (sNSCountryPickerCallBack != null) {
            sNSCountryPickerCallBack.onItemSelected(new SNSCountryPicker.CountryItem(item.getId(), item.getTitle()));
        }
    }
}
