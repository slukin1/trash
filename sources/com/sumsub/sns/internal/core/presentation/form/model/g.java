package com.sumsub.sns.internal.core.presentation.form.model;

import com.sumsub.sns.internal.core.data.model.FieldType;
import com.sumsub.sns.internal.core.data.model.p;
import com.sumsub.sns.internal.core.data.source.applicant.remote.k;
import com.sumsub.sns.internal.core.presentation.util.a;

public final class g {
    public static final p a(k kVar) {
        return p.Companion.a(kVar.n());
    }

    public static final int b(k kVar) {
        Integer a11;
        p a12 = p.Companion.a(kVar.n());
        if (a12 == null || (a11 = a.a(a12)) == null) {
            return 1;
        }
        return a11.intValue();
    }

    public static final FieldType c(k kVar) {
        return FieldType.Companion.a(kVar.z());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        if ((r4 == null || kotlin.text.StringsKt__StringsJVMKt.z(r4)) != false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.internal.core.presentation.form.model.FieldError a(com.sumsub.sns.internal.core.data.source.applicant.remote.k r3, java.lang.String r4) {
        /*
            java.lang.Boolean r0 = r3.v()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.x.b(r0, r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001d
            if (r4 == 0) goto L_0x0019
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.z(r4)
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = r2
            goto L_0x001a
        L_0x0019:
            r0 = r1
        L_0x001a:
            if (r0 == 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r1 = r2
        L_0x001e:
            if (r1 == 0) goto L_0x0023
            com.sumsub.sns.internal.core.presentation.form.model.FieldError r3 = com.sumsub.sns.internal.core.presentation.form.model.FieldError.REQUIRED
            goto L_0x0031
        L_0x0023:
            com.sumsub.sns.internal.core.data.model.p r3 = a(r3)
            boolean r3 = com.sumsub.sns.internal.core.presentation.util.a.a((com.sumsub.sns.internal.core.data.model.p) r3, (java.lang.String) r4)
            if (r3 != 0) goto L_0x0030
            com.sumsub.sns.internal.core.presentation.form.model.FieldError r3 = com.sumsub.sns.internal.core.presentation.form.model.FieldError.NOT_VALID
            goto L_0x0031
        L_0x0030:
            r3 = 0
        L_0x0031:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.form.model.g.a(com.sumsub.sns.internal.core.data.source.applicant.remote.k, java.lang.String):com.sumsub.sns.internal.core.presentation.form.model.FieldError");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.internal.core.presentation.form.model.FieldError a(com.sumsub.sns.internal.core.data.source.applicant.remote.k r2, java.lang.String r3, java.util.List<com.sumsub.sns.internal.core.data.source.applicant.remote.r> r4) {
        /*
            java.lang.Boolean r2 = r2.v()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r2 = kotlin.jvm.internal.x.b(r2, r0)
            r0 = 0
            r1 = 1
            if (r2 == 0) goto L_0x001e
            if (r3 == 0) goto L_0x0019
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.z(r3)
            if (r2 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r2 = r0
            goto L_0x001a
        L_0x0019:
            r2 = r1
        L_0x001a:
            if (r2 == 0) goto L_0x001e
            r2 = r1
            goto L_0x001f
        L_0x001e:
            r2 = r0
        L_0x001f:
            if (r2 == 0) goto L_0x0024
            com.sumsub.sns.internal.core.presentation.form.model.FieldError r2 = com.sumsub.sns.internal.core.presentation.form.model.FieldError.REQUIRED
            goto L_0x0062
        L_0x0024:
            boolean r2 = r4.isEmpty()
            r2 = r2 ^ r1
            if (r2 == 0) goto L_0x0061
            if (r3 == 0) goto L_0x0036
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.z(r3)
            if (r2 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r2 = r0
            goto L_0x0037
        L_0x0036:
            r2 = r1
        L_0x0037:
            if (r2 != 0) goto L_0x0061
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto L_0x0040
            goto L_0x005b
        L_0x0040:
            java.util.Iterator r2 = r4.iterator()
        L_0x0044:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x005b
            java.lang.Object r4 = r2.next()
            com.sumsub.sns.internal.core.data.source.applicant.remote.r r4 = (com.sumsub.sns.internal.core.data.source.applicant.remote.r) r4
            java.lang.String r4 = r4.e()
            boolean r4 = kotlin.jvm.internal.x.b(r4, r3)
            if (r4 == 0) goto L_0x0044
            goto L_0x005c
        L_0x005b:
            r0 = r1
        L_0x005c:
            if (r0 == 0) goto L_0x0061
            com.sumsub.sns.internal.core.presentation.form.model.FieldError r2 = com.sumsub.sns.internal.core.presentation.form.model.FieldError.NOT_VALID
            goto L_0x0062
        L_0x0061:
            r2 = 0
        L_0x0062:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.form.model.g.a(com.sumsub.sns.internal.core.data.source.applicant.remote.k, java.lang.String, java.util.List):com.sumsub.sns.internal.core.presentation.form.model.FieldError");
    }
}
