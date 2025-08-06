package com.sumsub.sns.core.presentation.form.viewadapter;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataCalendarFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import java.util.Calendar;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class b extends k<FormItem.d, SNSApplicantDataCalendarFieldView> {

    /* renamed from: b  reason: collision with root package name */
    public c f30968b;

    public static final class a extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f30969a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.d f30970b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataCalendarFieldView f30971c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, FormItem.d dVar, SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView) {
            super(1);
            this.f30969a = bVar;
            this.f30970b = dVar;
            this.f30971c = sNSApplicantDataCalendarFieldView;
        }

        public final void a(String str) {
            c d11 = this.f30969a.d();
            if (d11 != null) {
                FormItem.d dVar = this.f30970b;
                d11.b(dVar, f.b(this.f30971c, dVar));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public b(SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView, c cVar) {
        super(sNSApplicantDataCalendarFieldView);
        this.f30968b = cVar;
    }

    public final c d() {
        return this.f30968b;
    }

    public final void a(c cVar) {
        this.f30968b = cVar;
    }

    public void a(SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView, FormItem.d dVar, int i11) {
        if (dVar.q()) {
            sNSApplicantDataCalendarFieldView.setConstraints(new CalendarConstraints.Builder().setValidator(DateValidatorPointBackward.before(Calendar.getInstance().getTime().getTime())).build());
        }
        sNSApplicantDataCalendarFieldView.setTextChangedCallback(new a(this, dVar, sNSApplicantDataCalendarFieldView));
    }
}
