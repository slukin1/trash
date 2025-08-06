package com.sumsub.sns.core.widget;

import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import java.util.Calendar;
import kotlin.jvm.internal.Ref$ObjectRef;

public final /* synthetic */ class j implements MaterialPickerOnPositiveButtonClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Calendar f31249a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSDateTimeInputLayout f31250b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f31251c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f31252d;

    public /* synthetic */ j(Calendar calendar, SNSDateTimeInputLayout sNSDateTimeInputLayout, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2) {
        this.f31249a = calendar;
        this.f31250b = sNSDateTimeInputLayout;
        this.f31251c = ref$ObjectRef;
        this.f31252d = ref$ObjectRef2;
    }

    public final void onPositiveButtonClick(Object obj) {
        SNSDateTimeInputLayout.m23showCalendar$lambda5$lambda4(this.f31249a, this.f31250b, this.f31251c, this.f31252d, (Long) obj);
    }
}
