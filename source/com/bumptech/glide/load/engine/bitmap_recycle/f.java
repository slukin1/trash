package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class f<K extends i, V> {

    /* renamed from: a  reason: collision with root package name */
    public final a<K, V> f63766a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    public final Map<K, a<K, V>> f63767b = new HashMap();

    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final K f63768a;

        /* renamed from: b  reason: collision with root package name */
        public List<V> f63769b;

        /* renamed from: c  reason: collision with root package name */
        public a<K, V> f63770c;

        /* renamed from: d  reason: collision with root package name */
        public a<K, V> f63771d;

        public a() {
            this((Object) null);
        }

        public void a(V v11) {
            if (this.f63769b == null) {
                this.f63769b = new ArrayList();
            }
            this.f63769b.add(v11);
        }

        public V b() {
            int c11 = c();
            if (c11 > 0) {
                return this.f63769b.remove(c11 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f63769b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public a(K k11) {
            this.f63771d = this;
            this.f63770c = this;
            this.f63768a = k11;
        }
    }

    public static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f63771d;
        aVar2.f63770c = aVar.f63770c;
        aVar.f63770c.f63771d = aVar2;
    }

    public static <K, V> void g(a<K, V> aVar) {
        aVar.f63770c.f63771d = aVar;
        aVar.f63771d.f63770c = aVar;
    }

    public V a(K k11) {
        a aVar = this.f63767b.get(k11);
        if (aVar == null) {
            aVar = new a(k11);
            this.f63767b.put(k11, aVar);
        } else {
            k11.a();
        }
        b(aVar);
        return aVar.b();
    }

    public final void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f63766a;
        aVar.f63771d = aVar2;
        aVar.f63770c = aVar2.f63770c;
        g(aVar);
    }

    public final void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f63766a;
        aVar.f63771d = aVar2.f63771d;
        aVar.f63770c = aVar2;
        g(aVar);
    }

    public void d(K k11, V v11) {
        a aVar = this.f63767b.get(k11);
        if (aVar == null) {
            aVar = new a(k11);
            c(aVar);
            this.f63767b.put(k11, aVar);
        } else {
            k11.a();
        }
        aVar.a(v11);
    }

    public V f() {
        for (a<K, V> aVar = this.f63766a.f63771d; !aVar.equals(this.f63766a); aVar = aVar.f63771d) {
            V b11 = aVar.b();
            if (b11 != null) {
                return b11;
            }
            e(aVar);
            this.f63767b.remove(aVar.f63768a);
            ((i) aVar.f63768a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
        boolean z11 = false;
        for (a<K, V> aVar = this.f63766a.f63770c; !aVar.equals(this.f63766a); aVar = aVar.f63770c) {
            z11 = true;
            sb2.append('{');
            sb2.append(aVar.f63768a);
            sb2.append(':');
            sb2.append(aVar.c());
            sb2.append("}, ");
        }
        if (z11) {
            sb2.delete(sb2.length() - 2, sb2.length());
        }
        sb2.append(" )");
        return sb2.toString();
    }
}
