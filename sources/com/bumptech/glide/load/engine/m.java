package com.bumptech.glide.load.engine;

import f4.h;
import n3.b;

public class m<Z> implements r<Z> {

    /* renamed from: b  reason: collision with root package name */
    public final boolean f63896b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f63897c;

    /* renamed from: d  reason: collision with root package name */
    public final r<Z> f63898d;

    /* renamed from: e  reason: collision with root package name */
    public final a f63899e;

    /* renamed from: f  reason: collision with root package name */
    public final b f63900f;

    /* renamed from: g  reason: collision with root package name */
    public int f63901g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63902h;

    public interface a {
        void a(b bVar, m<?> mVar);
    }

    public m(r<Z> rVar, boolean z11, boolean z12, b bVar, a aVar) {
        this.f63898d = (r) h.d(rVar);
        this.f63896b = z11;
        this.f63897c = z12;
        this.f63900f = bVar;
        this.f63899e = (a) h.d(aVar);
    }

    public Class<Z> a() {
        return this.f63898d.a();
    }

    public synchronized void b() {
        if (!this.f63902h) {
            this.f63901g++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    public r<Z> c() {
        return this.f63898d;
    }

    public boolean d() {
        return this.f63896b;
    }

    public void e() {
        boolean z11;
        synchronized (this) {
            int i11 = this.f63901g;
            if (i11 > 0) {
                z11 = true;
                int i12 = i11 - 1;
                this.f63901g = i12;
                if (i12 != 0) {
                    z11 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z11) {
            this.f63899e.a(this.f63900f, this);
        }
    }

    public Z get() {
        return this.f63898d.get();
    }

    public int getSize() {
        return this.f63898d.getSize();
    }

    public synchronized void recycle() {
        if (this.f63901g > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f63902h) {
            this.f63902h = true;
            if (this.f63897c) {
                this.f63898d.recycle();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f63896b + ", listener=" + this.f63899e + ", key=" + this.f63900f + ", acquired=" + this.f63901g + ", isRecycled=" + this.f63902h + ", resource=" + this.f63898d + '}';
    }
}
