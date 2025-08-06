package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.a;
import f4.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataRewinderRegistry {

    /* renamed from: b  reason: collision with root package name */
    public static final a.C0699a<?> f63666b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, a.C0699a<?>> f63667a = new HashMap();

    public class a implements a.C0699a<Object> {
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        public a<Object> b(Object obj) {
            return new b(obj);
        }
    }

    public static final class b implements a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f63668a;

        public b(Object obj) {
            this.f63668a = obj;
        }

        public void b() {
        }

        public Object c() {
            return this.f63668a;
        }
    }

    public synchronized <T> a<T> a(T t11) {
        a.C0699a<?> aVar;
        h.d(t11);
        aVar = this.f63667a.get(t11.getClass());
        if (aVar == null) {
            Iterator<a.C0699a<?>> it2 = this.f63667a.values().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                a.C0699a<?> next = it2.next();
                if (next.a().isAssignableFrom(t11.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f63666b;
        }
        return aVar.b(t11);
    }

    public synchronized void b(a.C0699a<?> aVar) {
        this.f63667a.put(aVar.a(), aVar);
    }
}
