package com.sumsub.sns.core.presentation.form.viewadapter;

import android.os.Bundle;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.PhoneKit;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView;
import com.sumsub.sns.core.widget.autocompletePhone.PhoneKitProviderKt;
import com.sumsub.sns.core.widget.autocompletePhone.ValidationListener;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class n extends k<FormItem.k, SNSApplicantDataPhoneFieldView> {

    /* renamed from: b  reason: collision with root package name */
    public com.sumsub.sns.core.presentation.form.c f31026b;

    /* renamed from: c  reason: collision with root package name */
    public FormItem f31027c;

    /* renamed from: d  reason: collision with root package name */
    public FormItem f31028d;

    public static final class a extends Lambda implements l<String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneKit f31029a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PhoneKit phoneKit) {
            super(1);
            this.f31029a = phoneKit;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r2 = r0.a(r2);
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String invoke(java.lang.String r2) {
            /*
                r1 = this;
                com.sumsub.sns.core.widget.PhoneKit r0 = r1.f31029a
                com.sumsub.sns.internal.core.data.model.remote.c r0 = r0.getMask()
                if (r0 == 0) goto L_0x000e
                java.lang.String r2 = r0.a(r2)
                if (r2 != 0) goto L_0x0010
            L_0x000e:
                java.lang.String r2 = ""
            L_0x0010:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.form.viewadapter.n.a.invoke(java.lang.String):java.lang.String");
        }
    }

    public static final class b extends Lambda implements d10.a<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneKit f31030a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PhoneKit phoneKit) {
            super(0);
            this.f31030a = phoneKit;
        }

        /* renamed from: a */
        public final Boolean invoke() {
            return Boolean.valueOf(this.f31030a.isValid());
        }
    }

    public static final class c extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneKit f31031a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f31032b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FormItem.k f31033c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataPhoneFieldView f31034d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(PhoneKit phoneKit, n nVar, FormItem.k kVar, SNSApplicantDataPhoneFieldView sNSApplicantDataPhoneFieldView) {
            super(1);
            this.f31031a = phoneKit;
            this.f31032b = nVar;
            this.f31033c = kVar;
            this.f31034d = sNSApplicantDataPhoneFieldView;
        }

        public final void a(String str) {
            n nVar;
            com.sumsub.sns.core.presentation.form.c d11;
            n nVar2;
            com.sumsub.sns.core.presentation.form.c d12;
            com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, "SNSApplicantDataPhoneFieldView", "textChangedCallback: " + str, (Throwable) null, 4, (Object) null);
            SNSCountryPicker.CountryItem country = this.f31031a.getCountry();
            FormItem formItem = null;
            if (!(country == null || (d12 = nVar2.d()) == null)) {
                FormItem b11 = (nVar2 = this.f31032b).f31027c;
                if (b11 == null) {
                    b11 = null;
                }
                d12.b(b11, country.getCode());
            }
            com.sumsub.sns.internal.core.data.model.remote.c mask = this.f31031a.getMask();
            if (!(mask == null || (d11 = nVar.d()) == null)) {
                FormItem c11 = (nVar = this.f31032b).f31028d;
                if (c11 != null) {
                    formItem = c11;
                }
                d11.b(formItem, mask.c());
            }
            com.sumsub.sns.core.presentation.form.c d13 = this.f31032b.d();
            if (d13 != null) {
                FormItem.k kVar = this.f31033c;
                d13.b(kVar, f.b(this.f31034d, kVar));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class d extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneKit f31035a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f31036b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(PhoneKit phoneKit, n nVar) {
            super(0);
            this.f31035a = phoneKit;
            this.f31036b = nVar;
        }

        public final void a() {
            this.f31035a.detach(this.f31036b.a());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class e implements ValidationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f31037a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.k f31038b;

        public e(n nVar, FormItem.k kVar) {
            this.f31037a = nVar;
            this.f31038b = kVar;
        }

        public void onValidate(boolean z11, boolean z12) {
            com.sumsub.sns.core.presentation.form.c d11 = this.f31037a.d();
            if (d11 != null) {
                d11.a(this.f31038b, z11, z12);
            }
        }
    }

    public n(SNSApplicantDataPhoneFieldView sNSApplicantDataPhoneFieldView, com.sumsub.sns.core.presentation.form.c cVar) {
        super(sNSApplicantDataPhoneFieldView);
        this.f31026b = cVar;
    }

    public final com.sumsub.sns.core.presentation.form.c d() {
        return this.f31026b;
    }

    public final void a(com.sumsub.sns.core.presentation.form.c cVar) {
        this.f31026b = cVar;
    }

    public void a(SNSApplicantDataPhoneFieldView sNSApplicantDataPhoneFieldView, FormItem.k kVar, int i11) {
        this.f31027c = com.sumsub.sns.core.presentation.form.model.a.a(kVar);
        this.f31028d = com.sumsub.sns.core.presentation.form.model.a.b(kVar);
        Set<Map.Entry<String, String>> entrySet = kVar.t().entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(entrySet, 10));
        for (Map.Entry entry : entrySet) {
            arrayList.add(new SNSCountryPicker.CountryItem((String) entry.getKey(), (String) entry.getValue()));
        }
        if (!arrayList.isEmpty()) {
            sNSApplicantDataPhoneFieldView.clear();
            PhoneKit phoneKit$default = PhoneKitProviderKt.getPhoneKit$default(sNSApplicantDataPhoneFieldView.getPhoneInputLayout(), kVar.t(), kVar.v(), new e(this, kVar), (CharSequence) null, 16, (Object) null);
            sNSApplicantDataPhoneFieldView.setPhoneNumberPurifier(new a(phoneKit$default));
            if (!kVar.w()) {
                sNSApplicantDataPhoneFieldView.setPhoneNumberValidator(new b(phoneKit$default));
            }
            PhoneKit.attachToInput$default(phoneKit$default, sNSApplicantDataPhoneFieldView.getPhoneInputLayout(), arrayList, (SNSCountryPicker.CountryItem) null, (Bundle) null, 8, (Object) null);
            sNSApplicantDataPhoneFieldView.setTextChangedCallback(new c(phoneKit$default, this, kVar, sNSApplicantDataPhoneFieldView));
            sNSApplicantDataPhoneFieldView.setOnClear(new d(phoneKit$default, this));
        }
    }
}
