package io.noties.markwon;

import io.noties.markwon.core.a;
import io.noties.markwon.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class j implements d.b {

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f55412a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d> f55413b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<d> f55414c = new HashSet(3);

    public j(List<d> list) {
        this.f55412a = list;
        this.f55413b = new ArrayList(list.size());
    }

    public static <P extends d> P c(List<d> list, Class<P> cls) {
        Iterator<d> it2 = list.iterator();
        while (it2.hasNext()) {
            P p11 = (d) it2.next();
            if (cls.isAssignableFrom(p11.getClass())) {
                return p11;
            }
        }
        return null;
    }

    public <P extends d> void a(Class<P> cls, d.a<? super P> aVar) {
        aVar.a(d(cls));
    }

    public final void b(d dVar) {
        if (this.f55413b.contains(dVar)) {
            return;
        }
        if (!this.f55414c.contains(dVar)) {
            this.f55414c.add(dVar);
            dVar.configure(this);
            this.f55414c.remove(dVar);
            if (this.f55413b.contains(dVar)) {
                return;
            }
            if (a.class.isAssignableFrom(dVar.getClass())) {
                this.f55413b.add(0, dVar);
            } else {
                this.f55413b.add(dVar);
            }
        } else {
            throw new IllegalStateException("Cyclic dependency chain found: " + this.f55414c);
        }
    }

    public final <P extends d> P d(Class<P> cls) {
        P c11 = c(this.f55413b, cls);
        if (c11 == null) {
            c11 = c(this.f55412a, cls);
            if (c11 != null) {
                b(c11);
            } else {
                throw new IllegalStateException("Requested plugin is not added: " + cls.getName() + ", plugins: " + this.f55412a);
            }
        }
        return c11;
    }

    public List<d> e() {
        for (d b11 : this.f55412a) {
            b(b11);
        }
        return this.f55413b;
    }
}
