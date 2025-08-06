package com.sumsub.sns.internal.ff.core;

import com.sumsub.sns.internal.core.data.source.dynamic.b;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f34248a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f34249b = new ConcurrentHashMap<>();

    public final Collection<a> a() {
        return this.f34249b.values();
    }

    public final Collection<a> b() {
        return this.f34248a.values();
    }

    public final void c() {
        for (Map.Entry<String, a> value : this.f34248a.entrySet()) {
            ((a) value.getValue()).j();
        }
        for (Map.Entry<String, a> value2 : this.f34249b.entrySet()) {
            ((a) value2.getValue()).j();
        }
    }

    public static /* synthetic */ a b(b bVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        return bVar.b(str, str2, str3);
    }

    public final void a(b.C0365b bVar) {
        for (b.C0365b.a aVar : bVar.a()) {
            a aVar2 = this.f34248a.get(aVar.d());
            if (aVar2 != null) {
                aVar2.c(aVar.f(), aVar.e());
            }
        }
    }

    public final a b(String str, String str2, String str3) {
        return a(str, str3, str2, true);
    }

    public final a a(String str) {
        a aVar = this.f34248a.get(str);
        return aVar == null ? this.f34249b.get(str) : aVar;
    }

    public static /* synthetic */ a a(b bVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        return bVar.a(str, str2, str3);
    }

    public final a a(String str, String str2, String str3) {
        return a(str, str3, str2, false);
    }

    public final a a(String str, String str2, String str3, boolean z11) {
        if (this.f34249b.contains(str) || this.f34248a.contains(str)) {
            throw new IllegalArgumentException("Feature name " + str + " is already used");
        }
        a aVar = new a(str, str3, z11, str2);
        if (z11) {
            this.f34249b.put(str, aVar);
        } else {
            this.f34248a.put(str, aVar);
        }
        return aVar;
    }
}
