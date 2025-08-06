package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Picasso f29986a;

    /* renamed from: b  reason: collision with root package name */
    public final q f29987b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<T> f29988c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f29989d;

    /* renamed from: e  reason: collision with root package name */
    public final int f29990e;

    /* renamed from: f  reason: collision with root package name */
    public final int f29991f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29992g;

    /* renamed from: h  reason: collision with root package name */
    public final Drawable f29993h;

    /* renamed from: i  reason: collision with root package name */
    public final String f29994i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f29995j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f29996k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f29997l;

    /* renamed from: com.squareup.picasso.a$a  reason: collision with other inner class name */
    public static class C0264a<M> extends WeakReference<M> {

        /* renamed from: a  reason: collision with root package name */
        public final a f29998a;

        public C0264a(a aVar, M m11, ReferenceQueue<? super M> referenceQueue) {
            super(m11, referenceQueue);
            this.f29998a = aVar;
        }
    }

    public a(Picasso picasso, T t11, q qVar, int i11, int i12, int i13, Drawable drawable, String str, Object obj, boolean z11) {
        C0264a aVar;
        this.f29986a = picasso;
        this.f29987b = qVar;
        if (t11 == null) {
            aVar = null;
        } else {
            aVar = new C0264a(this, t11, picasso.f29961k);
        }
        this.f29988c = aVar;
        this.f29990e = i11;
        this.f29991f = i12;
        this.f29989d = z11;
        this.f29992g = i13;
        this.f29993h = drawable;
        this.f29994i = str;
        this.f29995j = obj == null ? this : obj;
    }

    public void a() {
        this.f29997l = true;
    }

    public abstract void b(Bitmap bitmap, Picasso.LoadedFrom loadedFrom);

    public abstract void c(Exception exc);

    public String d() {
        return this.f29994i;
    }

    public int e() {
        return this.f29990e;
    }

    public int f() {
        return this.f29991f;
    }

    public Picasso g() {
        return this.f29986a;
    }

    public Picasso.Priority h() {
        return this.f29987b.f30101t;
    }

    public q i() {
        return this.f29987b;
    }

    public Object j() {
        return this.f29995j;
    }

    public T k() {
        WeakReference<T> weakReference = this.f29988c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean l() {
        return this.f29997l;
    }

    public boolean m() {
        return this.f29996k;
    }
}
