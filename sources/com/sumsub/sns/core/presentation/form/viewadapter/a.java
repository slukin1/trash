package com.sumsub.sns.core.presentation.form.viewadapter;

import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBoolFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class a extends k<FormItem.a, SNSApplicantDataBoolFieldView> {

    /* renamed from: b  reason: collision with root package name */
    public c f30964b;

    /* renamed from: com.sumsub.sns.core.presentation.form.viewadapter.a$a  reason: collision with other inner class name */
    public static final class C0293a extends Lambda implements l<Boolean, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30965a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.a f30966b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataBoolFieldView f30967c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0293a(a aVar, FormItem.a aVar2, SNSApplicantDataBoolFieldView sNSApplicantDataBoolFieldView) {
            super(1);
            this.f30965a = aVar;
            this.f30966b = aVar2;
            this.f30967c = sNSApplicantDataBoolFieldView;
        }

        public final void a(boolean z11) {
            c d11 = this.f30965a.d();
            if (d11 != null) {
                FormItem.a aVar = this.f30966b;
                d11.b(aVar, f.b(this.f30967c, aVar));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.f56620a;
        }
    }

    public a(SNSApplicantDataBoolFieldView sNSApplicantDataBoolFieldView, c cVar) {
        super(sNSApplicantDataBoolFieldView);
        this.f30964b = cVar;
    }

    public final c d() {
        return this.f30964b;
    }

    public final void a(c cVar) {
        this.f30964b = cVar;
    }

    public void a(SNSApplicantDataBoolFieldView sNSApplicantDataBoolFieldView, FormItem.a aVar, int i11) {
        sNSApplicantDataBoolFieldView.setOnCheckedChanged(new C0293a(this, aVar, sNSApplicantDataBoolFieldView));
    }
}
