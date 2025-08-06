package com.sumsub.sns.internal.core.presentation.form.model;

public final class c {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x002e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<com.sumsub.sns.internal.core.presentation.form.model.a> a(java.lang.String r13) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 2
            r3 = 0
            r4 = 0
            if (r13 == 0) goto L_0x0027
            java.lang.String[] r6 = new java.lang.String[r2]
            com.sumsub.sns.internal.core.presentation.form.model.Logic r5 = com.sumsub.sns.internal.core.presentation.form.model.Logic.OR
            java.lang.String r5 = r5.getRawValue()
            r6[r3] = r5
            com.sumsub.sns.internal.core.presentation.form.model.Logic r5 = com.sumsub.sns.internal.core.presentation.form.model.Logic.AND
            java.lang.String r5 = r5.getRawValue()
            r6[r1] = r5
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            r5 = r13
            java.util.List r13 = kotlin.text.StringsKt__StringsKt.L0(r5, r6, r7, r8, r9, r10)
            goto L_0x0028
        L_0x0027:
            r13 = r4
        L_0x0028:
            if (r13 == 0) goto L_0x00f2
            java.util.Iterator r13 = r13.iterator()
        L_0x002e:
            boolean r5 = r13.hasNext()
            if (r5 == 0) goto L_0x00f2
            java.lang.Object r5 = r13.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "!="
            boolean r7 = kotlin.text.StringsKt__StringsKt.R(r5, r6, r3, r2, r4)
            java.lang.String r12 = "."
            if (r7 == 0) goto L_0x0083
            java.lang.String[] r7 = new java.lang.String[]{r6}
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r5
            java.util.List r6 = kotlin.text.StringsKt__StringsKt.L0(r6, r7, r8, r9, r10, r11)
            java.lang.Object r7 = r6.get(r3)
            java.lang.String r7 = (java.lang.String) r7
            com.sumsub.sns.internal.core.data.source.applicant.remote.l r7 = com.sumsub.sns.internal.core.data.source.applicant.remote.m.a(r7, r12)
            if (r7 == 0) goto L_0x0081
            com.sumsub.sns.internal.core.presentation.form.model.a$c r8 = new com.sumsub.sns.internal.core.presentation.form.model.a$c
            java.lang.String r9 = r7.c()
            java.lang.CharSequence r9 = kotlin.text.StringsKt__StringsKt.i1(r9)
            java.lang.String r9 = r9.toString()
            java.lang.String r7 = r7.d()
            java.lang.CharSequence r7 = kotlin.text.StringsKt__StringsKt.i1(r7)
            java.lang.String r7 = r7.toString()
            java.lang.Object r6 = r6.get(r1)
            java.lang.String r6 = (java.lang.String) r6
            r8.<init>(r5, r9, r7, r6)
            goto L_0x00eb
        L_0x0081:
            r8 = r4
            goto L_0x00eb
        L_0x0083:
            java.lang.String r6 = "="
            boolean r7 = kotlin.text.StringsKt__StringsKt.R(r5, r6, r3, r2, r4)
            if (r7 == 0) goto L_0x00c8
            java.lang.String[] r7 = new java.lang.String[]{r6}
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r5
            java.util.List r6 = kotlin.text.StringsKt__StringsKt.L0(r6, r7, r8, r9, r10, r11)
            java.lang.Object r7 = r6.get(r3)
            java.lang.String r7 = (java.lang.String) r7
            com.sumsub.sns.internal.core.data.source.applicant.remote.l r7 = com.sumsub.sns.internal.core.data.source.applicant.remote.m.a(r7, r12)
            if (r7 == 0) goto L_0x0081
            com.sumsub.sns.internal.core.presentation.form.model.a$a r8 = new com.sumsub.sns.internal.core.presentation.form.model.a$a
            java.lang.String r9 = r7.c()
            java.lang.CharSequence r9 = kotlin.text.StringsKt__StringsKt.i1(r9)
            java.lang.String r9 = r9.toString()
            java.lang.String r7 = r7.d()
            java.lang.CharSequence r7 = kotlin.text.StringsKt__StringsKt.i1(r7)
            java.lang.String r7 = r7.toString()
            java.lang.Object r6 = r6.get(r1)
            java.lang.String r6 = (java.lang.String) r6
            r8.<init>(r5, r9, r7, r6)
            goto L_0x00eb
        L_0x00c8:
            com.sumsub.sns.internal.core.data.source.applicant.remote.l r6 = com.sumsub.sns.internal.core.data.source.applicant.remote.m.a(r5, r12)
            if (r6 == 0) goto L_0x0081
            com.sumsub.sns.internal.core.presentation.form.model.a$b r8 = new com.sumsub.sns.internal.core.presentation.form.model.a$b
            java.lang.String r7 = r6.c()
            java.lang.CharSequence r7 = kotlin.text.StringsKt__StringsKt.i1(r7)
            java.lang.String r7 = r7.toString()
            java.lang.String r6 = r6.d()
            java.lang.CharSequence r6 = kotlin.text.StringsKt__StringsKt.i1(r6)
            java.lang.String r6 = r6.toString()
            r8.<init>(r5, r7, r6)
        L_0x00eb:
            if (r8 == 0) goto L_0x002e
            r0.add(r8)
            goto L_0x002e
        L_0x00f2:
            java.util.List r13 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.form.model.c.a(java.lang.String):java.util.List");
    }
}
