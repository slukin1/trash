package com.sumsub.sns.internal.domain;

import com.sumsub.sns.internal.core.data.model.e;
import com.sumsub.sns.internal.core.data.model.g;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final g f34066a;

    /* renamed from: b  reason: collision with root package name */
    public final e f34067b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f34068c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f34069d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, Map<String, String>> f34070e;

    public c() {
        this((g) null, (e) null, (Map) null, (Map) null, (Map) null, 31, (r) null);
    }

    public final g a() {
        return this.f34066a;
    }

    public final e b() {
        return this.f34067b;
    }

    public final Map<String, String> c() {
        return this.f34068c;
    }

    public final Map<String, String> d() {
        return this.f34069d;
    }

    public final Map<String, Map<String, String>> e() {
        return this.f34070e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return x.b(this.f34066a, cVar.f34066a) && x.b(this.f34067b, cVar.f34067b) && x.b(this.f34068c, cVar.f34068c) && x.b(this.f34069d, cVar.f34069d) && x.b(this.f34070e, cVar.f34070e);
    }

    public final e f() {
        return this.f34067b;
    }

    public final g g() {
        return this.f34066a;
    }

    public final Map<String, String> h() {
        return this.f34069d;
    }

    public int hashCode() {
        g gVar = this.f34066a;
        int i11 = 0;
        int hashCode = (gVar == null ? 0 : gVar.hashCode()) * 31;
        e eVar = this.f34067b;
        if (eVar != null) {
            i11 = eVar.hashCode();
        }
        return ((((((hashCode + i11) * 31) + this.f34068c.hashCode()) * 31) + this.f34069d.hashCode()) * 31) + this.f34070e.hashCode();
    }

    public final Map<String, Map<String, String>> i() {
        return this.f34070e;
    }

    public final Map<String, String> j() {
        return this.f34068c;
    }

    public String toString() {
        return "ApplicantDataResources(applicant=" + this.f34066a + ", appConfig=" + this.f34067b + ", genders=" + this.f34068c + ", countries=" + this.f34069d + ", countryStates=" + this.f34070e + ')';
    }

    public c(g gVar, e eVar, Map<String, String> map, Map<String, String> map2, Map<String, ? extends Map<String, String>> map3) {
        this.f34066a = gVar;
        this.f34067b = eVar;
        this.f34068c = map;
        this.f34069d = map2;
        this.f34070e = map3;
    }

    public final c a(g gVar, e eVar, Map<String, String> map, Map<String, String> map2, Map<String, ? extends Map<String, String>> map3) {
        return new c(gVar, eVar, map, map2, map3);
    }

    public static /* synthetic */ c a(c cVar, g gVar, e eVar, Map<String, String> map, Map<String, String> map2, Map<String, Map<String, String>> map3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            gVar = cVar.f34066a;
        }
        if ((i11 & 2) != 0) {
            eVar = cVar.f34067b;
        }
        e eVar2 = eVar;
        if ((i11 & 4) != 0) {
            map = cVar.f34068c;
        }
        Map<String, String> map4 = map;
        if ((i11 & 8) != 0) {
            map2 = cVar.f34069d;
        }
        Map<String, String> map5 = map2;
        if ((i11 & 16) != 0) {
            map3 = cVar.f34070e;
        }
        return cVar.a(gVar, eVar2, map4, map5, map3);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ c(com.sumsub.sns.internal.core.data.model.g r4, com.sumsub.sns.internal.core.data.model.e r5, java.util.Map r6, java.util.Map r7, java.util.Map r8, int r9, kotlin.jvm.internal.r r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r0 = r5
        L_0x000e:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0016
            java.util.Map r6 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x0016:
            r1 = r6
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001f
            java.util.Map r7 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x001f:
            r2 = r7
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0028
            java.util.Map r8 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x0028:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r0
            r7 = r1
            r8 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.c.<init>(com.sumsub.sns.internal.core.data.model.g, com.sumsub.sns.internal.core.data.model.e, java.util.Map, java.util.Map, java.util.Map, int, kotlin.jvm.internal.r):void");
    }
}
