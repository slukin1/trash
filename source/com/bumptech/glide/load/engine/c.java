package com.bumptech.glide.load.engine;

import java.security.MessageDigest;
import n3.b;

public final class c implements b {

    /* renamed from: b  reason: collision with root package name */
    public final b f63783b;

    /* renamed from: c  reason: collision with root package name */
    public final b f63784c;

    public c(b bVar, b bVar2) {
        this.f63783b = bVar;
        this.f63784c = bVar2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f63783b.equals(cVar.f63783b) || !this.f63784c.equals(cVar.f63784c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f63783b.hashCode() * 31) + this.f63784c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f63783b + ", signature=" + this.f63784c + '}';
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f63783b.updateDiskCacheKey(messageDigest);
        this.f63784c.updateDiskCacheKey(messageDigest);
    }
}
