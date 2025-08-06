package com.sumsub.sns.core.presentation.form.viewadapter;

import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataDateTimeFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class e extends k<FormItem.e, SNSApplicantDataDateTimeFieldView> {

    /* renamed from: b  reason: collision with root package name */
    public c f30978b;

    public static final class a extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f30979a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.e f30980b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataDateTimeFieldView f30981c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, FormItem.e eVar2, SNSApplicantDataDateTimeFieldView sNSApplicantDataDateTimeFieldView) {
            super(1);
            this.f30979a = eVar;
            this.f30980b = eVar2;
            this.f30981c = sNSApplicantDataDateTimeFieldView;
        }

        public final void a(String str) {
            c d11 = this.f30979a.d();
            if (d11 != null) {
                FormItem.e eVar = this.f30980b;
                d11.b(eVar, f.b(this.f30981c, eVar));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public e(SNSApplicantDataDateTimeFieldView sNSApplicantDataDateTimeFieldView, c cVar) {
        super(sNSApplicantDataDateTimeFieldView);
        this.f30978b = cVar;
    }

    public final c d() {
        return this.f30978b;
    }

    public final void a(c cVar) {
        this.f30978b = cVar;
    }

    public void a(SNSApplicantDataDateTimeFieldView sNSApplicantDataDateTimeFieldView, FormItem.e eVar, int i11) {
        sNSApplicantDataDateTimeFieldView.setTextChangedCallback(new a(this, eVar, sNSApplicantDataDateTimeFieldView));
    }
}
