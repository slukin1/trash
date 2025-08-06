package com.sumsub.sns.core.widget;

import android.view.View;
import com.google.android.material.timepicker.MaterialTimePicker;
import java.util.Calendar;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Calendar f31245b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MaterialTimePicker f31246c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SNSDateTimeInputLayout f31247d;

    public /* synthetic */ h(Calendar calendar, MaterialTimePicker materialTimePicker, SNSDateTimeInputLayout sNSDateTimeInputLayout) {
        this.f31245b = calendar;
        this.f31246c = materialTimePicker;
        this.f31247d = sNSDateTimeInputLayout;
    }

    public final void onClick(View view) {
        SNSDateTimeInputLayout.m24showTime$lambda8(this.f31245b, this.f31246c, this.f31247d, view);
    }
}
