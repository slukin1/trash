package com.sumsub.sns.internal.core.data.model;

import com.sumsub.sns.internal.core.data.model.remote.response.c;
import com.sumsub.sns.internal.core.data.model.remote.response.h;
import java.util.List;
import kotlin.jvm.internal.x;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final c f32923a;

    /* renamed from: b  reason: collision with root package name */
    public final List<Document> f32924b;

    /* renamed from: c  reason: collision with root package name */
    public final h f32925c;

    public t(c cVar, List<Document> list, h hVar) {
        this.f32923a = cVar;
        this.f32924b = list;
        this.f32925c = hVar;
    }

    public final c a() {
        return this.f32923a;
    }

    public final List<Document> b() {
        return this.f32924b;
    }

    public final h c() {
        return this.f32925c;
    }

    public final List<Document> d() {
        return this.f32924b;
    }

    public final c e() {
        return this.f32923a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return x.b(this.f32923a, tVar.f32923a) && x.b(this.f32924b, tVar.f32924b) && x.b(this.f32925c, tVar.f32925c);
    }

    public final h f() {
        return this.f32925c;
    }

    public int hashCode() {
        c cVar = this.f32923a;
        int i11 = 0;
        int hashCode = (((cVar == null ? 0 : cVar.hashCode()) * 31) + this.f32924b.hashCode()) * 31;
        h hVar = this.f32925c;
        if (hVar != null) {
            i11 = hVar.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "RequiredIdDocStatus(review=" + this.f32923a + ", documents=" + this.f32924b + ", workflowStatus=" + this.f32925c + ')';
    }

    public final t a(c cVar, List<Document> list, h hVar) {
        return new t(cVar, list, hVar);
    }

    public static /* synthetic */ t a(t tVar, c cVar, List<Document> list, h hVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cVar = tVar.f32923a;
        }
        if ((i11 & 2) != 0) {
            list = tVar.f32924b;
        }
        if ((i11 & 4) != 0) {
            hVar = tVar.f32925c;
        }
        return tVar.a(cVar, list, hVar);
    }
}
