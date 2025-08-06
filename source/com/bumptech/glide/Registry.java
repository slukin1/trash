package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.data.a;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.load.model.d;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import g4.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import n3.f;
import s3.e;
import z3.c;

public class Registry {

    /* renamed from: a  reason: collision with root package name */
    public final e f63582a;

    /* renamed from: b  reason: collision with root package name */
    public final EncoderRegistry f63583b;

    /* renamed from: c  reason: collision with root package name */
    public final ResourceDecoderRegistry f63584c;

    /* renamed from: d  reason: collision with root package name */
    public final ResourceEncoderRegistry f63585d;

    /* renamed from: e  reason: collision with root package name */
    public final DataRewinderRegistry f63586e;

    /* renamed from: f  reason: collision with root package name */
    public final TranscoderRegistry f63587f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageHeaderParserRegistry f63588g;

    /* renamed from: h  reason: collision with root package name */
    public final ModelToResourceClassCache f63589h = new ModelToResourceClassCache();

    /* renamed from: i  reason: collision with root package name */
    public final LoadPathCache f63590i = new LoadPathCache();

    /* renamed from: j  reason: collision with root package name */
    public final androidx.core.util.e<List<Throwable>> f63591j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(M m11, List<d<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m11);
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        androidx.core.util.e<List<Throwable>> e11 = a.e();
        this.f63591j = e11;
        this.f63582a = new e(e11);
        this.f63583b = new EncoderRegistry();
        this.f63584c = new ResourceDecoderRegistry();
        this.f63585d = new ResourceEncoderRegistry();
        this.f63586e = new DataRewinderRegistry();
        this.f63587f = new TranscoderRegistry();
        this.f63588g = new ImageHeaderParserRegistry();
        s(Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
    }

    public <Data, TResource> Registry a(Class<Data> cls, Class<TResource> cls2, n3.e<Data, TResource> eVar) {
        e("legacy_append", cls, cls2, eVar);
        return this;
    }

    public <Model, Data> Registry b(Class<Model> cls, Class<Data> cls2, s3.d<Model, Data> dVar) {
        this.f63582a.a(cls, cls2, dVar);
        return this;
    }

    public <Data> Registry c(Class<Data> cls, n3.a<Data> aVar) {
        this.f63583b.a(cls, aVar);
        return this;
    }

    public <TResource> Registry d(Class<TResource> cls, f<TResource> fVar) {
        this.f63585d.a(cls, fVar);
        return this;
    }

    public <Data, TResource> Registry e(String str, Class<Data> cls, Class<TResource> cls2, n3.e<Data, TResource> eVar) {
        this.f63584c.a(str, eVar, cls, cls2);
        return this;
    }

    public final <Data, TResource, Transcode> List<g<Data, TResource, Transcode>> f(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class next : this.f63584c.d(cls, cls2)) {
            for (Class next2 : this.f63587f.b(next, cls3)) {
                arrayList.add(new g(cls, next, next2, this.f63584c.b(cls, next), this.f63587f.a(next, next2), this.f63591j));
            }
        }
        return arrayList;
    }

    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> b11 = this.f63588g.b();
        if (!b11.isEmpty()) {
            return b11;
        }
        throw new NoImageHeaderParserException();
    }

    public <Data, TResource, Transcode> p<Data, TResource, Transcode> h(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        p<Data, TResource, Transcode> a11 = this.f63590i.a(cls, cls2, cls3);
        if (this.f63590i.c(a11)) {
            return null;
        }
        if (a11 == null) {
            List<g<Data, TResource, Transcode>> f11 = f(cls, cls2, cls3);
            if (f11.isEmpty()) {
                a11 = null;
            } else {
                a11 = new p<>(cls, cls2, cls3, f11, this.f63591j);
            }
            this.f63590i.d(cls, cls2, cls3, a11);
        }
        return a11;
    }

    public <Model> List<d<Model, ?>> i(Model model) {
        return this.f63582a.d(model);
    }

    public <Model, TResource, Transcode> List<Class<?>> j(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a11 = this.f63589h.a(cls, cls2, cls3);
        if (a11 == null) {
            a11 = new ArrayList<>();
            for (Class<?> d11 : this.f63582a.c(cls)) {
                for (Class next : this.f63584c.d(d11, cls2)) {
                    if (!this.f63587f.b(next, cls3).isEmpty() && !a11.contains(next)) {
                        a11.add(next);
                    }
                }
            }
            this.f63589h.b(cls, cls2, cls3, Collections.unmodifiableList(a11));
        }
        return a11;
    }

    public <X> f<X> k(r<X> rVar) throws NoResultEncoderAvailableException {
        f<X> b11 = this.f63585d.b(rVar.a());
        if (b11 != null) {
            return b11;
        }
        throw new NoResultEncoderAvailableException(rVar.a());
    }

    public <X> com.bumptech.glide.load.data.a<X> l(X x11) {
        return this.f63586e.a(x11);
    }

    public <X> n3.a<X> m(X x11) throws NoSourceEncoderAvailableException {
        n3.a<X> b11 = this.f63583b.b(x11.getClass());
        if (b11 != null) {
            return b11;
        }
        throw new NoSourceEncoderAvailableException(x11.getClass());
    }

    public boolean n(r<?> rVar) {
        return this.f63585d.b(rVar.a()) != null;
    }

    public Registry o(ImageHeaderParser imageHeaderParser) {
        this.f63588g.a(imageHeaderParser);
        return this;
    }

    public Registry p(a.C0699a<?> aVar) {
        this.f63586e.b(aVar);
        return this;
    }

    public <TResource, Transcode> Registry q(Class<TResource> cls, Class<Transcode> cls2, c<TResource, Transcode> cVar) {
        this.f63587f.c(cls, cls2, cVar);
        return this;
    }

    public <Model, Data> Registry r(Class<Model> cls, Class<Data> cls2, s3.d<? extends Model, ? extends Data> dVar) {
        this.f63582a.f(cls, cls2, dVar);
        return this;
    }

    public final Registry s(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f63584c.e(arrayList);
        return this;
    }
}
