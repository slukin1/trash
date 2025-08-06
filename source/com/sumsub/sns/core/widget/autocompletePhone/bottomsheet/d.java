package com.sumsub.sns.core.widget.autocompletePhone.bottomsheet;

import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog;
import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSPickerDialog.ItemAdapter f31232b;

    public /* synthetic */ d(SNSPickerDialog.ItemAdapter itemAdapter) {
        this.f31232b = itemAdapter;
    }

    public final int compare(Object obj, Object obj2) {
        return SNSPickerDialog.ItemAdapter.m53itemComparator$lambda0(this.f31232b, (SNSPickerDialog.Item) obj, (SNSPickerDialog.Item) obj2);
    }
}
