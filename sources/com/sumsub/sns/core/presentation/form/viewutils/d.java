package com.sumsub.sns.core.presentation.form.viewutils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataCalendarFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class d {
    @SuppressLint({"ConstantLocale"})

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f31061a;

    public static final class a extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f31062a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.d f31063b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataCalendarFieldView f31064c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, FormItem.d dVar, SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView) {
            super(1);
            this.f31062a = cVar;
            this.f31063b = dVar;
            this.f31064c = sNSApplicantDataCalendarFieldView;
        }

        public final void a(String str) {
            c cVar = this.f31062a;
            if (cVar != null) {
                FormItem.d dVar = this.f31063b;
                cVar.b(dVar, f.b(this.f31064c, dVar));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        f31061a = simpleDateFormat;
    }

    public static final SNSApplicantDataBaseFieldView a(FormItem.d dVar, Context context, c cVar) {
        SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView = new SNSApplicantDataCalendarFieldView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        if (dVar.q()) {
            Calendar instance = Calendar.getInstance();
            instance.add(5, -1);
            sNSApplicantDataCalendarFieldView.setConstraints(new CalendarConstraints.Builder().setValidator(DateValidatorPointBackward.before(instance.getTime().getTime())).build());
        }
        sNSApplicantDataCalendarFieldView.setTextChangedCallback(new a(cVar, dVar, sNSApplicantDataCalendarFieldView));
        return sNSApplicantDataCalendarFieldView;
    }

    public static final void a(SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView, String str) {
        Date date;
        if (str != null) {
            try {
                date = f31061a.parse(str);
            } catch (Exception unused) {
            }
            sNSApplicantDataCalendarFieldView.setSelectedDate(date);
        }
        date = null;
        sNSApplicantDataCalendarFieldView.setSelectedDate(date);
    }

    public static final String a(SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView) {
        Date selectedDate = sNSApplicantDataCalendarFieldView.getSelectedDate();
        if (selectedDate != null) {
            return f31061a.format(selectedDate);
        }
        return null;
    }
}
