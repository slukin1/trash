package com.sumsub.sns.internal.core.domain;

import com.sumsub.sns.internal.core.data.model.q;
import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class g extends com.sumsub.sns.internal.core.domain.base.a<b, a> {

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f33594a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f33595a;

        /* renamed from: b  reason: collision with root package name */
        public final String f33596b;

        public a(String str, String str2) {
            this.f33595a = str;
            this.f33596b = str2;
        }

        public final String a() {
            return this.f33595a;
        }

        public final String b() {
            return this.f33596b;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f33597a;

        /* renamed from: b  reason: collision with root package name */
        public final List<q> f33598b;

        public b() {
            this((String) null, (List) null, 3, (r) null);
        }

        public final String a() {
            return this.f33597a;
        }

        public final List<q> b() {
            return this.f33598b;
        }

        public final String c() {
            return this.f33597a;
        }

        public final List<q> d() {
            return this.f33598b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return x.b(this.f33597a, bVar.f33597a) && x.b(this.f33598b, bVar.f33598b);
        }

        public int hashCode() {
            String str = this.f33597a;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.f33598b.hashCode();
        }

        public String toString() {
            return "Result(currentCountryKey=" + this.f33597a + ", documents=" + this.f33598b + ')';
        }

        public b(String str, List<? extends q> list) {
            this.f33597a = str;
            this.f33598b = list;
        }

        public final b a(String str, List<? extends q> list) {
            return new b(str, list);
        }

        public static /* synthetic */ b a(b bVar, String str, List<q> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = bVar.f33597a;
            }
            if ((i11 & 2) != 0) {
                list = bVar.f33598b;
            }
            return bVar.a(str, list);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(String str, List list, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? CollectionsKt__CollectionsKt.k() : list);
        }
    }

    @d(c = "com.sumsub.sns.internal.core.domain.DocumentsUseCase", f = "DocumentsUseCase.kt", l = {17, 22}, m = "run")
    public static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33599a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33600b;

        /* renamed from: c  reason: collision with root package name */
        public Object f33601c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f33602d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f33603e;

        /* renamed from: f  reason: collision with root package name */
        public int f33604f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(g gVar, kotlin.coroutines.c<? super c> cVar) {
            super(cVar);
            this.f33603e = gVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33602d = obj;
            this.f33604f |= Integer.MIN_VALUE;
            return this.f33603e.a((a) null, (kotlin.coroutines.c<? super b>) this);
        }
    }

    public g(com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        this.f33594a = bVar;
    }

    public final com.sumsub.sns.internal.core.data.source.dynamic.b a() {
        return this.f33594a;
    }

    public g(com.sumsub.sns.internal.core.a aVar) {
        this(aVar.p());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0178, code lost:
        if (r15 == null) goto L_0x017b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x00e0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0138 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0166 A[LOOP:2: B:81:0x0160->B:83:0x0166, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(com.sumsub.sns.internal.core.domain.g.a r14, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.domain.g.b> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.sumsub.sns.internal.core.domain.g.c
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.sumsub.sns.internal.core.domain.g$c r0 = (com.sumsub.sns.internal.core.domain.g.c) r0
            int r1 = r0.f33604f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33604f = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.domain.g$c r0 = new com.sumsub.sns.internal.core.domain.g$c
            r0.<init>(r13, r15)
        L_0x0018:
            r4 = r0
            java.lang.Object r15 = r4.f33602d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r4.f33604f
            r2 = 2
            r3 = 0
            r5 = 1
            r7 = 0
            if (r1 == 0) goto L_0x0050
            if (r1 == r5) goto L_0x0044
            if (r1 != r2) goto L_0x003c
            java.lang.Object r14 = r4.f33601c
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r0 = r4.f33600b
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r1 = r4.f33599a
            com.sumsub.sns.internal.core.domain.g$a r1 = (com.sumsub.sns.internal.core.domain.g.a) r1
            kotlin.k.b(r15)
            goto L_0x013e
        L_0x003c:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0044:
            java.lang.Object r14 = r4.f33600b
            com.sumsub.sns.internal.core.domain.g$a r14 = (com.sumsub.sns.internal.core.domain.g.a) r14
            java.lang.Object r1 = r4.f33599a
            com.sumsub.sns.internal.core.domain.g r1 = (com.sumsub.sns.internal.core.domain.g) r1
            kotlin.k.b(r15)
            goto L_0x0063
        L_0x0050:
            kotlin.k.b(r15)
            com.sumsub.sns.internal.core.data.source.dynamic.b r15 = r13.f33594a
            r4.f33599a = r13
            r4.f33600b = r14
            r4.f33604f = r5
            java.lang.Object r15 = com.sumsub.sns.internal.core.data.source.dynamic.h.b(r15, r3, r4, r5, r7)
            if (r15 != r0) goto L_0x0062
            return r0
        L_0x0062:
            r1 = r13
        L_0x0063:
            com.sumsub.sns.internal.core.data.model.e r15 = (com.sumsub.sns.internal.core.data.model.e) r15
            java.util.Map r8 = r15.v()
            java.lang.String r6 = r14.a()
            if (r6 == 0) goto L_0x0123
            java.util.Map r15 = r15.C()
            if (r15 == 0) goto L_0x007c
            java.lang.String r9 = "countries"
            java.lang.Object r15 = r15.get(r9)
            goto L_0x007d
        L_0x007c:
            r15 = r7
        L_0x007d:
            boolean r9 = r15 instanceof java.util.Map
            if (r9 == 0) goto L_0x0084
            java.util.Map r15 = (java.util.Map) r15
            goto L_0x0085
        L_0x0084:
            r15 = r7
        L_0x0085:
            if (r15 == 0) goto L_0x00c1
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x0094:
            boolean r10 = r15.hasNext()
            if (r10 == 0) goto L_0x00c2
            java.lang.Object r10 = r15.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r11 = r10.getKey()
            boolean r11 = r11 instanceof java.lang.String
            if (r11 == 0) goto L_0x00b2
            java.lang.Object r11 = r10.getValue()
            boolean r11 = r11 instanceof java.lang.String
            if (r11 == 0) goto L_0x00b2
            r11 = r5
            goto L_0x00b3
        L_0x00b2:
            r11 = r3
        L_0x00b3:
            if (r11 == 0) goto L_0x0094
            java.lang.Object r11 = r10.getKey()
            java.lang.Object r10 = r10.getValue()
            r9.put(r11, r10)
            goto L_0x0094
        L_0x00c1:
            r9 = r7
        L_0x00c2:
            if (r9 == 0) goto L_0x00cc
            boolean r15 = r9.isEmpty()
            r15 = r15 ^ r5
            if (r15 != r5) goto L_0x00cc
            goto L_0x00cd
        L_0x00cc:
            r5 = r3
        L_0x00cd:
            if (r5 == 0) goto L_0x00d0
            goto L_0x00d1
        L_0x00d0:
            r9 = r7
        L_0x00d1:
            if (r9 == 0) goto L_0x0118
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.Set r5 = r9.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x00e0:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x0113
            java.lang.Object r9 = r5.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getKey()
            boolean r11 = r10 instanceof java.lang.String
            if (r11 != 0) goto L_0x00f5
            r10 = r7
        L_0x00f5:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L_0x00fa
            goto L_0x0107
        L_0x00fa:
            java.lang.Object r9 = r9.getValue()
            boolean r11 = r9 instanceof java.lang.String
            if (r11 != 0) goto L_0x0103
            r9 = r7
        L_0x0103:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L_0x0109
        L_0x0107:
            r9 = r7
            goto L_0x010d
        L_0x0109:
            kotlin.Pair r9 = kotlin.l.a(r10, r9)
        L_0x010d:
            if (r9 == 0) goto L_0x00e0
            r15.add(r9)
            goto L_0x00e0
        L_0x0113:
            java.util.Map r15 = kotlin.collections.MapsKt__MapsKt.s(r15)
            goto L_0x0119
        L_0x0118:
            r15 = r7
        L_0x0119:
            if (r15 == 0) goto L_0x011f
            boolean r3 = r15.containsKey(r6)
        L_0x011f:
            if (r3 == 0) goto L_0x0123
            r15 = r6
            goto L_0x0124
        L_0x0123:
            r15 = r7
        L_0x0124:
            com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r1.f33594a
            r4.f33599a = r14
            r4.f33600b = r8
            r4.f33601c = r15
            r4.f33604f = r2
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            java.lang.Object r1 = com.sumsub.sns.internal.core.data.source.dynamic.h.e(r1, r2, r3, r4, r5, r6)
            if (r1 != r0) goto L_0x0139
            return r0
        L_0x0139:
            r0 = r8
            r12 = r1
            r1 = r14
            r14 = r15
            r15 = r12
        L_0x013e:
            com.sumsub.sns.internal.core.data.model.g r15 = (com.sumsub.sns.internal.core.data.model.g) r15
            java.lang.String r1 = r1.b()
            r2 = 10
            if (r1 == 0) goto L_0x017b
            com.sumsub.sns.internal.core.data.model.DocumentType r3 = new com.sumsub.sns.internal.core.data.model.DocumentType
            r3.<init>(r1)
            java.util.List r15 = r15.b(r3)
            if (r15 == 0) goto L_0x017b
            java.util.ArrayList r1 = new java.util.ArrayList
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.u(r15, r2)
            r1.<init>(r3)
            java.util.Iterator r15 = r15.iterator()
        L_0x0160:
            boolean r3 = r15.hasNext()
            if (r3 == 0) goto L_0x0174
            java.lang.Object r3 = r15.next()
            com.sumsub.sns.internal.core.data.model.q r3 = (com.sumsub.sns.internal.core.data.model.q) r3
            java.lang.String r3 = r3.b()
            r1.add(r3)
            goto L_0x0160
        L_0x0174:
            java.util.Set r15 = kotlin.collections.CollectionsKt___CollectionsKt.N0(r1)
            if (r15 == 0) goto L_0x017b
            goto L_0x017f
        L_0x017b:
            java.util.Set r15 = kotlin.collections.SetsKt__SetsKt.d()
        L_0x017f:
            if (r0 == 0) goto L_0x0186
            java.lang.Object r0 = r0.get(r14)
            goto L_0x0187
        L_0x0186:
            r0 = r7
        L_0x0187:
            boolean r1 = r0 instanceof java.util.Map
            if (r1 == 0) goto L_0x018e
            r7 = r0
            java.util.Map r7 = (java.util.Map) r7
        L_0x018e:
            if (r7 == 0) goto L_0x01da
            java.util.Set r0 = r7.keySet()
            if (r0 == 0) goto L_0x01da
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x019f:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x01b1
            java.lang.Object r3 = r0.next()
            boolean r4 = r3 instanceof java.lang.String
            if (r4 == 0) goto L_0x019f
            r1.add(r3)
            goto L_0x019f
        L_0x01b1:
            java.util.Set r15 = kotlin.collections.CollectionsKt___CollectionsKt.g0(r1, r15)
            if (r15 == 0) goto L_0x01da
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = kotlin.collections.CollectionsKt__IterablesKt.u(r15, r2)
            r0.<init>(r1)
            java.util.Iterator r15 = r15.iterator()
        L_0x01c4:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x01de
            java.lang.Object r1 = r15.next()
            java.lang.String r1 = (java.lang.String) r1
            com.sumsub.sns.internal.core.data.model.q$a r2 = com.sumsub.sns.internal.core.data.model.q.f32683c
            com.sumsub.sns.internal.core.data.model.q r1 = r2.a(r1)
            r0.add(r1)
            goto L_0x01c4
        L_0x01da:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x01de:
            com.sumsub.sns.internal.core.domain.g$b r15 = new com.sumsub.sns.internal.core.domain.g$b
            r15.<init>(r14, r0)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.g.a(com.sumsub.sns.internal.core.domain.g$a, kotlin.coroutines.c):java.lang.Object");
    }
}
