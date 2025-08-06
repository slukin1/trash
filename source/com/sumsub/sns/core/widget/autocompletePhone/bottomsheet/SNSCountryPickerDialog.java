package com.sumsub.sns.core.widget.autocompletePhone.bottomsheet;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.data.listener.SNSDefaultCountryPickerKt;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.analytics.f;
import com.sumsub.sns.internal.core.analytics.o;
import com.sumsub.sns.internal.core.theme.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rR\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u001a\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSCountryPickerDialog;", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog;", "()V", "value", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$SNSCountryPickerCallBack;", "countryPickerCallBack", "getCountryPickerCallBack", "()Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$SNSCountryPickerCallBack;", "setCountryPickerCallBack", "(Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$SNSCountryPickerCallBack;)V", "bindItemViewHolder", "", "holder", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$PickerItemViewHolder;", "position", "", "item", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Item;", "getThemeBackgroundColor", "view", "Landroid/view/View;", "(Landroid/view/View;)Ljava/lang/Integer;", "onResume", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSCountryPickerDialog extends SNSPickerDialog {
    public static final Companion Companion = new Companion((r) null);
    public static final String TAG = "SNSCountryPickerDialog";
    private SNSCountryPicker.SNSCountryPickerCallBack countryPickerCallBack;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSCountryPickerDialog$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSCountryPickerDialog;", "items", "", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "requestKey", "resultKey", "([Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;Ljava/lang/String;Ljava/lang/String;)Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSCountryPickerDialog;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public static /* synthetic */ SNSCountryPickerDialog newInstance$default(Companion companion, SNSCountryPicker.CountryItem[] countryItemArr, String str, String str2, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                str = null;
            }
            if ((i11 & 4) != 0) {
                str2 = null;
            }
            return companion.newInstance(countryItemArr, str, str2);
        }

        public final SNSCountryPickerDialog newInstance(SNSCountryPicker.CountryItem[] countryItemArr, String str, String str2) {
            SNSCountryPickerDialog sNSCountryPickerDialog = new SNSCountryPickerDialog();
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList(countryItemArr.length);
            for (SNSCountryPicker.CountryItem countryItem : countryItemArr) {
                arrayList.add(new SNSPickerDialog.Item(countryItem.getCode(), countryItem.getName()));
            }
            bundle.putParcelableArray(SNSPickerDialog.EXTRA_ITEMS, (SNSPickerDialog.Item[]) arrayList.toArray(new SNSPickerDialog.Item[0]));
            bundle.putInt(SNSPickerDialog.EXTRA_ITEM_LAYOUT_ID, R.layout.sns_countries_list_item);
            bundle.putBoolean(SNSPickerDialog.EXTRA_SHOW_SEARCH, true);
            bundle.putBoolean(SNSPickerDialog.EXTRA_SORT, true);
            if (str != null) {
                bundle.putString(SNSPickerDialog.EXTRA_REQUEST_KEY, str);
            }
            if (str2 != null) {
                bundle.putString(SNSPickerDialog.EXTRA_RESULT_KEY, str2);
            }
            sNSCountryPickerDialog.setArguments(bundle);
            return sNSCountryPickerDialog;
        }

        private Companion() {
        }
    }

    public void bindItemViewHolder(SNSPickerDialog.PickerItemViewHolder pickerItemViewHolder, int i11, SNSPickerDialog.Item item) {
        super.bindItemViewHolder(pickerItemViewHolder, i11, item);
        ((ImageView) pickerItemViewHolder.itemView.findViewById(16908294)).setImageDrawable(SNSDefaultCountryPickerKt.getFlagDrawable(new SNSCountryPicker.CountryItem(item.getId(), item.getTitle()), requireContext()));
    }

    public final SNSCountryPicker.SNSCountryPickerCallBack getCountryPickerCallBack() {
        return this.countryPickerCallBack;
    }

    public Integer getThemeBackgroundColor(View view) {
        a aVar = a.f31095a;
        d a11 = aVar.a();
        if (a11 != null) {
            return aVar.a(a11, SNSColorElement.BACKGROUND_COMMON, aVar.a(view));
        }
        return null;
    }

    public void onResume() {
        super.onResume();
        o.a(f.a(0, 1, (Object) null).a(Screen.CountriesScreen).a().j().c(), false, 1, (Object) null);
        super.onResume();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        o.a(f.a(0, 1, (Object) null).a(Screen.CountriesScreen).a().b().c(), false, 1, (Object) null);
    }

    public final void setCountryPickerCallBack(SNSCountryPicker.SNSCountryPickerCallBack sNSCountryPickerCallBack) {
        setPickerCallBack(new SNSCountryPickerDialog$countryPickerCallBack$1(sNSCountryPickerCallBack));
        this.countryPickerCallBack = sNSCountryPickerCallBack;
    }
}
