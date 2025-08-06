package com.sumsub.sns.core.presentation.form.viewutils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataDateTimeFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class c {
    @SuppressLint({"ConstantLocale"})

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f31057a;

    public static final class a extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.core.presentation.form.c f31058a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.e f31059b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataDateTimeFieldView f31060c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(com.sumsub.sns.core.presentation.form.c cVar, FormItem.e eVar, SNSApplicantDataDateTimeFieldView sNSApplicantDataDateTimeFieldView) {
            super(1);
            this.f31058a = cVar;
            this.f31059b = eVar;
            this.f31060c = sNSApplicantDataDateTimeFieldView;
        }

        public final void a(String str) {
            com.sumsub.sns.core.presentation.form.c cVar = this.f31058a;
            if (cVar != null) {
                FormItem.e eVar = this.f31059b;
                cVar.b(eVar, f.b(this.f31060c, eVar));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        f31057a = simpleDateFormat;
    }

    public static final SNSApplicantDataBaseFieldView a(FormItem.e eVar, Context context, com.sumsub.sns.core.presentation.form.c cVar) {
        SNSApplicantDataDateTimeFieldView sNSApplicantDataDateTimeFieldView = new SNSApplicantDataDateTimeFieldView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        sNSApplicantDataDateTimeFieldView.setTextChangedCallback(new a(cVar, eVar, sNSApplicantDataDateTimeFieldView));
        return sNSApplicantDataDateTimeFieldView;
    }

    public static final void a(SNSApplicantDataDateTimeFieldView sNSApplicantDataDateTimeFieldView, String str) {
        Date date;
        if (str != null) {
            try {
                date = f31057a.parse(str);
            } catch (Exception unused) {
            }
            sNSApplicantDataDateTimeFieldView.setSelectedDate(date);
        }
        date = null;
        sNSApplicantDataDateTimeFieldView.setSelectedDate(date);
    }

    public static final String a(SNSApplicantDataDateTimeFieldView sNSApplicantDataDateTimeFieldView) {
        Date selectedDate = sNSApplicantDataDateTimeFieldView.getSelectedDate();
        if (selectedDate != null) {
            return f31057a.format(selectedDate);
        }
        return null;
    }
}
