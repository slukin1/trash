package com.sumsub.sns.core.widget;

import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import java.text.DateFormat;
import java.util.Calendar;

public final /* synthetic */ class f implements MaterialPickerOnPositiveButtonClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Calendar f31241a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSDateInputLayout f31242b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DateFormat f31243c;

    public /* synthetic */ f(Calendar calendar, SNSDateInputLayout sNSDateInputLayout, DateFormat dateFormat) {
        this.f31241a = calendar;
        this.f31242b = sNSDateInputLayout;
        this.f31243c = dateFormat;
    }

    public final void onPositiveButtonClick(Object obj) {
        SNSDateInputLayout.m20showCalendar$lambda7$lambda6(this.f31241a, this.f31242b, this.f31243c, (Long) obj);
    }
}
