package com.sumsub.sns.core.widget.autocompletePhone.bottomsheet;

import android.view.View;
import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSPickerDialog f31230b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SNSPickerDialog.Item f31231c;

    public /* synthetic */ c(SNSPickerDialog sNSPickerDialog, SNSPickerDialog.Item item) {
        this.f31230b = sNSPickerDialog;
        this.f31231c = item;
    }

    public final void onClick(View view) {
        SNSPickerDialog.m50bindItemViewHolder$lambda10(this.f31230b, this.f31231c, view);
    }
}
