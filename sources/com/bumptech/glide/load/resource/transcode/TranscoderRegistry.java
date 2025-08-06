package com.bumptech.glide.load.resource.transcode;

import java.util.ArrayList;
import java.util.List;
import z3.c;

public class TranscoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<?, ?>> f64138a = new ArrayList();

    public static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<Z> f64139a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<R> f64140b;

        /* renamed from: c  reason: collision with root package name */
        public final c<Z, R> f64141c;

        public a(Class<Z> cls, Class<R> cls2, c<Z, R> cVar) {
            this.f64139a = cls;
            this.f64140b = cls2;
            this.f64141c = cVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f64139a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f64140b);
        }
    }

    public synchronized <Z, R> c<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.b();
        }
        for (a next : this.f64138a) {
            if (next.a(cls, cls2)) {
                return next.f64141c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> a11 : this.f64138a) {
            if (a11.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(Class<Z> cls, Class<R> cls2, c<Z, R> cVar) {
        this.f64138a.add(new a(cls, cls2, cVar));
    }
}
