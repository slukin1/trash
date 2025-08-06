package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.d;
import f4.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import n3.b;
import o3.d;

public class e<Model, Data> implements d<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final List<d<Model, Data>> f63996a;

    /* renamed from: b  reason: collision with root package name */
    public final androidx.core.util.e<List<Throwable>> f63997b;

    public static class a<Data> implements d<Data>, d.a<Data> {

        /* renamed from: b  reason: collision with root package name */
        public final List<d<Data>> f63998b;

        /* renamed from: c  reason: collision with root package name */
        public final androidx.core.util.e<List<Throwable>> f63999c;

        /* renamed from: d  reason: collision with root package name */
        public int f64000d = 0;

        /* renamed from: e  reason: collision with root package name */
        public Priority f64001e;

        /* renamed from: f  reason: collision with root package name */
        public d.a<? super Data> f64002f;

        /* renamed from: g  reason: collision with root package name */
        public List<Throwable> f64003g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f64004h;

        public a(List<d<Data>> list, androidx.core.util.e<List<Throwable>> eVar) {
            this.f63999c = eVar;
            h.c(list);
            this.f63998b = list;
        }

        public Class<Data> a() {
            return this.f63998b.get(0).a();
        }

        public void b() {
            List<Throwable> list = this.f64003g;
            if (list != null) {
                this.f63999c.release(list);
            }
            this.f64003g = null;
            for (d<Data> b11 : this.f63998b) {
                b11.b();
            }
        }

        public DataSource c() {
            return this.f63998b.get(0).c();
        }

        public void cancel() {
            this.f64004h = true;
            for (d<Data> cancel : this.f63998b) {
                cancel.cancel();
            }
        }

        public void d(Data data) {
            if (data != null) {
                this.f64002f.d(data);
            } else {
                g();
            }
        }

        public void e(Exception exc) {
            ((List) h.d(this.f64003g)).add(exc);
            g();
        }

        public void f(Priority priority, d.a<? super Data> aVar) {
            this.f64001e = priority;
            this.f64002f = aVar;
            this.f64003g = this.f63999c.acquire();
            this.f63998b.get(this.f64000d).f(priority, this);
            if (this.f64004h) {
                cancel();
            }
        }

        public final void g() {
            if (!this.f64004h) {
                if (this.f64000d < this.f63998b.size() - 1) {
                    this.f64000d++;
                    f(this.f64001e, this.f64002f);
                    return;
                }
                h.d(this.f64003g);
                this.f64002f.e(new GlideException("Fetch failed", (List<Throwable>) new ArrayList(this.f64003g)));
            }
        }
    }

    public e(List<d<Model, Data>> list, androidx.core.util.e<List<Throwable>> eVar) {
        this.f63996a = list;
        this.f63997b = eVar;
    }

    public d.a<Data> a(Model model, int i11, int i12, Options options) {
        d.a a11;
        int size = this.f63996a.size();
        ArrayList arrayList = new ArrayList(size);
        b bVar = null;
        for (int i13 = 0; i13 < size; i13++) {
            d dVar = this.f63996a.get(i13);
            if (dVar.b(model) && (a11 = dVar.a(model, i11, i12, options)) != null) {
                bVar = a11.f63993a;
                arrayList.add(a11.f63995c);
            }
        }
        if (arrayList.isEmpty() || bVar == null) {
            return null;
        }
        return new d.a<>(bVar, new a(arrayList, this.f63997b));
    }

    public boolean b(Model model) {
        for (d<Model, Data> b11 : this.f63996a) {
            if (b11.b(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f63996a.toArray()) + '}';
    }
}
