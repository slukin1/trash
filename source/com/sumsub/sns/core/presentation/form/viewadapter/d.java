package com.sumsub.sns.core.presentation.form.viewadapter;

import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class d extends k<FormItem.c, SNSApplicantDataSelectionCountryFieldView> {

    /* renamed from: b  reason: collision with root package name */
    public c f30974b;

    public static final class a extends Lambda implements l<SNSCountryPicker.CountryItem, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30975a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.c f30976b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataSelectionCountryFieldView f30977c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, FormItem.c cVar, SNSApplicantDataSelectionCountryFieldView sNSApplicantDataSelectionCountryFieldView) {
            super(1);
            this.f30975a = dVar;
            this.f30976b = cVar;
            this.f30977c = sNSApplicantDataSelectionCountryFieldView;
        }

        public final void a(SNSCountryPicker.CountryItem countryItem) {
            c d11 = this.f30975a.d();
            if (d11 != null) {
                FormItem.c cVar = this.f30976b;
                d11.b(cVar, f.b(this.f30977c, cVar));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SNSCountryPicker.CountryItem) obj);
            return Unit.f56620a;
        }
    }

    public d(SNSApplicantDataSelectionCountryFieldView sNSApplicantDataSelectionCountryFieldView, c cVar) {
        super(sNSApplicantDataSelectionCountryFieldView);
        this.f30974b = cVar;
    }

    public final c d() {
        return this.f30974b;
    }

    public final void a(c cVar) {
        this.f30974b = cVar;
    }

    public void a(SNSApplicantDataSelectionCountryFieldView sNSApplicantDataSelectionCountryFieldView, FormItem.c cVar, int i11) {
        sNSApplicantDataSelectionCountryFieldView.setItems(SNSCountryPicker.CountryItem.Companion.fromMap(cVar.r()));
        sNSApplicantDataSelectionCountryFieldView.setOnCountrySelectedCallback(new a(this, cVar, sNSApplicantDataSelectionCountryFieldView));
    }
}
