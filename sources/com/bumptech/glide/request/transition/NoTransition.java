package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.a;
import d4.a;

public class NoTransition<R> implements a<R> {

    /* renamed from: a  reason: collision with root package name */
    public static final NoTransition<?> f64260a = new NoTransition<>();

    /* renamed from: b  reason: collision with root package name */
    public static final a<?> f64261b = new NoAnimationFactory();

    public static class NoAnimationFactory<R> implements a<R> {
        public a<R> a(DataSource dataSource, boolean z11) {
            return NoTransition.f64260a;
        }
    }

    public static <R> a<R> b() {
        return f64261b;
    }

    public boolean a(Object obj, a.C0707a aVar) {
        return false;
    }
}
