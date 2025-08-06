package com.sumsub.sns.core.presentation.form.viewutils;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.PhoneKit;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView;
import com.sumsub.sns.core.widget.autocompletePhone.PhoneKitProviderKt;
import com.sumsub.sns.core.widget.autocompletePhone.ValidationListener;
import com.sumsub.sns.internal.core.presentation.form.b;
import com.sumsub.sns.internal.core.presentation.form.model.FieldError;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.sumsub.sns.internal.core.presentation.form.model.g;
import d10.l;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class h {

    public static final class a extends Lambda implements l<String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneKit f31073a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PhoneKit phoneKit) {
            super(1);
            this.f31073a = phoneKit;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r2 = r0.a(r2);
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String invoke(java.lang.String r2) {
            /*
                r1 = this;
                com.sumsub.sns.core.widget.PhoneKit r0 = r1.f31073a
                com.sumsub.sns.internal.core.data.model.remote.c r0 = r0.getMask()
                if (r0 == 0) goto L_0x000e
                java.lang.String r2 = r0.a(r2)
                if (r2 != 0) goto L_0x0010
            L_0x000e:
                java.lang.String r2 = ""
            L_0x0010:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.form.viewutils.h.a.invoke(java.lang.String):java.lang.String");
        }
    }

    public static final class b extends Lambda implements d10.a<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneKit f31074a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PhoneKit phoneKit) {
            super(0);
            this.f31074a = phoneKit;
        }

        /* renamed from: a */
        public final Boolean invoke() {
            return Boolean.valueOf(this.f31074a.isValid());
        }
    }

    public static final class c extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneKit f31075a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.core.presentation.form.c f31076b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FormItem.k f31077c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataPhoneFieldView f31078d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(PhoneKit phoneKit, com.sumsub.sns.core.presentation.form.c cVar, FormItem.k kVar, SNSApplicantDataPhoneFieldView sNSApplicantDataPhoneFieldView) {
            super(1);
            this.f31075a = phoneKit;
            this.f31076b = cVar;
            this.f31077c = kVar;
            this.f31078d = sNSApplicantDataPhoneFieldView;
        }

        public final void a(String str) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            com.sumsub.log.logger.a.d(aVar, "SNSApplicantDataPhoneFieldView", "textChangedCallback: " + str, (Throwable) null, 4, (Object) null);
            SNSCountryPicker.CountryItem country = this.f31075a.getCountry();
            if (country != null) {
                com.sumsub.sns.core.presentation.form.c cVar = this.f31076b;
                FormItem.k kVar = this.f31077c;
                if (cVar != null) {
                    cVar.b(com.sumsub.sns.core.presentation.form.model.a.a(kVar), country.getCode());
                }
            }
            com.sumsub.sns.internal.core.data.model.remote.c mask = this.f31075a.getMask();
            if (mask != null) {
                com.sumsub.sns.core.presentation.form.c cVar2 = this.f31076b;
                FormItem.k kVar2 = this.f31077c;
                if (cVar2 != null) {
                    cVar2.b(com.sumsub.sns.core.presentation.form.model.a.b(kVar2), mask.c());
                }
            }
            com.sumsub.sns.core.presentation.form.c cVar3 = this.f31076b;
            if (cVar3 != null) {
                FormItem.k kVar3 = this.f31077c;
                cVar3.b(kVar3, f.b(this.f31078d, kVar3));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class d extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneKit f31079a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f31080b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(PhoneKit phoneKit, Context context) {
            super(0);
            this.f31079a = phoneKit;
            this.f31080b = context;
        }

        public final void a() {
            this.f31079a.detach(this.f31080b);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class e implements ValidationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.core.presentation.form.c f31081a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.k f31082b;

        public e(com.sumsub.sns.core.presentation.form.c cVar, FormItem.k kVar) {
            this.f31081a = cVar;
            this.f31082b = kVar;
        }

        public void onValidate(boolean z11, boolean z12) {
            com.sumsub.sns.core.presentation.form.c cVar = this.f31081a;
            if (cVar != null) {
                cVar.a(this.f31082b, z11, z12);
            }
        }
    }

    public static final SNSApplicantDataBaseFieldView a(FormItem.k kVar, Context context, com.sumsub.sns.core.presentation.form.c cVar) {
        FormItem.k kVar2 = kVar;
        com.sumsub.sns.core.presentation.form.c cVar2 = cVar;
        SNSApplicantDataPhoneFieldView sNSApplicantDataPhoneFieldView = new SNSApplicantDataPhoneFieldView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        Set<Map.Entry<String, String>> entrySet = kVar.t().entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(entrySet, 10));
        for (Map.Entry entry : entrySet) {
            arrayList.add(new SNSCountryPicker.CountryItem((String) entry.getKey(), (String) entry.getValue()));
        }
        if (!arrayList.isEmpty()) {
            PhoneKit phoneKit$default = PhoneKitProviderKt.getPhoneKit$default(sNSApplicantDataPhoneFieldView.getPhoneInputLayout(), kVar.t(), kVar.v(), new e(cVar2, kVar2), (CharSequence) null, 16, (Object) null);
            sNSApplicantDataPhoneFieldView.setPhoneNumberPurifier(new a(phoneKit$default));
            if (!kVar.w()) {
                sNSApplicantDataPhoneFieldView.setPhoneNumberValidator(new b(phoneKit$default));
            }
            PhoneKit.attachToInput$default(phoneKit$default, sNSApplicantDataPhoneFieldView.getPhoneInputLayout(), arrayList, (SNSCountryPicker.CountryItem) null, (Bundle) null, 8, (Object) null);
            sNSApplicantDataPhoneFieldView.setTextChangedCallback(new c(phoneKit$default, cVar2, kVar2, sNSApplicantDataPhoneFieldView));
            sNSApplicantDataPhoneFieldView.setOnClear(new d(phoneKit$default, context));
        }
        return sNSApplicantDataPhoneFieldView;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView r9, com.sumsub.sns.internal.core.presentation.form.model.FormItem.k r10, com.sumsub.sns.core.presentation.form.e r11) {
        /*
            java.util.Map r0 = r10.t()
            java.util.Set r0 = r0.entrySet()
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.u(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L_0x0017:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0038
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r3 = new com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem
            java.lang.Object r4 = r2.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r3.<init>(r4, r2)
            r1.add(r3)
            goto L_0x0017
        L_0x0038:
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x003f
            return
        L_0x003f:
            java.util.Map r0 = r10.v()
            java.lang.String r2 = r11.a(r10)
            if (r2 != 0) goto L_0x004b
            java.lang.String r2 = ""
        L_0x004b:
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0053:
            boolean r3 = r0.hasNext()
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x0089
            java.lang.Object r3 = r0.next()
            r6 = r3
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r8 = 43
            r7.append(r8)
            java.lang.Object r6 = r6.getValue()
            com.sumsub.sns.internal.core.data.model.remote.c r6 = (com.sumsub.sns.internal.core.data.model.remote.c) r6
            java.lang.String r6 = r6.c()
            if (r6 != 0) goto L_0x007a
            java.lang.String r6 = "-1"
        L_0x007a:
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r7 = 2
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.M(r2, r6, r4, r7, r5)
            if (r6 == 0) goto L_0x0053
            goto L_0x008a
        L_0x0089:
            r3 = r5
        L_0x008a:
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.util.Iterator r0 = r1.iterator()
        L_0x0090:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x00b2
            java.lang.Object r6 = r0.next()
            r7 = r6
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r7 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r7
            java.lang.String r7 = r7.getCode()
            if (r3 == 0) goto L_0x00aa
            java.lang.Object r8 = r3.getKey()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00ab
        L_0x00aa:
            r8 = r5
        L_0x00ab:
            boolean r7 = kotlin.jvm.internal.x.b(r7, r8)
            if (r7 == 0) goto L_0x0090
            goto L_0x00b3
        L_0x00b2:
            r6 = r5
        L_0x00b3:
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r6 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r6
            if (r6 != 0) goto L_0x00de
            java.lang.String r0 = r10.u()
            if (r0 == 0) goto L_0x00dd
            java.util.Iterator r3 = r1.iterator()
        L_0x00c1:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00d9
            java.lang.Object r6 = r3.next()
            r7 = r6
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r7 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r7
            java.lang.String r7 = r7.getCode()
            boolean r7 = kotlin.jvm.internal.x.b(r7, r0)
            if (r7 == 0) goto L_0x00c1
            goto L_0x00da
        L_0x00d9:
            r6 = r5
        L_0x00da:
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r6 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r6
            goto L_0x00de
        L_0x00dd:
            r6 = r5
        L_0x00de:
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x00e5
            r4 = 1
        L_0x00e5:
            if (r4 == 0) goto L_0x0118
            com.sumsub.sns.internal.core.presentation.form.model.FormItem r10 = com.sumsub.sns.core.presentation.form.model.a.a((com.sumsub.sns.internal.core.presentation.form.model.FormItem.k) r10)
            java.lang.String r10 = r11.a(r10)
            if (r10 == 0) goto L_0x0114
            java.util.Iterator r11 = r1.iterator()
        L_0x00f5:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x010d
            java.lang.Object r0 = r11.next()
            r1 = r0
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r1 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r1
            java.lang.String r1 = r1.getCode()
            boolean r1 = kotlin.jvm.internal.x.b(r1, r10)
            if (r1 == 0) goto L_0x00f5
            r5 = r0
        L_0x010d:
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r5 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r5
            if (r5 == 0) goto L_0x0114
            r9.setCountry(r5)
        L_0x0114:
            r9.setValue(r2)
            goto L_0x011d
        L_0x0118:
            if (r6 == 0) goto L_0x011d
            r9.setCountry(r6)
        L_0x011d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.form.viewutils.h.a(com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView, com.sumsub.sns.internal.core.presentation.form.model.FormItem$k, com.sumsub.sns.core.presentation.form.e):void");
    }

    public static final String a(SNSApplicantDataPhoneFieldView sNSApplicantDataPhoneFieldView, b.c cVar, FormItem.k kVar) {
        FieldError a11 = g.a(kVar.d(), sNSApplicantDataPhoneFieldView.getPurePhoneNumber());
        if (a11 == null && !sNSApplicantDataPhoneFieldView.isValid()) {
            return com.sumsub.sns.core.presentation.form.model.a.a(FieldError.NOT_VALID, cVar);
        }
        if (a11 != null) {
            return com.sumsub.sns.core.presentation.form.model.a.a(a11, cVar);
        }
        return null;
    }

    public static final boolean a(SNSApplicantDataPhoneFieldView sNSApplicantDataPhoneFieldView, FormItem.k kVar) {
        FieldError a11 = g.a(kVar.d(), sNSApplicantDataPhoneFieldView.getPurePhoneNumber());
        boolean z11 = false;
        if (a11 == null) {
            a11 = FieldError.NOT_VALID;
            if (!(!sNSApplicantDataPhoneFieldView.isValid() && (StringsKt__StringsJVMKt.z(sNSApplicantDataPhoneFieldView.getPurePhoneNumber()) ^ true))) {
                a11 = null;
            }
        }
        if ((x.b(kVar.d().v(), Boolean.TRUE) && StringsKt__StringsJVMKt.z(sNSApplicantDataPhoneFieldView.getPurePhoneNumber())) || a11 != null) {
            z11 = true;
        }
        return !z11;
    }

    public static final String a(SNSApplicantDataPhoneFieldView sNSApplicantDataPhoneFieldView) {
        String value = sNSApplicantDataPhoneFieldView.getValue();
        StringBuilder sb2 = new StringBuilder();
        int length = value.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = value.charAt(i11);
            if (!CharsKt__CharJVMKt.c(charAt)) {
                sb2.append(charAt);
            }
        }
        return sb2.toString();
    }
}
