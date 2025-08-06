package com.sumsub.sns.internal.presentation.utils;

import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.data.model.FieldName;
import com.sumsub.sns.internal.core.data.model.e;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.source.applicant.remote.k;
import com.sumsub.sns.internal.core.data.source.applicant.remote.r;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.sumsub.sns.internal.domain.c;
import d10.l;
import d10.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.d0;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36426a = "appdata";

    /* renamed from: com.sumsub.sns.internal.presentation.utils.a$a  reason: collision with other inner class name */
    public static final class C0488a extends Lambda implements p<String, String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f36427a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0488a(b.c cVar) {
            super(2);
            this.f36427a = cVar;
        }

        /* renamed from: a */
        public final String invoke(String str, String str2) {
            b.c cVar = this.f36427a;
            d0 d0Var = d0.f56774a;
            return cVar.a(String.format(n0.j.a.f32240u, Arrays.copyOf(new Object[]{str, str2}, 2)));
        }
    }

    public static /* synthetic */ FormItem a(h.d dVar, String str, e eVar, c cVar, b.c cVar2, p pVar, CharSequence charSequence, Boolean bool, l lVar, int i11, Object obj) {
        int i12 = i11;
        return a(dVar, str, eVar, cVar, cVar2, (i12 & 16) != 0 ? null : pVar, (i12 & 32) != 0 ? null : charSequence, (i12 & 64) != 0 ? Boolean.FALSE : bool, (i12 & 128) != 0 ? null : lVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.internal.core.presentation.form.model.FormItem a(com.sumsub.sns.internal.core.data.model.h.d r30, java.lang.String r31, com.sumsub.sns.internal.core.data.model.e r32, com.sumsub.sns.internal.domain.c r33, com.sumsub.sns.internal.core.data.source.dynamic.b.c r34, d10.p<? super java.lang.String, ? super java.lang.String, java.lang.String> r35, java.lang.CharSequence r36, java.lang.Boolean r37, d10.l<? super com.sumsub.sns.internal.core.data.model.FieldName, java.lang.String> r38) {
        /*
            r6 = r30
            r7 = r31
            r1 = r34
            r0 = r37
            r2 = r38
            if (r35 != 0) goto L_0x0012
            com.sumsub.sns.internal.presentation.utils.a$a r3 = new com.sumsub.sns.internal.presentation.utils.a$a
            r3.<init>(r1)
            goto L_0x0014
        L_0x0012:
            r3 = r35
        L_0x0014:
            com.sumsub.sns.internal.core.data.model.g r4 = r33.g()
            if (r2 == 0) goto L_0x0027
            com.sumsub.sns.internal.core.data.model.FieldName r5 = com.sumsub.sns.internal.core.data.model.FieldName.country
            java.lang.Object r5 = r2.invoke(r5)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r8 = r5
            goto L_0x0028
        L_0x0027:
            r8 = r7
        L_0x0028:
            java.util.Map r12 = r33.h()
            com.sumsub.sns.internal.ff.a r5 = com.sumsub.sns.internal.ff.a.f34215a
            com.sumsub.sns.internal.ff.core.a r5 = r5.i()
            boolean r5 = r5.g()
            if (r5 != 0) goto L_0x003e
            java.util.Map r5 = com.sumsub.sns.internal.core.data.model.f.a((java.util.Map<java.lang.String, java.lang.String>) r12, (com.sumsub.sns.internal.core.data.model.g) r4)
            r9 = r5
            goto L_0x003f
        L_0x003e:
            r9 = r12
        L_0x003f:
            if (r7 == 0) goto L_0x0049
            boolean r5 = r9.containsKey(r7)
            if (r5 == 0) goto L_0x0049
            r5 = r7
            goto L_0x004a
        L_0x0049:
            r5 = 0
        L_0x004a:
            if (r2 == 0) goto L_0x0059
            com.sumsub.sns.internal.core.data.model.FieldName r11 = com.sumsub.sns.internal.core.data.model.FieldName.taxResidenceCountry
            java.lang.Object r11 = r2.invoke(r11)
            java.lang.String r11 = (java.lang.String) r11
            if (r11 != 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r5 = r11
            goto L_0x006b
        L_0x0059:
            if (r2 == 0) goto L_0x0064
            com.sumsub.sns.internal.core.data.model.FieldName r11 = com.sumsub.sns.internal.core.data.model.FieldName.country
            java.lang.Object r11 = r2.invoke(r11)
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x0065
        L_0x0064:
            r11 = 0
        L_0x0065:
            if (r11 != 0) goto L_0x0057
            if (r5 != 0) goto L_0x006b
            java.lang.String r5 = ""
        L_0x006b:
            r11 = r5
            com.sumsub.sns.internal.core.data.model.FieldName r5 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r13 = com.sumsub.sns.internal.core.data.model.FieldName.country
            if (r5 != r13) goto L_0x0077
            r17 = r8
            goto L_0x008a
        L_0x0077:
            com.sumsub.sns.internal.core.data.model.FieldName r5 = r30.q()
            if (r5 == 0) goto L_0x0088
            if (r2 == 0) goto L_0x0088
            java.lang.Object r5 = r2.invoke(r5)
            java.lang.String r5 = (java.lang.String) r5
            r17 = r5
            goto L_0x008a
        L_0x0088:
            r17 = 0
        L_0x008a:
            java.util.Map r5 = r33.i()
            java.util.Map r14 = r33.j()
            r15 = r32
            com.sumsub.sns.internal.domain.l r15 = com.sumsub.sns.internal.presentation.utils.d.a((java.lang.String) r11, (com.sumsub.sns.internal.core.data.model.e) r15, (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r1)
            com.sumsub.sns.internal.core.data.model.FieldName r10 = r30.q()
            if (r10 != r13) goto L_0x00c8
            r2 = 0
            r4 = 2
            r5 = 0
            r0 = r30
            r1 = r34
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r15 = a(r0, r1, r2, r3, r4, r5)
            boolean r0 = r9.containsKey(r8)
            if (r0 == 0) goto L_0x00b2
            r17 = r8
            goto L_0x00b4
        L_0x00b2:
            r17 = 0
        L_0x00b4:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$c r0 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$c
            r18 = 0
            r20 = 16
            r21 = 0
            java.lang.String r14 = "appdata"
            r13 = r0
            r16 = r9
            r19 = r36
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21)
            goto L_0x0462
        L_0x00c8:
            com.sumsub.sns.internal.core.data.model.FieldName r8 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r10 = com.sumsub.sns.internal.core.data.model.FieldName.taxResidenceCountry
            if (r8 != r10) goto L_0x00fa
            r2 = 0
            r4 = 2
            r5 = 0
            r0 = r30
            r1 = r34
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r15 = a(r0, r1, r2, r3, r4, r5)
            boolean r0 = r9.containsKey(r11)
            if (r0 == 0) goto L_0x00e4
            r17 = r11
            goto L_0x00e6
        L_0x00e4:
            r17 = 0
        L_0x00e6:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$c r0 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$c
            r18 = 0
            r20 = 16
            r21 = 0
            java.lang.String r14 = "appdata"
            r13 = r0
            r16 = r9
            r19 = r36
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21)
            goto L_0x0462
        L_0x00fa:
            com.sumsub.sns.internal.core.data.model.FieldName r8 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r9 = com.sumsub.sns.internal.core.data.model.FieldName.gender
            if (r8 != r9) goto L_0x0125
            java.util.List r2 = a(r14)
            r4 = 0
            r5 = 8
            r7 = 0
            r0 = r30
            r1 = r34
            r6 = r7
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r15 = a(r0, r1, r2, r3, r4, r5, r6)
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$n r0 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$n
            r18 = 0
            r20 = 8
            r21 = 0
            java.lang.String r16 = "appdata"
            r14 = r0
            r19 = r36
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            goto L_0x0462
        L_0x0125:
            com.sumsub.sns.internal.core.data.model.FieldName r8 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r9 = com.sumsub.sns.internal.core.data.model.FieldName.email
            if (r8 != r9) goto L_0x0147
            java.lang.String r0 = "email"
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r15 = a(r6, r1, r0, r3)
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$p r0 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$p
            r18 = 0
            r20 = 0
            r21 = 40
            r22 = 0
            java.lang.String r16 = "appdata"
            r14 = r0
            r19 = r36
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            goto L_0x0462
        L_0x0147:
            com.sumsub.sns.internal.core.data.model.FieldName r8 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r9 = com.sumsub.sns.internal.core.data.model.FieldName.phone
            if (r8 != r9) goto L_0x017d
            r2 = 0
            r4 = 2
            r5 = 0
            r0 = r30
            r1 = r34
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r2 = a(r0, r1, r2, r3, r4, r5)
            com.sumsub.sns.internal.core.data.model.e r0 = r33.f()
            if (r0 == 0) goto L_0x0166
            java.util.Map r0 = r0.B()
            if (r0 != 0) goto L_0x016a
        L_0x0166:
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x016a:
            r4 = r0
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$k r9 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$k
            r6 = 1
            java.lang.String r1 = "appdata"
            r0 = r9
            r3 = r12
            r5 = r31
            r7 = r17
            r8 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0462
        L_0x017d:
            boolean r7 = r30.y()
            if (r7 == 0) goto L_0x01a5
            r2 = 0
            r4 = 2
            r5 = 0
            r0 = r30
            r1 = r34
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r0 = a(r0, r1, r2, r3, r4, r5)
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$d r1 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$d
            r2 = 1
            java.lang.String r3 = "appdata"
            r30 = r1
            r31 = r0
            r32 = r3
            r33 = r2
            r34 = r17
            r35 = r36
            r30.<init>(r31, r32, r33, r34, r35)
            r0 = r1
            goto L_0x0462
        L_0x01a5:
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.nationality
            if (r7 != r8) goto L_0x01cd
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$c r7 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$c
            r2 = 0
            r4 = 2
            r5 = 0
            r0 = r30
            r1 = r34
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r11 = a(r0, r1, r2, r3, r4, r5)
            r14 = 0
            r16 = 16
            r0 = 0
            java.lang.String r10 = "appdata"
            r9 = r7
            r13 = r17
            r15 = r36
            r17 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
        L_0x01ca:
            r0 = r7
            goto L_0x0462
        L_0x01cd:
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.firstName
            java.lang.String r9 = "android_tetxt_cap_words"
            if (r7 == r8) goto L_0x044c
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.lastName
            if (r7 == r8) goto L_0x044c
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.middleName
            if (r7 != r8) goto L_0x01e9
            goto L_0x044c
        L_0x01e9:
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.street
            if (r7 == r8) goto L_0x0435
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.subStreet
            if (r7 == r8) goto L_0x0435
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.town
            if (r7 == r8) goto L_0x0435
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.placeOfBirth
            if (r7 == r8) goto L_0x0435
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.postCode
            if (r7 != r8) goto L_0x0213
            goto L_0x0435
        L_0x0213:
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.legalName
            if (r7 != r8) goto L_0x0233
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r15 = a(r6, r1, r9, r3)
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$p r0 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$p
            r18 = 0
            r20 = 0
            r21 = 40
            r22 = 0
            java.lang.String r16 = "appdata"
            r14 = r0
            r19 = r36
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            goto L_0x0462
        L_0x0233:
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.tin
            r9 = 0
            r10 = 1
            if (r7 != r8) goto L_0x02c6
            com.sumsub.sns.internal.core.data.model.FieldName r0 = r30.q()
            if (r0 == 0) goto L_0x024a
            java.lang.String r0 = r0.getValue()
            r19 = r0
            goto L_0x024c
        L_0x024a:
            r19 = 0
        L_0x024c:
            java.lang.CharSequence r0 = r15.g()
            if (r0 == 0) goto L_0x0259
            java.lang.String r0 = r0.toString()
            r20 = r0
            goto L_0x025b
        L_0x0259:
            r20 = 0
        L_0x025b:
            java.lang.CharSequence r0 = r15.e()
            java.lang.String r21 = java.lang.String.valueOf(r0)
            java.lang.CharSequence r0 = r15.f()
            java.lang.String r25 = java.lang.String.valueOf(r0)
            boolean r0 = r30.A()
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r15 = new com.sumsub.sns.internal.core.data.source.applicant.remote.k
            java.lang.Boolean r23 = java.lang.Boolean.valueOf(r0)
            r22 = 0
            r26 = 0
            r27 = 0
            r28 = 392(0x188, float:5.5E-43)
            r29 = 0
            java.lang.String r24 = "android_tetxt_cap_words"
            r18 = r15
            r18.<init>((java.lang.String) r19, (java.lang.String) r20, (java.lang.String) r21, (java.lang.String) r22, (java.lang.Boolean) r23, (java.lang.String) r24, (java.lang.String) r25, (java.lang.String) r26, (java.util.List) r27, (int) r28, (kotlin.jvm.internal.r) r29)
            java.util.List r0 = r30.o()
            if (r0 == 0) goto L_0x0295
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r10
            if (r0 != r10) goto L_0x0295
            r0 = r10
            goto L_0x0296
        L_0x0295:
            r0 = r9
        L_0x0296:
            if (r0 == 0) goto L_0x029f
            java.util.List r10 = r30.o()
        L_0x029c:
            r20 = r10
            goto L_0x02b4
        L_0x029f:
            java.lang.String r0 = r30.m()
            if (r0 == 0) goto L_0x02b2
            java.lang.String[] r0 = new java.lang.String[r10]
            java.lang.String r1 = r30.m()
            r0[r9] = r1
            java.util.ArrayList r10 = kotlin.collections.CollectionsKt__CollectionsKt.g(r0)
            goto L_0x029c
        L_0x02b2:
            r20 = 0
        L_0x02b4:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$p r0 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$p
            r18 = 0
            r21 = 8
            r22 = 0
            java.lang.String r16 = "appdata"
            r14 = r0
            r19 = r36
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            goto L_0x0462
        L_0x02c6:
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.countryOfBirth
            if (r7 != r8) goto L_0x02ed
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$c r7 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$c
            r2 = 0
            r4 = 2
            r5 = 0
            r0 = r30
            r1 = r34
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r11 = a(r0, r1, r2, r3, r4, r5)
            r14 = 0
            r16 = 16
            r0 = 0
            java.lang.String r10 = "appdata"
            r9 = r7
            r13 = r17
            r15 = r36
            r17 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            goto L_0x01ca
        L_0x02ed:
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r11 = com.sumsub.sns.internal.core.data.model.FieldName.stateOfBirth
            if (r7 != r11) goto L_0x036c
            if (r2 == 0) goto L_0x02ff
            java.lang.Object r2 = r2.invoke(r8)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0307
        L_0x02ff:
            if (r4 == 0) goto L_0x0306
            java.lang.String r2 = com.sumsub.sns.internal.presentation.utils.e.a(r4, r8)
            goto L_0x0307
        L_0x0306:
            r2 = 0
        L_0x0307:
            java.lang.Object r2 = r5.get(r2)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 != 0) goto L_0x0313
            java.util.Map r2 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x0313:
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L_0x0338
            r2 = 0
            r4 = 2
            r5 = 0
            r0 = r30
            r1 = r34
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r15 = a(r0, r1, r2, r3, r4, r5)
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$p r0 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$p
            r18 = 0
            r20 = 0
            r21 = 40
            r22 = 0
            java.lang.String r16 = "appdata"
            r14 = r0
            r19 = r36
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            goto L_0x0462
        L_0x0338:
            java.util.List r4 = a(r2)
            boolean r5 = r30.A()
            if (r5 != 0) goto L_0x0351
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.x.b(r0, r5)
            if (r0 == 0) goto L_0x0352
            boolean r0 = r2.isEmpty()
            r0 = r0 ^ r10
            if (r0 == 0) goto L_0x0352
        L_0x0351:
            r9 = r10
        L_0x0352:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r9)
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r15 = a(r6, r1, r4, r3, r0)
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$n r0 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$n
            r18 = 0
            r20 = 8
            r21 = 0
            java.lang.String r16 = "appdata"
            r14 = r0
            r19 = r36
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            goto L_0x0462
        L_0x036c:
            com.sumsub.sns.internal.core.data.model.FieldName r7 = r30.q()
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.state
            if (r7 != r8) goto L_0x03eb
            if (r2 == 0) goto L_0x037e
            java.lang.Object r2 = r2.invoke(r13)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0386
        L_0x037e:
            if (r4 == 0) goto L_0x0385
            java.lang.String r2 = com.sumsub.sns.internal.presentation.utils.e.a(r4, r13)
            goto L_0x0386
        L_0x0385:
            r2 = 0
        L_0x0386:
            java.lang.Object r2 = r5.get(r2)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 != 0) goto L_0x0392
            java.util.Map r2 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x0392:
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L_0x03b7
            r2 = 0
            r4 = 2
            r5 = 0
            r0 = r30
            r1 = r34
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r15 = a(r0, r1, r2, r3, r4, r5)
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$p r0 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$p
            r18 = 0
            r20 = 0
            r21 = 40
            r22 = 0
            java.lang.String r16 = "appdata"
            r14 = r0
            r19 = r36
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            goto L_0x0462
        L_0x03b7:
            java.util.List r4 = a(r2)
            boolean r5 = r30.A()
            if (r5 != 0) goto L_0x03d0
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.x.b(r0, r5)
            if (r0 == 0) goto L_0x03d1
            boolean r0 = r2.isEmpty()
            r0 = r0 ^ r10
            if (r0 == 0) goto L_0x03d1
        L_0x03d0:
            r9 = r10
        L_0x03d1:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r9)
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r15 = a(r6, r1, r4, r3, r0)
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$n r0 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$n
            r18 = 0
            r20 = 8
            r21 = 0
            java.lang.String r16 = "appdata"
            r14 = r0
            r19 = r36
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            goto L_0x0462
        L_0x03eb:
            r2 = 0
            r4 = 2
            r5 = 0
            r0 = r30
            r1 = r34
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r15 = a(r0, r1, r2, r3, r4, r5)
            java.util.List r0 = r30.o()
            if (r0 == 0) goto L_0x0405
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r10
            if (r0 != r10) goto L_0x0405
            r0 = r10
            goto L_0x0406
        L_0x0405:
            r0 = r9
        L_0x0406:
            if (r0 == 0) goto L_0x040f
            java.util.List r10 = r30.o()
        L_0x040c:
            r20 = r10
            goto L_0x0424
        L_0x040f:
            java.lang.String r0 = r30.m()
            if (r0 == 0) goto L_0x0422
            java.lang.String[] r0 = new java.lang.String[r10]
            java.lang.String r1 = r30.m()
            r0[r9] = r1
            java.util.ArrayList r10 = kotlin.collections.CollectionsKt__CollectionsKt.g(r0)
            goto L_0x040c
        L_0x0422:
            r20 = 0
        L_0x0424:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$p r0 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$p
            r18 = 0
            r21 = 8
            r22 = 0
            java.lang.String r16 = "appdata"
            r14 = r0
            r19 = r36
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            goto L_0x0462
        L_0x0435:
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r15 = a(r6, r1, r9, r3)
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$p r0 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$p
            r18 = 0
            r20 = 0
            r21 = 40
            r22 = 0
            java.lang.String r16 = "appdata"
            r14 = r0
            r19 = r36
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            goto L_0x0462
        L_0x044c:
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r15 = a(r6, r1, r9, r3)
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$p r0 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$p
            r18 = 0
            r20 = 0
            r21 = 40
            r22 = 0
            java.lang.String r16 = "appdata"
            r14 = r0
            r19 = r36
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
        L_0x0462:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.utils.a.a(com.sumsub.sns.internal.core.data.model.h$d, java.lang.String, com.sumsub.sns.internal.core.data.model.e, com.sumsub.sns.internal.domain.c, com.sumsub.sns.internal.core.data.source.dynamic.b$c, d10.p, java.lang.CharSequence, java.lang.Boolean, d10.l):com.sumsub.sns.internal.core.presentation.form.model.FormItem");
    }

    public static /* synthetic */ k a(h.d dVar, b.c cVar, List list, p pVar, Boolean bool, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            bool = null;
        }
        return a(dVar, cVar, list, pVar, bool);
    }

    public static final k a(h.d dVar, b.c cVar, List<r> list, p<? super String, ? super String, String> pVar, Boolean bool) {
        p<? super String, ? super String, String> pVar2 = pVar;
        FieldName q11 = dVar.q();
        String str = null;
        String value = q11 != null ? q11.getValue() : null;
        FieldName q12 = dVar.q();
        String invoke = pVar2.invoke(n0.j.a.f32241v, q12 != null ? q12.getValue() : null);
        FieldName q13 = dVar.q();
        if (q13 != null) {
            str = q13.getValue();
        }
        return new k(value, invoke, pVar2.invoke("hint", str), (String) null, Boolean.valueOf(bool != null ? bool.booleanValue() : dVar.A()), (String) null, a(dVar, cVar), (String) null, (List) list, (int) HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE, (kotlin.jvm.internal.r) null);
    }

    public static /* synthetic */ k a(h.d dVar, b.c cVar, String str, p pVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        return a(dVar, cVar, str, pVar);
    }

    public static final k a(h.d dVar, b.c cVar, String str, p<? super String, ? super String, String> pVar) {
        String b11 = dVar.b();
        FieldName q11 = dVar.q();
        String str2 = null;
        String invoke = pVar.invoke(n0.j.a.f32241v, q11 != null ? q11.getValue() : null);
        FieldName q12 = dVar.q();
        if (q12 != null) {
            str2 = q12.getValue();
        }
        return new k(b11, invoke, pVar.invoke("hint", str2), (String) null, Boolean.valueOf(dVar.A()), str, a(dVar, cVar), (String) null, (List) null, 392, (kotlin.jvm.internal.r) null);
    }

    public static final String a(h.d dVar, b.c cVar) {
        String s11 = dVar.s();
        if (s11 != null) {
            return s11;
        }
        if (dVar.A()) {
            return cVar.a("sns_data_placeholder_required");
        }
        return cVar.a("sns_data_placeholder_optional");
    }

    public static final List<r> a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(new r((String) next.getKey(), (String) next.getValue()));
        }
        return arrayList;
    }
}
