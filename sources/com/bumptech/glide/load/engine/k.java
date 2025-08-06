package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Options;
import f4.h;
import java.security.MessageDigest;
import java.util.Map;
import n3.b;
import n3.g;

public class k implements b {

    /* renamed from: b  reason: collision with root package name */
    public final Object f63887b;

    /* renamed from: c  reason: collision with root package name */
    public final int f63888c;

    /* renamed from: d  reason: collision with root package name */
    public final int f63889d;

    /* renamed from: e  reason: collision with root package name */
    public final Class<?> f63890e;

    /* renamed from: f  reason: collision with root package name */
    public final Class<?> f63891f;

    /* renamed from: g  reason: collision with root package name */
    public final b f63892g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<Class<?>, g<?>> f63893h;

    /* renamed from: i  reason: collision with root package name */
    public final Options f63894i;

    /* renamed from: j  reason: collision with root package name */
    public int f63895j;

    public k(Object obj, b bVar, int i11, int i12, Map<Class<?>, g<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.f63887b = h.d(obj);
        this.f63892g = (b) h.e(bVar, "Signature must not be null");
        this.f63888c = i11;
        this.f63889d = i12;
        this.f63893h = (Map) h.d(map);
        this.f63890e = (Class) h.e(cls, "Resource class must not be null");
        this.f63891f = (Class) h.e(cls2, "Transcode class must not be null");
        this.f63894i = (Options) h.d(options);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (!this.f63887b.equals(kVar.f63887b) || !this.f63892g.equals(kVar.f63892g) || this.f63889d != kVar.f63889d || this.f63888c != kVar.f63888c || !this.f63893h.equals(kVar.f63893h) || !this.f63890e.equals(kVar.f63890e) || !this.f63891f.equals(kVar.f63891f) || !this.f63894i.equals(kVar.f63894i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f63895j == 0) {
            int hashCode = this.f63887b.hashCode();
            this.f63895j = hashCode;
            int hashCode2 = (hashCode * 31) + this.f63892g.hashCode();
            this.f63895j = hashCode2;
            int i11 = (hashCode2 * 31) + this.f63888c;
            this.f63895j = i11;
            int i12 = (i11 * 31) + this.f63889d;
            this.f63895j = i12;
            int hashCode3 = (i12 * 31) + this.f63893h.hashCode();
            this.f63895j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f63890e.hashCode();
            this.f63895j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f63891f.hashCode();
            this.f63895j = hashCode5;
            this.f63895j = (hashCode5 * 31) + this.f63894i.hashCode();
        }
        return this.f63895j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f63887b + ", width=" + this.f63888c + ", height=" + this.f63889d + ", resourceClass=" + this.f63890e + ", transcodeClass=" + this.f63891f + ", signature=" + this.f63892g + ", hashCode=" + this.f63895j + ", transformations=" + this.f63893h + ", options=" + this.f63894i + '}';
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
