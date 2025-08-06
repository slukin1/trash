package com.sumsub.sns.internal.geo.presentation;

import com.sumsub.sns.internal.core.data.model.FieldName;
import com.sumsub.sns.internal.core.data.model.p;
import com.sumsub.sns.internal.core.data.source.applicant.remote.k;
import java.util.List;
import kotlin.jvm.internal.r;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f34725a = "geo+poa";

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34726a;

        static {
            int[] iArr = new int[FieldName.values().length];
            iArr[FieldName.country.ordinal()] = 1;
            iArr[FieldName.town.ordinal()] = 2;
            iArr[FieldName.street.ordinal()] = 3;
            iArr[FieldName.subStreet.ordinal()] = 4;
            iArr[FieldName.postCode.ordinal()] = 5;
            iArr[FieldName.flatNumber.ordinal()] = 6;
            iArr[FieldName.buildingNumber.ordinal()] = 7;
            iArr[FieldName.state.ordinal()] = 8;
            f34726a = iArr;
        }
    }

    /* JADX WARNING: type inference failed for: r20v0, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r4v11, types: [java.util.Collection, java.util.ArrayList] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.internal.core.presentation.form.model.FormItem a(com.sumsub.sns.internal.geo.presentation.a r23, com.sumsub.sns.internal.core.presentation.form.model.d r24, java.util.Map<java.lang.String, ? extends java.util.Map<java.lang.String, java.lang.String>> r25) {
        /*
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r2 = a(r23)
            com.sumsub.sns.internal.core.data.model.h$d r0 = r23.g()
            com.sumsub.sns.internal.core.data.model.FieldName r0 = r0.q()
            if (r0 != 0) goto L_0x0010
            r0 = -1
            goto L_0x0018
        L_0x0010:
            int[] r1 = com.sumsub.sns.internal.geo.presentation.b.a.f34726a
            int r0 = r0.ordinal()
            r0 = r1[r0]
        L_0x0018:
            r1 = 0
            r3 = 1
            r4 = 0
            switch(r0) {
                case 1: goto L_0x0138;
                case 2: goto L_0x0104;
                case 3: goto L_0x00e1;
                case 4: goto L_0x00e1;
                case 5: goto L_0x00e1;
                case 6: goto L_0x00e1;
                case 7: goto L_0x00e1;
                case 8: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0172
        L_0x0020:
            java.lang.CharSequence r0 = r23.j()
            if (r0 == 0) goto L_0x002c
            java.lang.String r0 = r0.toString()
            r8 = r0
            goto L_0x002d
        L_0x002c:
            r8 = r4
        L_0x002d:
            java.lang.CharSequence r0 = r23.j()
            if (r0 == 0) goto L_0x003c
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.z(r0)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r9 = r1
            goto L_0x003d
        L_0x003c:
            r9 = r3
        L_0x003d:
            java.lang.CharSequence r10 = r23.f()
            com.sumsub.sns.internal.core.data.model.h$d r0 = r23.g()
            com.sumsub.sns.internal.core.data.model.FieldName r0 = r0.q()
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = r0.getValue()
            r12 = r0
            goto L_0x0052
        L_0x0051:
            r12 = r4
        L_0x0052:
            java.lang.CharSequence r0 = r23.i()
            if (r0 == 0) goto L_0x005e
            java.lang.String r0 = r0.toString()
            r13 = r0
            goto L_0x005f
        L_0x005e:
            r13 = r4
        L_0x005f:
            java.lang.CharSequence r0 = r23.h()
            if (r0 == 0) goto L_0x006b
            java.lang.String r0 = r0.toString()
            r14 = r0
            goto L_0x006c
        L_0x006b:
            r14 = r4
        L_0x006c:
            r15 = 0
            com.sumsub.sns.internal.core.data.model.h$d r0 = r23.g()
            boolean r0 = r0.A()
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r0)
            r17 = 0
            r18 = 0
            r19 = 0
            com.sumsub.sns.internal.core.domain.e r0 = r24.c()
            java.lang.String r0 = r0.i()
            if (r0 != 0) goto L_0x008b
            java.lang.String r0 = ""
        L_0x008b:
            r1 = r25
            java.lang.Object r0 = r1.get(r0)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x00cb
            java.util.Set r0 = r0.entrySet()
            if (r0 == 0) goto L_0x00cb
            java.util.ArrayList r4 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IterablesKt.u(r0, r1)
            r4.<init>(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x00aa:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00cb
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            com.sumsub.sns.internal.core.data.source.applicant.remote.r r2 = new com.sumsub.sns.internal.core.data.source.applicant.remote.r
            java.lang.Object r3 = r1.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r2.<init>(r3, r1)
            r4.add(r2)
            goto L_0x00aa
        L_0x00cb:
            r20 = r4
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r6 = new com.sumsub.sns.internal.core.data.source.applicant.remote.k
            r21 = 232(0xe8, float:3.25E-43)
            r22 = 0
            r11 = r6
            r11.<init>((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.Boolean) r16, (java.lang.String) r17, (java.lang.String) r18, (java.lang.String) r19, (java.util.List) r20, (int) r21, (kotlin.jvm.internal.r) r22)
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$n r4 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$n
            java.lang.String r7 = "geo+poa"
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10)
            goto L_0x0172
        L_0x00e1:
            java.lang.CharSequence r0 = r23.j()
            if (r0 == 0) goto L_0x00ed
            java.lang.String r0 = r0.toString()
            r3 = r0
            goto L_0x00ee
        L_0x00ed:
            r3 = r4
        L_0x00ee:
            java.lang.CharSequence r5 = r23.f()
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$p r9 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$p
            r4 = 0
            r6 = 0
            r7 = 40
            r8 = 0
            java.lang.String r10 = "geo+poa"
            r0 = r9
            r1 = r2
            r2 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0101:
            r4 = r9
            goto L_0x0172
        L_0x0104:
            java.lang.CharSequence r0 = r23.j()
            if (r0 == 0) goto L_0x010f
            java.lang.String r0 = r0.toString()
            r4 = r0
        L_0x010f:
            java.lang.CharSequence r0 = r23.j()
            if (r0 == 0) goto L_0x011e
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.z(r0)
            if (r0 == 0) goto L_0x011c
            goto L_0x011e
        L_0x011c:
            r5 = r1
            goto L_0x011f
        L_0x011e:
            r5 = r3
        L_0x011f:
            java.lang.CharSequence r6 = r23.f()
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$p r9 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$p
            r7 = 0
            r8 = 32
            r10 = 0
            java.lang.String r3 = "geo+poa"
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0101
        L_0x0138:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$c r7 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$c
            com.sumsub.sns.internal.core.domain.e r0 = r24.c()
            java.util.Map r0 = r0.h()
            if (r0 != 0) goto L_0x0148
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x0148:
            r5 = r0
            java.lang.CharSequence r0 = r23.j()
            if (r0 == 0) goto L_0x0154
            java.lang.String r0 = r0.toString()
            r4 = r0
        L_0x0154:
            java.lang.CharSequence r0 = r23.j()
            if (r0 == 0) goto L_0x0163
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.z(r0)
            if (r0 == 0) goto L_0x0161
            goto L_0x0163
        L_0x0161:
            r6 = r1
            goto L_0x0164
        L_0x0163:
            r6 = r3
        L_0x0164:
            java.lang.CharSequence r8 = r23.f()
            java.lang.String r1 = "geo+poa"
            r0 = r7
            r3 = r5
            r5 = r6
            r6 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r4 = r7
        L_0x0172:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.presentation.b.a(com.sumsub.sns.internal.geo.presentation.a, com.sumsub.sns.internal.core.presentation.form.model.d, java.util.Map):com.sumsub.sns.internal.core.presentation.form.model.FormItem");
    }

    public static final k a(a aVar) {
        String b11 = aVar.g().b();
        CharSequence i11 = aVar.i();
        String obj = i11 != null ? i11.toString() : null;
        CharSequence h11 = aVar.h();
        return new k(b11, obj, h11 != null ? h11.toString() : null, (String) null, Boolean.valueOf(aVar.g().A()), p.f32667c, (String) null, (String) null, (List) null, 456, (r) null);
    }
}
