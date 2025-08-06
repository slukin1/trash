package com.sumsub.sns.internal.core.data.model.remote.response;

import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.ReviewAnswerType;
import com.sumsub.sns.internal.core.data.model.ReviewRejectType;
import com.sumsub.sns.internal.core.data.model.ReviewStatusType;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.remote.response.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.l;

public final class e {
    public static final g.c.a a(d.c.e.C0352c cVar) {
        DocumentType a11 = DocumentType.Companion.a(cVar.p());
        List<String> x11 = cVar.x();
        if (x11 == null) {
            x11 = CollectionsKt__CollectionsKt.k();
        }
        List<String> list = x11;
        List<IdentitySide> v11 = cVar.v();
        if (v11 == null) {
            v11 = CollectionsKt__CollectionsKt.k();
        }
        return new g.c.a(a11, list, v11, cVar.z(), cVar.n(), cVar.l(), cVar.t(), cVar.r(), cVar.j());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x004d, code lost:
        if (r0 == null) goto L_0x004f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.internal.core.data.model.g b(com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d r20) {
        /*
            com.sumsub.sns.internal.core.data.model.g r18 = new com.sumsub.sns.internal.core.data.model.g
            java.lang.String r1 = r20.O()
            java.lang.String r2 = r20.y()
            java.lang.String r3 = r20.m0()
            java.lang.String r4 = r20.C()
            java.lang.String r5 = r20.E()
            java.lang.String r6 = r20.S()
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$e r0 = r20.g0()
            com.sumsub.sns.internal.core.data.model.g$c r7 = a((com.sumsub.sns.internal.core.data.model.remote.response.d.c.e) r0)
            java.lang.String r8 = r20.K()
            com.sumsub.sns.internal.core.data.model.b r9 = r20.w()
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$f r0 = r20.i0()
            com.sumsub.sns.internal.core.data.model.g$d r10 = a((com.sumsub.sns.internal.core.data.model.remote.response.d.c.f) r0)
            java.lang.String r11 = r20.I()
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$c r0 = r20.M()
            r12 = 0
            if (r0 == 0) goto L_0x004f
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$c r13 = r20.Q()
            if (r13 == 0) goto L_0x0048
            java.lang.String r13 = r13.p()
            goto L_0x0049
        L_0x0048:
            r13 = r12
        L_0x0049:
            com.sumsub.sns.internal.core.data.model.g$a r0 = a(r0, r13)
            if (r0 != 0) goto L_0x005a
        L_0x004f:
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$c r0 = r20.Q()
            if (r0 == 0) goto L_0x005c
            r13 = 1
            com.sumsub.sns.internal.core.data.model.g$a r0 = a(r0, r12, r13, r12)
        L_0x005a:
            r13 = r0
            goto L_0x005d
        L_0x005c:
            r13 = r12
        L_0x005d:
            java.lang.String r14 = r20.Y()
            java.util.List r0 = r20.a0()
            if (r0 == 0) goto L_0x006e
            java.util.List r0 = a((java.util.List<com.sumsub.sns.internal.core.data.model.remote.e>) r0)
            r19 = r0
            goto L_0x0070
        L_0x006e:
            r19 = r12
        L_0x0070:
            java.lang.String r15 = r20.G()
            java.lang.String r16 = r20.c0()
            java.util.List r17 = r20.e0()
            r0 = r18
            r12 = r13
            r13 = r14
            r14 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.e.b(com.sumsub.sns.internal.core.data.model.remote.response.d$c$d):com.sumsub.sns.internal.core.data.model.g");
    }

    public static final g.c a(d.c.e eVar) {
        List list;
        List<d.c.e.C0352c> g11 = eVar.g();
        if (g11 != null) {
            list = new ArrayList(CollectionsKt__IterablesKt.u(g11, 10));
            for (d.c.e.C0352c a11 : g11) {
                list.add(a(a11));
            }
        } else {
            list = CollectionsKt__CollectionsKt.k();
        }
        List list2 = list;
        Boolean o11 = eVar.o();
        return new g.c(list2, o11 != null ? o11.booleanValue() : false, eVar.q(), eVar.m(), eVar.k(), eVar.i());
    }

    public static final g.d.a a(d.c.f.C0353c cVar) {
        String h11 = cVar.h();
        String f11 = cVar.f();
        ReviewAnswerType l11 = cVar.l();
        if (l11 == null) {
            l11 = ReviewAnswerType.Unknown;
        }
        ReviewAnswerType reviewAnswerType = l11;
        List<String> j11 = cVar.j();
        if (j11 == null) {
            j11 = CollectionsKt__CollectionsKt.k();
        }
        List<String> list = j11;
        ReviewRejectType n11 = cVar.n();
        if (n11 == null) {
            n11 = ReviewRejectType.Unknown;
        }
        return new g.d.a(h11, f11, reviewAnswerType, list, n11);
    }

    public static final g.d a(d.c.f fVar) {
        Integer v11 = fVar.v();
        ReviewStatusType F = fVar.F();
        if (F == null) {
            F = ReviewStatusType.Unknown;
        }
        ReviewStatusType reviewStatusType = F;
        Integer x11 = fVar.x();
        String n11 = fVar.n();
        d.c.f.C0353c B = fVar.B();
        return new g.d(v11, reviewStatusType, x11, n11, B != null ? a(B) : null, fVar.r(), fVar.p(), fVar.t());
    }

    public static /* synthetic */ g.a a(d.c.C0350c cVar, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        return a(cVar, str);
    }

    public static final g.a a(d.c.C0350c cVar, String str) {
        ArrayList arrayList;
        String p11 = cVar.p();
        String str2 = p11 == null ? str : p11;
        String v11 = cVar.v();
        String z11 = cVar.z();
        String D = cVar.D();
        String B = cVar.B();
        String x11 = cVar.x();
        String t11 = cVar.t();
        String H = cVar.H();
        String r11 = cVar.r();
        String J = cVar.J();
        String F = cVar.F();
        List<Map<String, Object>> n11 = cVar.n();
        if (n11 != null) {
            arrayList = new ArrayList(CollectionsKt__IterablesKt.u(n11, 10));
            Iterator<T> it2 = n11.iterator();
            while (it2.hasNext()) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it3 = ((Map) it2.next()).entrySet().iterator();
                while (it3.hasNext()) {
                    Map.Entry entry = (Map.Entry) it3.next();
                    String str3 = (String) entry.getKey();
                    Iterator<T> it4 = it2;
                    Object value = entry.getValue();
                    Iterator it5 = it3;
                    String str4 = value instanceof String ? (String) value : null;
                    Pair a11 = str4 != null ? l.a(str3, str4) : null;
                    if (a11 != null) {
                        arrayList2.add(a11);
                    }
                    it3 = it5;
                    it2 = it4;
                }
                arrayList.add(MapsKt__MapsKt.s(arrayList2));
                it2 = it2;
            }
        } else {
            arrayList = null;
        }
        return new g.a(str2, v11, z11, D, B, x11, t11, H, r11, J, F, arrayList, cVar.L());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0049, code lost:
        if (r0 == null) goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.internal.core.data.model.g a(com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d r19) {
        /*
            com.sumsub.sns.internal.core.data.model.g r18 = new com.sumsub.sns.internal.core.data.model.g
            java.lang.String r1 = r19.O()
            java.lang.String r3 = r19.m0()
            java.lang.String r4 = r19.C()
            java.lang.String r5 = r19.E()
            java.lang.String r6 = r19.S()
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$e r0 = r19.g0()
            com.sumsub.sns.internal.core.data.model.g$c r7 = a((com.sumsub.sns.internal.core.data.model.remote.response.d.c.e) r0)
            java.lang.String r8 = r19.K()
            com.sumsub.sns.internal.core.data.model.b r9 = r19.w()
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$f r0 = r19.i0()
            com.sumsub.sns.internal.core.data.model.g$d r10 = a((com.sumsub.sns.internal.core.data.model.remote.response.d.c.f) r0)
            java.lang.String r11 = r19.I()
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$c r0 = r19.M()
            r2 = 0
            if (r0 == 0) goto L_0x004b
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$c r12 = r19.Q()
            if (r12 == 0) goto L_0x0044
            java.lang.String r12 = r12.p()
            goto L_0x0045
        L_0x0044:
            r12 = r2
        L_0x0045:
            com.sumsub.sns.internal.core.data.model.g$a r0 = a(r0, r12)
            if (r0 != 0) goto L_0x0056
        L_0x004b:
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$c r0 = r19.Q()
            if (r0 == 0) goto L_0x0058
            r12 = 1
            com.sumsub.sns.internal.core.data.model.g$a r0 = a(r0, r2, r12, r2)
        L_0x0056:
            r12 = r0
            goto L_0x0059
        L_0x0058:
            r12 = r2
        L_0x0059:
            java.lang.String r13 = r19.Y()
            java.util.List r0 = r19.a0()
            if (r0 == 0) goto L_0x0069
            java.util.List r0 = a((java.util.List<com.sumsub.sns.internal.core.data.model.remote.e>) r0)
            r14 = r0
            goto L_0x006a
        L_0x0069:
            r14 = r2
        L_0x006a:
            java.lang.String r15 = r19.G()
            java.lang.String r16 = r19.c0()
            java.util.List r17 = r19.e0()
            r2 = 0
            r0 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.e.a(com.sumsub.sns.internal.core.data.model.remote.response.d$c$d):com.sumsub.sns.internal.core.data.model.g");
    }

    public static final List<g.b> a(List<com.sumsub.sns.internal.core.data.model.remote.e> list) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (com.sumsub.sns.internal.core.data.model.remote.e eVar : list) {
            String c11 = eVar.c();
            String e11 = eVar.e();
            if (e11 == null) {
                e11 = "";
            }
            arrayList.add(new g.b(c11, e11));
        }
        return arrayList;
    }
}
