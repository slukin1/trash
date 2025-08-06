package com.bumptech.glide.provider;

import java.util.ArrayList;
import java.util.List;

public class EncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<?>> f64167a = new ArrayList();

    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<T> f64168a;

        /* renamed from: b  reason: collision with root package name */
        public final n3.a<T> f64169b;

        public a(Class<T> cls, n3.a<T> aVar) {
            this.f64168a = cls;
            this.f64169b = aVar;
        }

        public boolean a(Class<?> cls) {
            return this.f64168a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(Class<T> cls, n3.a<T> aVar) {
        this.f64167a.add(new a(cls, aVar));
    }

    public synchronized <T> n3.a<T> b(Class<T> cls) {
        for (a next : this.f64167a) {
            if (next.a(cls)) {
                return next.f64169b;
            }
        }
        return null;
    }
}
