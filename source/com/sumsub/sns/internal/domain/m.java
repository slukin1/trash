package com.sumsub.sns.internal.domain;

import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.source.applicant.e;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.x;

public final class m extends com.sumsub.sns.internal.core.domain.base.b<g, a> {

    /* renamed from: b  reason: collision with root package name */
    public final e f34153b;

    /* renamed from: c  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f34154c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, Object> f34155a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f34156b;

        /* renamed from: c  reason: collision with root package name */
        public final List<com.sumsub.sns.internal.core.data.model.remote.e> f34157c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f34158d;

        public a(Map<String, ? extends Object> map, List<String> list, List<com.sumsub.sns.internal.core.data.model.remote.e> list2, List<String> list3) {
            this.f34155a = map;
            this.f34156b = list;
            this.f34157c = list2;
            this.f34158d = list3;
        }

        public final Map<String, Object> a() {
            return this.f34155a;
        }

        public final List<String> b() {
            return this.f34156b;
        }

        public final List<com.sumsub.sns.internal.core.data.model.remote.e> c() {
            return this.f34157c;
        }

        public final List<String> d() {
            return this.f34158d;
        }

        public final List<com.sumsub.sns.internal.core.data.model.remote.e> e() {
            return this.f34157c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f34155a, aVar.f34155a) && x.b(this.f34156b, aVar.f34156b) && x.b(this.f34157c, aVar.f34157c) && x.b(this.f34158d, aVar.f34158d);
        }

        public final Map<String, Object> f() {
            return this.f34155a;
        }

        public final List<String> g() {
            return this.f34158d;
        }

        public final List<String> h() {
            return this.f34156b;
        }

        public int hashCode() {
            int hashCode = this.f34155a.hashCode() * 31;
            List<String> list = this.f34156b;
            int i11 = 0;
            int hashCode2 = (((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.f34157c.hashCode()) * 31;
            List<String> list2 = this.f34158d;
            if (list2 != null) {
                i11 = list2.hashCode();
            }
            return hashCode2 + i11;
        }

        public String toString() {
            return "Params(fields=" + this.f34155a + ", unsetFields=" + this.f34156b + ", customFields=" + this.f34157c + ", unsetCoreFields=" + this.f34158d + ')';
        }

        public final a a(Map<String, ? extends Object> map, List<String> list, List<com.sumsub.sns.internal.core.data.model.remote.e> list2, List<String> list3) {
            return new a(map, list, list2, list3);
        }

        public static /* synthetic */ a a(a aVar, Map<String, Object> map, List<String> list, List<com.sumsub.sns.internal.core.data.model.remote.e> list2, List<String> list3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                map = aVar.f34155a;
            }
            if ((i11 & 2) != 0) {
                list = aVar.f34156b;
            }
            if ((i11 & 4) != 0) {
                list2 = aVar.f34157c;
            }
            if ((i11 & 8) != 0) {
                list3 = aVar.f34158d;
            }
            return aVar.a(map, list, list2, list3);
        }
    }

    @d(c = "com.sumsub.sns.internal.domain.UploadApplicantDataUseCase", f = "UploadApplicantDataUseCase.kt", l = {30, 45, 52}, m = "run")
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34159a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34160b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34161c;

        /* renamed from: d  reason: collision with root package name */
        public Object f34162d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f34163e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f34164f;

        /* renamed from: g  reason: collision with root package name */
        public int f34165g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(m mVar, c<? super b> cVar) {
            super(cVar);
            this.f34164f = mVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34163e = obj;
            this.f34165g |= Integer.MIN_VALUE;
            return this.f34164f.b((a) null, this);
        }
    }

    public m(com.sumsub.sns.internal.core.data.source.common.a aVar, e eVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(aVar);
        this.f34153b = eVar;
        this.f34154c = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a1 A[Catch:{ Exception -> 0x0038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cc A[Catch:{ Exception -> 0x0038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cf A[Catch:{ Exception -> 0x0038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d2 A[Catch:{ Exception -> 0x0038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012e A[Catch:{ Exception -> 0x0038 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012f A[Catch:{ Exception -> 0x0038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x013c A[Catch:{ Exception -> 0x0038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0178 A[Catch:{ Exception -> 0x0038 }, LOOP:3: B:67:0x0172->B:69:0x0178, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01c3 A[Catch:{ Exception -> 0x0038 }, LOOP:4: B:71:0x01bd->B:73:0x01c3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01f8 A[Catch:{ Exception -> 0x0038 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(com.sumsub.sns.internal.domain.m.a r18, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.domain.model.a<? extends java.lang.Exception, com.sumsub.sns.internal.core.data.model.g>> r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            java.lang.String r2 = "addresses"
            boolean r3 = r0 instanceof com.sumsub.sns.internal.domain.m.b
            if (r3 == 0) goto L_0x0019
            r3 = r0
            com.sumsub.sns.internal.domain.m$b r3 = (com.sumsub.sns.internal.domain.m.b) r3
            int r4 = r3.f34165g
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f34165g = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.domain.m$b r3 = new com.sumsub.sns.internal.domain.m$b
            r3.<init>(r1, r0)
        L_0x001e:
            r10 = r3
            java.lang.Object r0 = r10.f34163e
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r10.f34165g
            r11 = 3
            r12 = 2
            r13 = 1
            r14 = 0
            if (r4 == 0) goto L_0x006a
            if (r4 == r13) goto L_0x0058
            if (r4 == r12) goto L_0x0043
            if (r4 != r11) goto L_0x003b
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x0038 }
            goto L_0x01f9
        L_0x0038:
            r0 = move-exception
            goto L_0x0201
        L_0x003b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0043:
            java.lang.Object r2 = r10.f34162d
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r10.f34161c
            com.sumsub.sns.internal.core.data.model.g r4 = (com.sumsub.sns.internal.core.data.model.g) r4
            java.lang.Object r5 = r10.f34160b
            com.sumsub.sns.internal.domain.m$a r5 = (com.sumsub.sns.internal.domain.m.a) r5
            java.lang.Object r6 = r10.f34159a
            com.sumsub.sns.internal.domain.m r6 = (com.sumsub.sns.internal.domain.m) r6
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x0038 }
            goto L_0x0131
        L_0x0058:
            java.lang.Object r4 = r10.f34160b
            com.sumsub.sns.internal.domain.m$a r4 = (com.sumsub.sns.internal.domain.m.a) r4
            java.lang.Object r5 = r10.f34159a
            com.sumsub.sns.internal.domain.m r5 = (com.sumsub.sns.internal.domain.m) r5
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x0038 }
            r6 = r5
            r16 = r4
            r4 = r0
            r0 = r16
            goto L_0x0084
        L_0x006a:
            kotlin.k.b(r0)
            com.sumsub.sns.internal.core.data.source.dynamic.b r4 = r1.f34154c     // Catch:{ Exception -> 0x0038 }
            r5 = 0
            r6 = 0
            r8 = 3
            r9 = 0
            r10.f34159a = r1     // Catch:{ Exception -> 0x0038 }
            r0 = r18
            r10.f34160b = r0     // Catch:{ Exception -> 0x0038 }
            r10.f34165g = r13     // Catch:{ Exception -> 0x0038 }
            r7 = r10
            java.lang.Object r4 = com.sumsub.sns.internal.core.data.source.dynamic.h.e(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0038 }
            if (r4 != r3) goto L_0x0083
            return r3
        L_0x0083:
            r6 = r1
        L_0x0084:
            com.sumsub.sns.internal.core.data.model.g r4 = (com.sumsub.sns.internal.core.data.model.g) r4     // Catch:{ Exception -> 0x0038 }
            java.lang.String r5 = r4.B()     // Catch:{ Exception -> 0x0038 }
            java.util.Map r7 = r0.f()     // Catch:{ Exception -> 0x0038 }
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x0038 }
            r8.<init>()     // Catch:{ Exception -> 0x0038 }
            java.util.Set r7 = r7.entrySet()     // Catch:{ Exception -> 0x0038 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0038 }
        L_0x009b:
            boolean r9 = r7.hasNext()     // Catch:{ Exception -> 0x0038 }
            if (r9 == 0) goto L_0x00c0
            java.lang.Object r9 = r7.next()     // Catch:{ Exception -> 0x0038 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r15 = r9.getKey()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x0038 }
            boolean r15 = com.sumsub.sns.internal.core.data.model.i.a(r15)     // Catch:{ Exception -> 0x0038 }
            r15 = r15 ^ r13
            if (r15 == 0) goto L_0x009b
            java.lang.Object r15 = r9.getKey()     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r9 = r9.getValue()     // Catch:{ Exception -> 0x0038 }
            r8.put(r15, r9)     // Catch:{ Exception -> 0x0038 }
            goto L_0x009b
        L_0x00c0:
            java.util.Map r7 = kotlin.collections.MapsKt__MapsKt.y(r8)     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r8 = r7.get(r2)     // Catch:{ Exception -> 0x0038 }
            boolean r9 = r8 instanceof java.util.List     // Catch:{ Exception -> 0x0038 }
            if (r9 == 0) goto L_0x00cf
            java.util.List r8 = (java.util.List) r8     // Catch:{ Exception -> 0x0038 }
            goto L_0x00d0
        L_0x00cf:
            r8 = r14
        L_0x00d0:
            if (r8 == 0) goto L_0x0118
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x0038 }
            r9.<init>()     // Catch:{ Exception -> 0x0038 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x0038 }
        L_0x00db:
            boolean r15 = r8.hasNext()     // Catch:{ Exception -> 0x0038 }
            if (r15 == 0) goto L_0x00ee
            java.lang.Object r15 = r8.next()     // Catch:{ Exception -> 0x0038 }
            boolean r11 = r15 instanceof java.util.Map     // Catch:{ Exception -> 0x0038 }
            if (r11 == 0) goto L_0x00ec
            r9.add(r15)     // Catch:{ Exception -> 0x0038 }
        L_0x00ec:
            r11 = 3
            goto L_0x00db
        L_0x00ee:
            java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r9)     // Catch:{ Exception -> 0x0038 }
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ Exception -> 0x0038 }
            if (r8 == 0) goto L_0x0118
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x0038 }
            r9.<init>()     // Catch:{ Exception -> 0x0038 }
            r9.add(r8)     // Catch:{ Exception -> 0x0038 }
            com.sumsub.sns.internal.core.data.model.g$a r8 = r4.C()     // Catch:{ Exception -> 0x0038 }
            if (r8 == 0) goto L_0x0115
            java.util.List r8 = r8.n()     // Catch:{ Exception -> 0x0038 }
            if (r8 == 0) goto L_0x0115
            java.util.List r8 = kotlin.collections.CollectionsKt___CollectionsKt.T(r8, r13)     // Catch:{ Exception -> 0x0038 }
            boolean r8 = r9.addAll(r8)     // Catch:{ Exception -> 0x0038 }
            kotlin.coroutines.jvm.internal.a.a(r8)     // Catch:{ Exception -> 0x0038 }
        L_0x0115:
            r7.put(r2, r9)     // Catch:{ Exception -> 0x0038 }
        L_0x0118:
            com.sumsub.sns.internal.core.data.source.applicant.e r2 = r6.f34153b     // Catch:{ Exception -> 0x0038 }
            java.util.List r8 = r0.h()     // Catch:{ Exception -> 0x0038 }
            r10.f34159a = r6     // Catch:{ Exception -> 0x0038 }
            r10.f34160b = r0     // Catch:{ Exception -> 0x0038 }
            r10.f34161c = r4     // Catch:{ Exception -> 0x0038 }
            r10.f34162d = r5     // Catch:{ Exception -> 0x0038 }
            r10.f34165g = r12     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r2 = r2.a((java.lang.String) r5, (java.util.Map<java.lang.String, ? extends java.lang.Object>) r7, (java.util.List<java.lang.String>) r8, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g.a>) r10)     // Catch:{ Exception -> 0x0038 }
            if (r2 != r3) goto L_0x012f
            return r3
        L_0x012f:
            r2 = r5
            r5 = r0
        L_0x0131:
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x0038 }
            r0.<init>()     // Catch:{ Exception -> 0x0038 }
            java.util.List r4 = r4.F()     // Catch:{ Exception -> 0x0038 }
            if (r4 == 0) goto L_0x016a
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x0038 }
            r8 = 10
            int r8 = kotlin.collections.CollectionsKt__IterablesKt.u(r4, r8)     // Catch:{ Exception -> 0x0038 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0038 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0038 }
        L_0x014b:
            boolean r8 = r4.hasNext()     // Catch:{ Exception -> 0x0038 }
            if (r8 == 0) goto L_0x0167
            java.lang.Object r8 = r4.next()     // Catch:{ Exception -> 0x0038 }
            com.sumsub.sns.internal.core.data.model.g$b r8 = (com.sumsub.sns.internal.core.data.model.g.b) r8     // Catch:{ Exception -> 0x0038 }
            java.lang.String r9 = r8.c()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r8 = r8.d()     // Catch:{ Exception -> 0x0038 }
            kotlin.Pair r8 = kotlin.l.a(r9, r8)     // Catch:{ Exception -> 0x0038 }
            r7.add(r8)     // Catch:{ Exception -> 0x0038 }
            goto L_0x014b
        L_0x0167:
            java.util.Map unused = kotlin.collections.MapsKt__MapsKt.t(r7, r0)     // Catch:{ Exception -> 0x0038 }
        L_0x016a:
            java.util.List r4 = r5.e()     // Catch:{ Exception -> 0x0038 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0038 }
        L_0x0172:
            boolean r7 = r4.hasNext()     // Catch:{ Exception -> 0x0038 }
            if (r7 == 0) goto L_0x018a
            java.lang.Object r7 = r4.next()     // Catch:{ Exception -> 0x0038 }
            com.sumsub.sns.internal.core.data.model.remote.e r7 = (com.sumsub.sns.internal.core.data.model.remote.e) r7     // Catch:{ Exception -> 0x0038 }
            java.lang.String r8 = r7.c()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r7 = r7.e()     // Catch:{ Exception -> 0x0038 }
            r0.put(r8, r7)     // Catch:{ Exception -> 0x0038 }
            goto L_0x0172
        L_0x018a:
            com.sumsub.sns.internal.core.data.source.applicant.e r4 = r6.f34153b     // Catch:{ Exception -> 0x0038 }
            java.util.Map r6 = r5.f()     // Catch:{ Exception -> 0x0038 }
            com.sumsub.sns.internal.core.data.model.FieldName r7 = com.sumsub.sns.internal.core.data.model.FieldName.email     // Catch:{ Exception -> 0x0038 }
            java.lang.String r7 = r7.getValue()     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r6 = r6.get(r7)     // Catch:{ Exception -> 0x0038 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0038 }
            java.util.Map r7 = r5.f()     // Catch:{ Exception -> 0x0038 }
            com.sumsub.sns.internal.core.data.model.FieldName r8 = com.sumsub.sns.internal.core.data.model.FieldName.phone     // Catch:{ Exception -> 0x0038 }
            java.lang.String r8 = r8.getValue()     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r7 = r7.get(r8)     // Catch:{ Exception -> 0x0038 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0038 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x0038 }
            int r9 = r0.size()     // Catch:{ Exception -> 0x0038 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x0038 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x0038 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0038 }
        L_0x01bd:
            boolean r9 = r0.hasNext()     // Catch:{ Exception -> 0x0038 }
            if (r9 == 0) goto L_0x01de
            java.lang.Object r9 = r0.next()     // Catch:{ Exception -> 0x0038 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ Exception -> 0x0038 }
            com.sumsub.sns.internal.core.data.model.remote.e r11 = new com.sumsub.sns.internal.core.data.model.remote.e     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r12 = r9.getKey()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r9 = r9.getValue()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0038 }
            r11.<init>(r12, r9)     // Catch:{ Exception -> 0x0038 }
            r8.add(r11)     // Catch:{ Exception -> 0x0038 }
            goto L_0x01bd
        L_0x01de:
            java.util.List r8 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r8)     // Catch:{ Exception -> 0x0038 }
            java.util.List r9 = r5.g()     // Catch:{ Exception -> 0x0038 }
            r10.f34159a = r14     // Catch:{ Exception -> 0x0038 }
            r10.f34160b = r14     // Catch:{ Exception -> 0x0038 }
            r10.f34161c = r14     // Catch:{ Exception -> 0x0038 }
            r10.f34162d = r14     // Catch:{ Exception -> 0x0038 }
            r0 = 3
            r10.f34165g = r0     // Catch:{ Exception -> 0x0038 }
            r5 = r2
            java.lang.Object r0 = r4.a((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.util.List<com.sumsub.sns.internal.core.data.model.remote.e>) r8, (java.util.List<java.lang.String>) r9, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) r10)     // Catch:{ Exception -> 0x0038 }
            if (r0 != r3) goto L_0x01f9
            return r3
        L_0x01f9:
            com.sumsub.sns.internal.core.data.model.g r0 = (com.sumsub.sns.internal.core.data.model.g) r0     // Catch:{ Exception -> 0x0038 }
            com.sumsub.sns.internal.core.domain.model.a$b r2 = new com.sumsub.sns.internal.core.domain.model.a$b     // Catch:{ Exception -> 0x0038 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0038 }
            goto L_0x0206
        L_0x0201:
            com.sumsub.sns.internal.core.domain.model.a$a r2 = new com.sumsub.sns.internal.core.domain.model.a$a
            r2.<init>(r0)
        L_0x0206:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.m.b(com.sumsub.sns.internal.domain.m$a, kotlin.coroutines.c):java.lang.Object");
    }

    public m(com.sumsub.sns.internal.core.a aVar) {
        this(aVar.n(), aVar.h(), aVar.p());
    }
}
