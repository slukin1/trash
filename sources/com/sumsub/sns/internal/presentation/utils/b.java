package com.sumsub.sns.internal.presentation.utils;

import com.sumsub.sns.internal.core.common.a1;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.domain.c;
import d10.l;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.g;

public final class b {

    public static final class a extends Lambda implements l<h, com.sumsub.sns.internal.domain.b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l<String, String> f36428a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f36429b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f36430c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.c f36431d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f36432e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f36433f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f36434g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f36435h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f36436i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f36437j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Boolean f36438k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(l<? super String, String> lVar, a1 a1Var, String str, b.c cVar, h hVar, boolean z11, c cVar2, String str2, h hVar2, String str3, Boolean bool) {
            super(1);
            this.f36428a = lVar;
            this.f36429b = a1Var;
            this.f36430c = str;
            this.f36431d = cVar;
            this.f36432e = hVar;
            this.f36433f = z11;
            this.f36434g = cVar2;
            this.f36435h = str2;
            this.f36436i = hVar2;
            this.f36437j = str3;
            this.f36438k = bool;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
            if ((r5.invoke(r6 != null ? r6.getValue() : null).length() > 0) != false) goto L_0x0037;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b5, code lost:
            if (((r6 == null || (r6 = r6.f()) == null || (r6 = r6.u()) == null || (r6 = r6.get(r8.f36435h)) == null) ? false : !r6.isEmpty()) != false) goto L_0x00b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x0132, code lost:
            if (((r5 == null || (r5 = r5.f()) == null || (r5 = r5.u()) == null || (r5 = r5.get(r8.f36437j)) == null) ? false : !r5.isEmpty()) != false) goto L_0x0134;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.sumsub.sns.internal.domain.b invoke(com.sumsub.sns.internal.core.data.model.h r9) {
            /*
                r8 = this;
                boolean r0 = r9 instanceof com.sumsub.sns.internal.core.data.model.h.d
                r1 = 0
                r2 = 0
                r3 = 1
                if (r0 == 0) goto L_0x0064
                r4 = r9
                com.sumsub.sns.internal.core.data.model.h$d r4 = (com.sumsub.sns.internal.core.data.model.h.d) r4
                com.sumsub.sns.internal.core.data.model.FieldName r5 = r4.q()
                com.sumsub.sns.internal.core.data.model.FieldName r6 = com.sumsub.sns.internal.core.data.model.FieldName.tin
                if (r5 != r6) goto L_0x0064
                boolean r5 = r4.A()
                if (r5 != 0) goto L_0x0037
                d10.l<java.lang.String, java.lang.String> r5 = r8.f36428a
                com.sumsub.sns.internal.core.data.model.FieldName r6 = r4.q()
                if (r6 == 0) goto L_0x0025
                java.lang.String r6 = r6.getValue()
                goto L_0x0026
            L_0x0025:
                r6 = r2
            L_0x0026:
                java.lang.Object r5 = r5.invoke(r6)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                int r5 = r5.length()
                if (r5 <= 0) goto L_0x0034
                r5 = r3
                goto L_0x0035
            L_0x0034:
                r5 = r1
            L_0x0035:
                if (r5 == 0) goto L_0x0064
            L_0x0037:
                com.sumsub.sns.internal.core.common.a1 r5 = r8.f36429b
                d10.l<java.lang.String, java.lang.String> r6 = r8.f36428a
                com.sumsub.sns.internal.core.data.model.FieldName r4 = r4.q()
                if (r4 == 0) goto L_0x0046
                java.lang.String r4 = r4.getValue()
                goto L_0x0047
            L_0x0046:
                r4 = r2
            L_0x0047:
                java.lang.Object r4 = r6.invoke(r4)
                java.lang.String r4 = (java.lang.String) r4
                java.lang.String r6 = r8.f36430c
                boolean r4 = r5.a(r4, r6)
                if (r4 != 0) goto L_0x0064
                com.sumsub.sns.internal.domain.b r2 = new com.sumsub.sns.internal.domain.b
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r0 = r8.f36431d
                java.lang.String r1 = "sns_data_error_fieldIsMalformed"
                java.lang.String r0 = r0.a((java.lang.String) r1)
                r2.<init>(r9, r0)
                goto L_0x0178
            L_0x0064:
                java.lang.String r4 = "sns_data_error_fieldIsRequired"
                if (r0 == 0) goto L_0x00e3
                r5 = r9
                com.sumsub.sns.internal.core.data.model.h$d r5 = (com.sumsub.sns.internal.core.data.model.h.d) r5
                com.sumsub.sns.internal.core.data.model.FieldName r6 = r5.q()
                com.sumsub.sns.internal.core.data.model.FieldName r7 = com.sumsub.sns.internal.core.data.model.FieldName.state
                if (r6 != r7) goto L_0x00e3
                boolean r6 = r5.A()
                if (r6 != 0) goto L_0x00b7
                com.sumsub.sns.internal.core.data.model.h r6 = r8.f36432e
                boolean r7 = r6 instanceof com.sumsub.sns.internal.core.data.model.h.d
                if (r7 == 0) goto L_0x0082
                com.sumsub.sns.internal.core.data.model.h$d r6 = (com.sumsub.sns.internal.core.data.model.h.d) r6
                goto L_0x0083
            L_0x0082:
                r6 = r2
            L_0x0083:
                if (r6 == 0) goto L_0x008d
                boolean r6 = r6.A()
                if (r6 != r3) goto L_0x008d
                r6 = r3
                goto L_0x008e
            L_0x008d:
                r6 = r1
            L_0x008e:
                if (r6 == 0) goto L_0x00e3
                boolean r6 = r8.f36433f
                if (r6 == 0) goto L_0x00e3
                com.sumsub.sns.internal.domain.c r6 = r8.f36434g
                if (r6 == 0) goto L_0x00b4
                com.sumsub.sns.internal.core.data.model.e r6 = r6.f()
                if (r6 == 0) goto L_0x00b4
                java.util.Map r6 = r6.u()
                if (r6 == 0) goto L_0x00b4
                java.lang.String r7 = r8.f36435h
                java.lang.Object r6 = r6.get(r7)
                java.util.Map r6 = (java.util.Map) r6
                if (r6 == 0) goto L_0x00b4
                boolean r6 = r6.isEmpty()
                r6 = r6 ^ r3
                goto L_0x00b5
            L_0x00b4:
                r6 = r1
            L_0x00b5:
                if (r6 == 0) goto L_0x00e3
            L_0x00b7:
                d10.l<java.lang.String, java.lang.String> r6 = r8.f36428a
                com.sumsub.sns.internal.core.data.model.FieldName r5 = r5.q()
                if (r5 == 0) goto L_0x00c4
                java.lang.String r5 = r5.getValue()
                goto L_0x00c5
            L_0x00c4:
                r5 = r2
            L_0x00c5:
                java.lang.Object r5 = r6.invoke(r5)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                int r5 = r5.length()
                if (r5 != 0) goto L_0x00d3
                r5 = r3
                goto L_0x00d4
            L_0x00d3:
                r5 = r1
            L_0x00d4:
                if (r5 == 0) goto L_0x00e3
                com.sumsub.sns.internal.domain.b r2 = new com.sumsub.sns.internal.domain.b
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r0 = r8.f36431d
                java.lang.String r0 = r0.a((java.lang.String) r4)
                r2.<init>(r9, r0)
                goto L_0x0178
            L_0x00e3:
                if (r0 == 0) goto L_0x015d
                r0 = r9
                com.sumsub.sns.internal.core.data.model.h$d r0 = (com.sumsub.sns.internal.core.data.model.h.d) r0
                com.sumsub.sns.internal.core.data.model.FieldName r5 = r0.q()
                com.sumsub.sns.internal.core.data.model.FieldName r6 = com.sumsub.sns.internal.core.data.model.FieldName.stateOfBirth
                if (r5 != r6) goto L_0x015d
                boolean r5 = r0.A()
                if (r5 != 0) goto L_0x0134
                com.sumsub.sns.internal.core.data.model.h r5 = r8.f36436i
                boolean r6 = r5 instanceof com.sumsub.sns.internal.core.data.model.h.d
                if (r6 == 0) goto L_0x00ff
                com.sumsub.sns.internal.core.data.model.h$d r5 = (com.sumsub.sns.internal.core.data.model.h.d) r5
                goto L_0x0100
            L_0x00ff:
                r5 = r2
            L_0x0100:
                if (r5 == 0) goto L_0x010a
                boolean r5 = r5.A()
                if (r5 != r3) goto L_0x010a
                r5 = r3
                goto L_0x010b
            L_0x010a:
                r5 = r1
            L_0x010b:
                if (r5 == 0) goto L_0x015d
                boolean r5 = r8.f36433f
                if (r5 == 0) goto L_0x015d
                com.sumsub.sns.internal.domain.c r5 = r8.f36434g
                if (r5 == 0) goto L_0x0131
                com.sumsub.sns.internal.core.data.model.e r5 = r5.f()
                if (r5 == 0) goto L_0x0131
                java.util.Map r5 = r5.u()
                if (r5 == 0) goto L_0x0131
                java.lang.String r6 = r8.f36437j
                java.lang.Object r5 = r5.get(r6)
                java.util.Map r5 = (java.util.Map) r5
                if (r5 == 0) goto L_0x0131
                boolean r5 = r5.isEmpty()
                r5 = r5 ^ r3
                goto L_0x0132
            L_0x0131:
                r5 = r1
            L_0x0132:
                if (r5 == 0) goto L_0x015d
            L_0x0134:
                d10.l<java.lang.String, java.lang.String> r5 = r8.f36428a
                com.sumsub.sns.internal.core.data.model.FieldName r0 = r0.q()
                if (r0 == 0) goto L_0x0141
                java.lang.String r0 = r0.getValue()
                goto L_0x0142
            L_0x0141:
                r0 = r2
            L_0x0142:
                java.lang.Object r0 = r5.invoke(r0)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                int r0 = r0.length()
                if (r0 != 0) goto L_0x014f
                r1 = r3
            L_0x014f:
                if (r1 == 0) goto L_0x015d
                com.sumsub.sns.internal.domain.b r2 = new com.sumsub.sns.internal.domain.b
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r0 = r8.f36431d
                java.lang.String r0 = r0.a((java.lang.String) r4)
                r2.<init>(r9, r0)
                goto L_0x0178
            L_0x015d:
                d10.l<java.lang.String, java.lang.String> r0 = r8.f36428a
                java.lang.String r1 = r9.b()
                java.lang.Object r0 = r0.invoke(r1)
                java.lang.String r0 = (java.lang.String) r0
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r1 = r8.f36431d
                java.lang.Boolean r3 = r8.f36438k
                java.lang.String r0 = com.sumsub.sns.internal.presentation.utils.d.a((com.sumsub.sns.internal.core.data.model.h) r9, (java.lang.String) r0, (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r1, (java.lang.Boolean) r3)
                if (r0 == 0) goto L_0x0178
                com.sumsub.sns.internal.domain.b r2 = new com.sumsub.sns.internal.domain.b
                r2.<init>(r9, r0)
            L_0x0178:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.utils.b.a.invoke(com.sumsub.sns.internal.core.data.model.h):com.sumsub.sns.internal.domain.b");
        }
    }

    public static /* synthetic */ List a(g gVar, b.c cVar, a1 a1Var, c cVar2, boolean z11, Boolean bool, l lVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        boolean z12 = z11;
        if ((i11 & 16) != 0) {
            bool = Boolean.FALSE;
        }
        return a(gVar, cVar, a1Var, cVar2, z12, bool, lVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007b, code lost:
        if (r0 != null) goto L_0x0090;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x00b8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x00fb A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0124 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0163  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<com.sumsub.sns.internal.domain.b> a(kotlin.sequences.g<? extends com.sumsub.sns.internal.core.data.model.h> r15, com.sumsub.sns.internal.core.data.source.dynamic.b.c r16, com.sumsub.sns.internal.core.common.a1 r17, com.sumsub.sns.internal.domain.c r18, boolean r19, java.lang.Boolean r20, d10.l<? super java.lang.String, java.lang.String> r21) {
        /*
            r1 = r21
            java.util.Iterator r0 = r15.iterator()
        L_0x0006:
            boolean r2 = r0.hasNext()
            r3 = 0
            r12 = 1
            r13 = 0
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r0.next()
            r4 = r2
            com.sumsub.sns.internal.core.data.model.h r4 = (com.sumsub.sns.internal.core.data.model.h) r4
            boolean r5 = r4 instanceof com.sumsub.sns.internal.core.data.model.h.d
            if (r5 == 0) goto L_0x0026
            com.sumsub.sns.internal.core.data.model.h$d r4 = (com.sumsub.sns.internal.core.data.model.h.d) r4
            com.sumsub.sns.internal.core.data.model.FieldName r4 = r4.q()
            com.sumsub.sns.internal.core.data.model.FieldName r5 = com.sumsub.sns.internal.core.data.model.FieldName.country
            if (r4 != r5) goto L_0x0026
            r4 = r12
            goto L_0x0027
        L_0x0026:
            r4 = r3
        L_0x0027:
            if (r4 == 0) goto L_0x0006
            goto L_0x002b
        L_0x002a:
            r2 = r13
        L_0x002b:
            r5 = r2
            com.sumsub.sns.internal.core.data.model.h r5 = (com.sumsub.sns.internal.core.data.model.h) r5
            java.util.Iterator r0 = r15.iterator()
        L_0x0032:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0053
            java.lang.Object r2 = r0.next()
            r4 = r2
            com.sumsub.sns.internal.core.data.model.h r4 = (com.sumsub.sns.internal.core.data.model.h) r4
            boolean r6 = r4 instanceof com.sumsub.sns.internal.core.data.model.h.d
            if (r6 == 0) goto L_0x004f
            com.sumsub.sns.internal.core.data.model.h$d r4 = (com.sumsub.sns.internal.core.data.model.h.d) r4
            com.sumsub.sns.internal.core.data.model.FieldName r4 = r4.q()
            com.sumsub.sns.internal.core.data.model.FieldName r6 = com.sumsub.sns.internal.core.data.model.FieldName.country
            if (r4 != r6) goto L_0x004f
            r4 = r12
            goto L_0x0050
        L_0x004f:
            r4 = r3
        L_0x0050:
            if (r4 == 0) goto L_0x0032
            goto L_0x0054
        L_0x0053:
            r2 = r13
        L_0x0054:
            com.sumsub.sns.internal.core.data.model.h r2 = (com.sumsub.sns.internal.core.data.model.h) r2
            if (r2 == 0) goto L_0x007e
            com.sumsub.sns.internal.core.data.model.h$d r2 = (com.sumsub.sns.internal.core.data.model.h.d) r2
            com.sumsub.sns.internal.core.data.model.FieldName r0 = r2.q()
            if (r0 == 0) goto L_0x0065
            java.lang.String r0 = r0.getValue()
            goto L_0x0066
        L_0x0065:
            r0 = r13
        L_0x0066:
            java.lang.Object r0 = r1.invoke(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x007e
            int r2 = r0.length()
            if (r2 <= 0) goto L_0x0076
            r2 = r12
            goto L_0x0077
        L_0x0076:
            r2 = r3
        L_0x0077:
            if (r2 == 0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r0 = r13
        L_0x007b:
            if (r0 == 0) goto L_0x007e
            goto L_0x0090
        L_0x007e:
            if (r18 == 0) goto L_0x0092
            com.sumsub.sns.internal.core.data.model.g r0 = r18.g()
            if (r0 == 0) goto L_0x0092
            com.sumsub.sns.internal.core.data.model.g$a r0 = r0.C()
            if (r0 == 0) goto L_0x0092
            java.lang.String r0 = r0.o()
        L_0x0090:
            r8 = r0
            goto L_0x0093
        L_0x0092:
            r8 = r13
        L_0x0093:
            java.util.Iterator r0 = r15.iterator()
        L_0x0097:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00b8
            java.lang.Object r2 = r0.next()
            r4 = r2
            com.sumsub.sns.internal.core.data.model.h r4 = (com.sumsub.sns.internal.core.data.model.h) r4
            boolean r6 = r4 instanceof com.sumsub.sns.internal.core.data.model.h.d
            if (r6 == 0) goto L_0x00b4
            com.sumsub.sns.internal.core.data.model.h$d r4 = (com.sumsub.sns.internal.core.data.model.h.d) r4
            com.sumsub.sns.internal.core.data.model.FieldName r4 = r4.q()
            com.sumsub.sns.internal.core.data.model.FieldName r6 = com.sumsub.sns.internal.core.data.model.FieldName.taxResidenceCountry
            if (r4 != r6) goto L_0x00b4
            r4 = r12
            goto L_0x00b5
        L_0x00b4:
            r4 = r3
        L_0x00b5:
            if (r4 == 0) goto L_0x0097
            goto L_0x00b9
        L_0x00b8:
            r2 = r13
        L_0x00b9:
            com.sumsub.sns.internal.core.data.model.h r2 = (com.sumsub.sns.internal.core.data.model.h) r2
            if (r2 == 0) goto L_0x00d5
            com.sumsub.sns.internal.core.data.model.h$d r2 = (com.sumsub.sns.internal.core.data.model.h.d) r2
            com.sumsub.sns.internal.core.data.model.FieldName r0 = r2.q()
            if (r0 == 0) goto L_0x00ca
            java.lang.String r0 = r0.getValue()
            goto L_0x00cb
        L_0x00ca:
            r0 = r13
        L_0x00cb:
            java.lang.Object r0 = r1.invoke(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x00d5
            r4 = r0
            goto L_0x00d6
        L_0x00d5:
            r4 = r8
        L_0x00d6:
            java.util.Iterator r0 = r15.iterator()
        L_0x00da:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00fb
            java.lang.Object r2 = r0.next()
            r6 = r2
            com.sumsub.sns.internal.core.data.model.h r6 = (com.sumsub.sns.internal.core.data.model.h) r6
            boolean r7 = r6 instanceof com.sumsub.sns.internal.core.data.model.h.d
            if (r7 == 0) goto L_0x00f7
            com.sumsub.sns.internal.core.data.model.h$d r6 = (com.sumsub.sns.internal.core.data.model.h.d) r6
            com.sumsub.sns.internal.core.data.model.FieldName r6 = r6.q()
            com.sumsub.sns.internal.core.data.model.FieldName r7 = com.sumsub.sns.internal.core.data.model.FieldName.countryOfBirth
            if (r6 != r7) goto L_0x00f7
            r6 = r12
            goto L_0x00f8
        L_0x00f7:
            r6 = r3
        L_0x00f8:
            if (r6 == 0) goto L_0x00da
            goto L_0x00fc
        L_0x00fb:
            r2 = r13
        L_0x00fc:
            r9 = r2
            com.sumsub.sns.internal.core.data.model.h r9 = (com.sumsub.sns.internal.core.data.model.h) r9
            java.util.Iterator r0 = r15.iterator()
        L_0x0103:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0124
            java.lang.Object r2 = r0.next()
            r6 = r2
            com.sumsub.sns.internal.core.data.model.h r6 = (com.sumsub.sns.internal.core.data.model.h) r6
            boolean r7 = r6 instanceof com.sumsub.sns.internal.core.data.model.h.d
            if (r7 == 0) goto L_0x0120
            com.sumsub.sns.internal.core.data.model.h$d r6 = (com.sumsub.sns.internal.core.data.model.h.d) r6
            com.sumsub.sns.internal.core.data.model.FieldName r6 = r6.q()
            com.sumsub.sns.internal.core.data.model.FieldName r7 = com.sumsub.sns.internal.core.data.model.FieldName.countryOfBirth
            if (r6 != r7) goto L_0x0120
            r6 = r12
            goto L_0x0121
        L_0x0120:
            r6 = r3
        L_0x0121:
            if (r6 == 0) goto L_0x0103
            goto L_0x0125
        L_0x0124:
            r2 = r13
        L_0x0125:
            com.sumsub.sns.internal.core.data.model.h r2 = (com.sumsub.sns.internal.core.data.model.h) r2
            if (r2 == 0) goto L_0x013f
            com.sumsub.sns.internal.core.data.model.h$d r2 = (com.sumsub.sns.internal.core.data.model.h.d) r2
            com.sumsub.sns.internal.core.data.model.FieldName r0 = r2.q()
            if (r0 == 0) goto L_0x0136
            java.lang.String r0 = r0.getValue()
            goto L_0x0137
        L_0x0136:
            r0 = r13
        L_0x0137:
            java.lang.Object r0 = r1.invoke(r0)
            java.lang.String r0 = (java.lang.String) r0
            r10 = r0
            goto L_0x0140
        L_0x013f:
            r10 = r13
        L_0x0140:
            com.sumsub.sns.internal.presentation.utils.b$a r14 = new com.sumsub.sns.internal.presentation.utils.b$a
            r0 = r14
            r1 = r21
            r2 = r17
            r3 = r4
            r4 = r16
            r6 = r19
            r7 = r18
            r11 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r15
            kotlin.sequences.g r0 = kotlin.sequences.SequencesKt___SequencesKt.t(r15, r14)
            java.util.List r0 = kotlin.sequences.SequencesKt___SequencesKt.w(r0)
            boolean r1 = r0.isEmpty()
            r1 = r1 ^ r12
            if (r1 == 0) goto L_0x0164
            r13 = r0
        L_0x0164:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.utils.b.a(kotlin.sequences.g, com.sumsub.sns.internal.core.data.source.dynamic.b$c, com.sumsub.sns.internal.core.common.a1, com.sumsub.sns.internal.domain.c, boolean, java.lang.Boolean, d10.l):java.util.List");
    }
}
