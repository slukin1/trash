package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.load.engine.cache.a;
import java.io.File;
import java.io.IOException;
import k3.a;
import n3.b;
import q3.a;

public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final SafeKeyGenerator f63793a;

    /* renamed from: b  reason: collision with root package name */
    public final File f63794b;

    /* renamed from: c  reason: collision with root package name */
    public final long f63795c;

    /* renamed from: d  reason: collision with root package name */
    public final a f63796d = new a();

    /* renamed from: e  reason: collision with root package name */
    public k3.a f63797e;

    @Deprecated
    public c(File file, long j11) {
        this.f63794b = file;
        this.f63795c = j11;
        this.f63793a = new SafeKeyGenerator();
    }

    public static a c(File file, long j11) {
        return new c(file, j11);
    }

    public File a(b bVar) {
        String b11 = this.f63793a.b(bVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b11 + " for for Key: " + bVar);
        }
        try {
            a.e v11 = d().v(b11);
            if (v11 != null) {
                return v11.a(0);
            }
            return null;
        } catch (IOException e11) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e11);
            return null;
        }
    }

    public void b(b bVar, a.b bVar2) {
        a.c s11;
        String b11 = this.f63793a.b(bVar);
        this.f63796d.a(b11);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b11 + " for for Key: " + bVar);
            }
            try {
                k3.a d11 = d();
                if (d11.v(b11) == null) {
                    s11 = d11.s(b11);
                    if (s11 != null) {
                        if (bVar2.a(s11.f(0))) {
                            s11.e();
                        }
                        s11.b();
                        this.f63796d.b(b11);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + b11);
                }
            } catch (IOException e11) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e11);
                }
            } catch (Throwable th2) {
                s11.b();
                throw th2;
            }
        } finally {
            this.f63796d.b(b11);
        }
    }

    public synchronized void clear() {
        try {
            d().p();
        } catch (IOException e11) {
            try {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to clear disk cache or disk cache cleared externally", e11);
                }
            } catch (Throwable th2) {
                e();
                throw th2;
            }
        }
        e();
    }

    public final synchronized k3.a d() throws IOException {
        if (this.f63797e == null) {
            this.f63797e = k3.a.x(this.f63794b, 1, 1, this.f63795c);
        }
        return this.f63797e;
    }

    public final synchronized void e() {
        this.f63797e = null;
    }
}
