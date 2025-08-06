package com.huobi.view;

import android.view.View;
import android.widget.DatePicker;

public final /* synthetic */ class d0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DatePickerDialog f19019b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DatePicker f19020c;

    public /* synthetic */ d0(DatePickerDialog datePickerDialog, DatePicker datePicker) {
        this.f19019b = datePickerDialog;
        this.f19020c = datePicker;
    }

    public final void onClick(View view) {
        this.f19019b.lambda$initView$2(this.f19020c, view);
    }
}
