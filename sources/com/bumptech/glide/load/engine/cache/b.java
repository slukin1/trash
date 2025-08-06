package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.a;
import java.io.File;

public class b implements a.C0702a {

    /* renamed from: a  reason: collision with root package name */
    public final long f63791a;

    /* renamed from: b  reason: collision with root package name */
    public final a f63792b;

    public interface a {
        File a();
    }

    public b(a aVar, long j11) {
        this.f63791a = j11;
        this.f63792b = aVar;
    }

    public a build() {
        File a11 = this.f63792b.a();
        if (a11 == null) {
            return null;
        }
        if (a11.mkdirs() || (a11.exists() && a11.isDirectory())) {
            return c.c(a11, this.f63791a);
        }
        return null;
    }
}
