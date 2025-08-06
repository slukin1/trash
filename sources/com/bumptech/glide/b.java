package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.a;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.e;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import java.util.List;
import java.util.Map;

public class b extends ContextWrapper {

    /* renamed from: k  reason: collision with root package name */
    public static final TransitionOptions<?, ?> f63606k = new GenericTransitionOptions();

    /* renamed from: a  reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f63607a;

    /* renamed from: b  reason: collision with root package name */
    public final Registry f63608b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageViewTargetFactory f63609c;

    /* renamed from: d  reason: collision with root package name */
    public final a.C0697a f63610d;

    /* renamed from: e  reason: collision with root package name */
    public final List<e<Object>> f63611e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<Class<?>, TransitionOptions<?, ?>> f63612f;

    /* renamed from: g  reason: collision with root package name */
    public final h f63613g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f63614h;

    /* renamed from: i  reason: collision with root package name */
    public final int f63615i;

    /* renamed from: j  reason: collision with root package name */
    public RequestOptions f63616j;

    public b(Context context, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, Registry registry, ImageViewTargetFactory imageViewTargetFactory, a.C0697a aVar, Map<Class<?>, TransitionOptions<?, ?>> map, List<e<Object>> list, h hVar, boolean z11, int i11) {
        super(context.getApplicationContext());
        this.f63607a = bVar;
        this.f63608b = registry;
        this.f63609c = imageViewTargetFactory;
        this.f63610d = aVar;
        this.f63611e = list;
        this.f63612f = map;
        this.f63613g = hVar;
        this.f63614h = z11;
        this.f63615i = i11;
    }

    public <X> c4.h<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.f63609c.a(imageView, cls);
    }

    public com.bumptech.glide.load.engine.bitmap_recycle.b b() {
        return this.f63607a;
    }

    public List<e<Object>> c() {
        return this.f63611e;
    }

    public synchronized RequestOptions d() {
        if (this.f63616j == null) {
            this.f63616j = (RequestOptions) this.f63610d.build().S();
        }
        return this.f63616j;
    }

    public <T> TransitionOptions<?, T> e(Class<T> cls) {
        TransitionOptions<?, T> transitionOptions = this.f63612f.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry next : this.f63612f.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions) next.getValue();
                }
            }
        }
        return transitionOptions == null ? f63606k : transitionOptions;
    }

    public h f() {
        return this.f63613g;
    }

    public int g() {
        return this.f63615i;
    }

    public Registry h() {
        return this.f63608b;
    }

    public boolean i() {
        return this.f63614h;
    }
}
