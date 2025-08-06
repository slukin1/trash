package com.bumptech.glide.provider;

import java.util.ArrayList;
import java.util.List;
import n3.f;

public class ResourceEncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<?>> f64181a = new ArrayList();

    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<T> f64182a;

        /* renamed from: b  reason: collision with root package name */
        public final f<T> f64183b;

        public a(Class<T> cls, f<T> fVar) {
            this.f64182a = cls;
            this.f64183b = fVar;
        }

        public boolean a(Class<?> cls) {
            return this.f64182a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, f<Z> fVar) {
        this.f64181a.add(new a(cls, fVar));
    }

    public synchronized <Z> f<Z> b(Class<Z> cls) {
        int size = this.f64181a.size();
        for (int i11 = 0; i11 < size; i11++) {
            a aVar = this.f64181a.get(i11);
            if (aVar.a(cls)) {
                return aVar.f64183b;
            }
        }
        return null;
    }
}
