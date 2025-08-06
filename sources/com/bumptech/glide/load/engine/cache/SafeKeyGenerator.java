package com.bumptech.glide.load.engine.cache;

import androidx.core.util.e;
import f4.f;
import f4.h;
import f4.i;
import g4.a;
import g4.c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SafeKeyGenerator {

    /* renamed from: a  reason: collision with root package name */
    public final f<n3.b, String> f63786a = new f<>(1000);

    /* renamed from: b  reason: collision with root package name */
    public final e<b> f63787b = g4.a.d(10, new a());

    public class a implements a.d<b> {
        public a() {
        }

        /* renamed from: a */
        public b create() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    public static final class b implements a.f {

        /* renamed from: b  reason: collision with root package name */
        public final MessageDigest f63789b;

        /* renamed from: c  reason: collision with root package name */
        public final c f63790c = c.a();

        public b(MessageDigest messageDigest) {
            this.f63789b = messageDigest;
        }

        public c e() {
            return this.f63790c;
        }
    }

    public final String a(n3.b bVar) {
        b bVar2 = (b) h.d(this.f63787b.acquire());
        try {
            bVar.updateDiskCacheKey(bVar2.f63789b);
            return i.u(bVar2.f63789b.digest());
        } finally {
            this.f63787b.release(bVar2);
        }
    }

    public String b(n3.b bVar) {
        String g11;
        synchronized (this.f63786a) {
            g11 = this.f63786a.g(bVar);
        }
        if (g11 == null) {
            g11 = a(bVar);
        }
        synchronized (this.f63786a) {
            this.f63786a.k(bVar, g11);
        }
        return g11;
    }
}
