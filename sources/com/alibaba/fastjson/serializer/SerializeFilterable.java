package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import h2.c;
import h2.e;
import h2.i;
import h2.j;
import h2.l;
import h2.m;
import h2.p;
import h2.q;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class SerializeFilterable {

    /* renamed from: a  reason: collision with root package name */
    public List<BeforeFilter> f14307a = null;

    /* renamed from: b  reason: collision with root package name */
    public List<AfterFilter> f14308b = null;

    /* renamed from: c  reason: collision with root package name */
    public List<l> f14309c = null;

    /* renamed from: d  reason: collision with root package name */
    public List<q> f14310d = null;

    /* renamed from: e  reason: collision with root package name */
    public List<j> f14311e = null;

    /* renamed from: f  reason: collision with root package name */
    public List<m> f14312f = null;

    /* renamed from: g  reason: collision with root package name */
    public List<i> f14313g = null;

    /* renamed from: h  reason: collision with root package name */
    public List<e> f14314h = null;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14315i = true;

    public void b(p pVar) {
        if (pVar != null) {
            if (pVar instanceof m) {
                m().add((m) pVar);
            }
            if (pVar instanceof j) {
                k().add((j) pVar);
            }
            if (pVar instanceof q) {
                n().add((q) pVar);
            }
            if (pVar instanceof e) {
                i().add((e) pVar);
            }
            if (pVar instanceof l) {
                l().add((l) pVar);
            }
            if (pVar instanceof BeforeFilter) {
                h().add((BeforeFilter) pVar);
            }
            if (pVar instanceof AfterFilter) {
                g().add((AfterFilter) pVar);
            }
            if (pVar instanceof i) {
                j().add((i) pVar);
            }
        }
    }

    public boolean e(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        List<l> list = jSONSerializer.f14309c;
        if (list != null) {
            for (l b11 : list) {
                if (!b11.b(obj, str, obj2)) {
                    return false;
                }
            }
        }
        List<l> list2 = this.f14309c;
        if (list2 == null) {
            return true;
        }
        for (l b12 : list2) {
            if (!b12.b(obj, str, obj2)) {
                return false;
            }
        }
        return true;
    }

    public boolean f(JSONSerializer jSONSerializer, Object obj, String str) {
        List<m> list = jSONSerializer.f14312f;
        if (list != null) {
            for (m d11 : list) {
                if (!d11.d(jSONSerializer, obj, str)) {
                    return false;
                }
            }
        }
        List<m> list2 = this.f14312f;
        if (list2 == null) {
            return true;
        }
        for (m d12 : list2) {
            if (!d12.d(jSONSerializer, obj, str)) {
                return false;
            }
        }
        return true;
    }

    public List<AfterFilter> g() {
        if (this.f14308b == null) {
            this.f14308b = new ArrayList();
            this.f14315i = false;
        }
        return this.f14308b;
    }

    public List<BeforeFilter> h() {
        if (this.f14307a == null) {
            this.f14307a = new ArrayList();
            this.f14315i = false;
        }
        return this.f14307a;
    }

    public List<e> i() {
        if (this.f14314h == null) {
            this.f14314h = new ArrayList();
            this.f14315i = false;
        }
        return this.f14314h;
    }

    public List<i> j() {
        if (this.f14313g == null) {
            this.f14313g = new ArrayList();
            this.f14315i = false;
        }
        return this.f14313g;
    }

    public List<j> k() {
        if (this.f14311e == null) {
            this.f14311e = new ArrayList();
            this.f14315i = false;
        }
        return this.f14311e;
    }

    public List<l> l() {
        if (this.f14309c == null) {
            this.f14309c = new ArrayList();
            this.f14315i = false;
        }
        return this.f14309c;
    }

    public List<m> m() {
        if (this.f14312f == null) {
            this.f14312f = new ArrayList();
            this.f14315i = false;
        }
        return this.f14312f;
    }

    public List<q> n() {
        if (this.f14310d == null) {
            this.f14310d = new ArrayList();
            this.f14315i = false;
        }
        return this.f14310d;
    }

    public String o(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        List<j> list = jSONSerializer.f14311e;
        if (list != null) {
            for (j a11 : list) {
                str = a11.a(obj, str, obj2);
            }
        }
        List<j> list2 = this.f14311e;
        if (list2 != null) {
            for (j a12 : list2) {
                str = a12.a(obj, str, obj2);
            }
        }
        return str;
    }

    public Object p(JSONSerializer jSONSerializer, c cVar, Object obj, String str, Object obj2) {
        boolean z11;
        if (obj2 != null) {
            if ((jSONSerializer.f14277k.f14329k || !(cVar == null || (cVar.a() & SerializerFeature.WriteNonStringValueAsString.mask) == 0)) && (((z11 = obj2 instanceof Number)) || (obj2 instanceof Boolean))) {
                String str2 = null;
                if (z11 && cVar != null) {
                    str2 = cVar.b();
                }
                if (str2 != null) {
                    obj2 = new DecimalFormat(str2).format(obj2);
                } else {
                    obj2 = obj2.toString();
                }
            } else if (cVar != null && cVar.c()) {
                obj2 = JSON.parse((String) obj2);
            }
        }
        List<q> list = jSONSerializer.f14310d;
        if (list != null) {
            for (q a11 : list) {
                obj2 = a11.a(obj, str, obj2);
            }
        }
        List<q> list2 = this.f14310d;
        if (list2 != null) {
            for (q a12 : list2) {
                obj2 = a12.a(obj, str, obj2);
            }
        }
        List<e> list3 = jSONSerializer.f14314h;
        if (list3 != null) {
            for (e e11 : list3) {
                obj2 = e11.e(cVar, obj, str, obj2);
            }
        }
        List<e> list4 = this.f14314h;
        if (list4 != null) {
            for (e e12 : list4) {
                obj2 = e12.e(cVar, obj, str, obj2);
            }
        }
        return obj2;
    }
}
