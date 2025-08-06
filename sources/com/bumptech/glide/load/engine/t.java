package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Options;
import f4.f;
import f4.i;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import n3.b;
import n3.g;

public final class t implements b {

    /* renamed from: j  reason: collision with root package name */
    public static final f<Class<?>, byte[]> f63924j = new f<>(50);

    /* renamed from: b  reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f63925b;

    /* renamed from: c  reason: collision with root package name */
    public final b f63926c;

    /* renamed from: d  reason: collision with root package name */
    public final b f63927d;

    /* renamed from: e  reason: collision with root package name */
    public final int f63928e;

    /* renamed from: f  reason: collision with root package name */
    public final int f63929f;

    /* renamed from: g  reason: collision with root package name */
    public final Class<?> f63930g;

    /* renamed from: h  reason: collision with root package name */
    public final Options f63931h;

    /* renamed from: i  reason: collision with root package name */
    public final g<?> f63932i;

    public t(com.bumptech.glide.load.engine.bitmap_recycle.b bVar, b bVar2, b bVar3, int i11, int i12, g<?> gVar, Class<?> cls, Options options) {
        this.f63925b = bVar;
        this.f63926c = bVar2;
        this.f63927d = bVar3;
        this.f63928e = i11;
        this.f63929f = i12;
        this.f63932i = gVar;
        this.f63930g = cls;
        this.f63931h = options;
    }

    public final byte[] a() {
        f<Class<?>, byte[]> fVar = f63924j;
        byte[] g11 = fVar.g(this.f63930g);
        if (g11 != null) {
            return g11;
        }
        byte[] bytes = this.f63930g.getName().getBytes(b.f66506a);
        fVar.k(this.f63930g, bytes);
        return bytes;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (this.f63929f != tVar.f63929f || this.f63928e != tVar.f63928e || !i.d(this.f63932i, tVar.f63932i) || !this.f63930g.equals(tVar.f63930g) || !this.f63926c.equals(tVar.f63926c) || !this.f63927d.equals(tVar.f63927d) || !this.f63931h.equals(tVar.f63931h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((this.f63926c.hashCode() * 31) + this.f63927d.hashCode()) * 31) + this.f63928e) * 31) + this.f63929f;
        g<?> gVar = this.f63932i;
        if (gVar != null) {
            hashCode = (hashCode * 31) + gVar.hashCode();
        }
        return (((hashCode * 31) + this.f63930g.hashCode()) * 31) + this.f63931h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f63926c + ", signature=" + this.f63927d + ", width=" + this.f63928e + ", height=" + this.f63929f + ", decodedResourceClass=" + this.f63930g + ", transformation='" + this.f63932i + '\'' + ", options=" + this.f63931h + '}';
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f63925b.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f63928e).putInt(this.f63929f).array();
        this.f63927d.updateDiskCacheKey(messageDigest);
        this.f63926c.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        g<?> gVar = this.f63932i;
        if (gVar != null) {
            gVar.updateDiskCacheKey(messageDigest);
        }
        this.f63931h.updateDiskCacheKey(messageDigest);
        messageDigest.update(a());
        this.f63925b.put(bArr);
    }
}
