package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import o3.d;
import s3.d;

public class UnitModelLoader<Model> implements d<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    public static final UnitModelLoader<?> f63976a = new UnitModelLoader<>();

    public static class Factory<Model> implements d<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        public static final Factory<?> f63977a = new Factory<>();

        public static <T> Factory<T> a() {
            return f63977a;
        }

        public d<Model, Model> b(f fVar) {
            return UnitModelLoader.c();
        }

        public void teardown() {
        }
    }

    public static class a<Model> implements o3.d<Model> {

        /* renamed from: b  reason: collision with root package name */
        public final Model f63978b;

        public a(Model model) {
            this.f63978b = model;
        }

        public Class<Model> a() {
            return this.f63978b.getClass();
        }

        public void b() {
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
        }

        public void f(Priority priority, d.a<? super Model> aVar) {
            aVar.d(this.f63978b);
        }
    }

    public static <T> UnitModelLoader<T> c() {
        return f63976a;
    }

    public d.a<Model> a(Model model, int i11, int i12, Options options) {
        return new d.a<>(new e4.d(model), new a(model));
    }

    public boolean b(Model model) {
        return true;
    }
}
