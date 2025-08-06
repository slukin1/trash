package com.sumsub.sns.internal.presentation.utils;

import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.geo.presentation.c;
import d10.l;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36440a = "yyyy-MM-dd";

    public static final class a extends Lambda implements l<String, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f36441a = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final CharSequence invoke(String str) {
            return str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r3 = r27.D();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.internal.domain.l a(java.lang.String r26, com.sumsub.sns.internal.core.data.model.e r27, com.sumsub.sns.internal.core.data.source.dynamic.b.c r28) {
        /*
            r0 = r26
            r1 = r28
            r2 = 0
            if (r27 == 0) goto L_0x0014
            java.util.Map r3 = r27.D()
            if (r3 == 0) goto L_0x0014
            java.lang.Object r3 = r3.get(r0)
            com.sumsub.sns.internal.core.data.model.remote.o r3 = (com.sumsub.sns.internal.core.data.model.remote.o) r3
            goto L_0x0015
        L_0x0014:
            r3 = r2
        L_0x0015:
            java.lang.String r4 = "sns_data_%s_%s"
            r5 = 1
            r6 = 0
            java.lang.String r7 = "tin"
            r8 = 2
            if (r27 == 0) goto L_0x0034
            java.util.Map r9 = r27.t()
            if (r9 == 0) goto L_0x0034
            java.lang.Object r0 = r9.get(r0)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x0034
            java.lang.Object r0 = r0.get(r7)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x004a
        L_0x0034:
            kotlin.jvm.internal.d0 r0 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r9 = "field"
            r0[r6] = r9
            r0[r5] = r7
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r8)
            java.lang.String r0 = java.lang.String.format(r4, r0)
            java.lang.String r0 = r1.a((java.lang.String) r0)
        L_0x004a:
            java.lang.String r9 = ""
            if (r3 == 0) goto L_0x005d
            java.util.List r10 = r3.c()
            if (r10 == 0) goto L_0x005d
            java.lang.Object r10 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r10)
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r10 = r9
        L_0x005e:
            if (r3 == 0) goto L_0x00a1
            java.util.List r11 = r3.c()
            if (r11 == 0) goto L_0x00a1
            com.sumsub.sns.internal.presentation.utils.d$a r17 = com.sumsub.sns.internal.presentation.utils.d.a.f36441a
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 30
            r19 = 0
            java.lang.String r12 = ", "
            java.lang.String r22 = kotlin.collections.CollectionsKt___CollectionsKt.k0(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            if (r22 == 0) goto L_0x00a1
            kotlin.jvm.internal.d0 r11 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r11 = new java.lang.Object[r8]
            java.lang.String r12 = "hint"
            r11[r6] = r12
            r11[r5] = r7
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r11, r8)
            java.lang.String r4 = java.lang.String.format(r4, r5)
            java.lang.String r20 = r1.a((java.lang.String) r4)
            if (r20 == 0) goto L_0x009d
            r23 = 0
            r24 = 4
            r25 = 0
            java.lang.String r21 = "{example}"
            java.lang.String r2 = kotlin.text.StringsKt__StringsJVMKt.G(r20, r21, r22, r23, r24, r25)
        L_0x009d:
            if (r2 != 0) goto L_0x00a0
            goto L_0x00a1
        L_0x00a0:
            r9 = r2
        L_0x00a1:
            com.sumsub.sns.internal.domain.l r1 = new com.sumsub.sns.internal.domain.l
            r1.<init>(r0, r3, r10, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.utils.d.a(java.lang.String, com.sumsub.sns.internal.core.data.model.e, com.sumsub.sns.internal.core.data.source.dynamic.b$c):com.sumsub.sns.internal.domain.l");
    }

    public static final String a(h.c cVar, String str, b.c cVar2) {
        if ((!StringsKt__StringsJVMKt.z(str)) || !x.b(cVar.k(), Boolean.TRUE)) {
            return null;
        }
        return cVar2.a(c.E);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        if ((r7.length() == 0) == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        if ((r0.length() > 0) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String a(com.sumsub.sns.internal.core.data.model.h.d r6, java.lang.String r7, com.sumsub.sns.internal.core.data.source.dynamic.b.c r8, java.lang.Boolean r9) {
        /*
            com.sumsub.sns.internal.core.data.model.p r0 = r6.k()
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0021
            java.util.Map r4 = r8.d()
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            java.lang.String r0 = com.sumsub.sns.internal.core.presentation.util.a.a((com.sumsub.sns.internal.core.data.model.p) r0, (java.util.Map<java.lang.String, java.lang.String>) r4, (java.lang.String) r7, (java.lang.Boolean) r5)
            if (r0 == 0) goto L_0x0021
            int r4 = r0.length()
            if (r4 <= 0) goto L_0x001d
            r4 = r3
            goto L_0x001e
        L_0x001d:
            r4 = r2
        L_0x001e:
            if (r4 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r0 = r1
        L_0x0022:
            if (r0 != 0) goto L_0x00e9
            boolean r0 = r6.A()
            if (r0 == 0) goto L_0x0035
            int r0 = r7.length()
            if (r0 != 0) goto L_0x0032
            r0 = r3
            goto L_0x0033
        L_0x0032:
            r0 = r2
        L_0x0033:
            if (r0 != 0) goto L_0x004b
        L_0x0035:
            boolean r0 = r6.A()
            if (r0 == 0) goto L_0x0053
            com.sumsub.sns.internal.core.data.model.FieldName r0 = r6.q()
            com.sumsub.sns.internal.core.data.model.FieldName r4 = com.sumsub.sns.internal.core.data.model.FieldName.phone
            if (r0 != r4) goto L_0x0053
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.x.b(r9, r0)
            if (r0 == 0) goto L_0x0053
        L_0x004b:
            java.lang.String r6 = "sns_data_error_fieldIsRequired"
            java.lang.String r1 = r8.a((java.lang.String) r6)
            goto L_0x00ea
        L_0x0053:
            boolean r0 = r6.y()
            java.lang.String r4 = "sns_data_error_fieldIsMalformed"
            if (r0 == 0) goto L_0x0097
            int r0 = r7.length()
            if (r0 <= 0) goto L_0x0063
            r0 = r3
            goto L_0x0064
        L_0x0063:
            r0 = r2
        L_0x0064:
            if (r0 == 0) goto L_0x0097
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0092 }
            java.lang.String r9 = "yyyy-MM-dd"
            java.util.Locale r0 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0092 }
            r6.<init>(r9, r0)     // Catch:{ Exception -> 0x0092 }
            java.util.Date r6 = r6.parse(r7)     // Catch:{ Exception -> 0x0092 }
            if (r6 == 0) goto L_0x00ea
            java.util.Calendar r7 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0092 }
            java.util.Date r7 = r7.getTime()     // Catch:{ Exception -> 0x0092 }
            int r7 = r6.compareTo(r7)     // Catch:{ Exception -> 0x0092 }
            if (r7 < 0) goto L_0x0086
            r2 = r3
        L_0x0086:
            if (r2 == 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r6 = r1
        L_0x008a:
            if (r6 == 0) goto L_0x00ea
            java.lang.String r6 = r8.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0092 }
            r1 = r6
            goto L_0x00ea
        L_0x0092:
            java.lang.String r1 = r8.a((java.lang.String) r4)
            goto L_0x00ea
        L_0x0097:
            com.sumsub.sns.internal.core.data.model.FieldName r0 = r6.q()
            com.sumsub.sns.internal.core.data.model.FieldName r5 = com.sumsub.sns.internal.core.data.model.FieldName.email
            if (r0 != r5) goto L_0x00cb
            int r0 = r7.length()
            if (r0 <= 0) goto L_0x00a7
            r0 = r3
            goto L_0x00a8
        L_0x00a7:
            r0 = r2
        L_0x00a8:
            if (r0 == 0) goto L_0x00cb
            java.util.regex.Pattern r6 = android.util.Patterns.EMAIL_ADDRESS
            java.util.regex.Matcher r6 = r6.matcher(r7)
            boolean r6 = r6.matches()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            boolean r7 = r6.booleanValue()
            r7 = r7 ^ r3
            if (r7 == 0) goto L_0x00c0
            goto L_0x00c1
        L_0x00c0:
            r6 = r1
        L_0x00c1:
            if (r6 == 0) goto L_0x00ea
            r6.booleanValue()
            java.lang.String r1 = r8.a((java.lang.String) r4)
            goto L_0x00ea
        L_0x00cb:
            com.sumsub.sns.internal.core.data.model.FieldName r6 = r6.q()
            com.sumsub.sns.internal.core.data.model.FieldName r0 = com.sumsub.sns.internal.core.data.model.FieldName.phone
            if (r6 != r0) goto L_0x00ea
            int r6 = r7.length()
            if (r6 <= 0) goto L_0x00da
            r2 = r3
        L_0x00da:
            if (r2 == 0) goto L_0x00ea
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            boolean r6 = kotlin.jvm.internal.x.b(r9, r6)
            if (r6 == 0) goto L_0x00ea
            java.lang.String r1 = r8.a((java.lang.String) r4)
            goto L_0x00ea
        L_0x00e9:
            r1 = r0
        L_0x00ea:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.utils.d.a(com.sumsub.sns.internal.core.data.model.h$d, java.lang.String, com.sumsub.sns.internal.core.data.source.dynamic.b$c, java.lang.Boolean):java.lang.String");
    }

    public static /* synthetic */ String a(h hVar, String str, b.c cVar, Boolean bool, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        return a(hVar, str, cVar, bool);
    }

    public static final String a(h hVar, String str, b.c cVar, Boolean bool) {
        if (hVar instanceof h.d) {
            return a((h.d) hVar, str, cVar, bool);
        }
        if (hVar instanceof h.c) {
            return a((h.c) hVar, str, cVar);
        }
        if (hVar instanceof h.e) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
