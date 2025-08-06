package com.bumptech.glide.integration.okhttp3;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import com.bumptech.glide.load.model.f;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import s3.a;

public class OkHttpUrlLoader implements d<a, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final Call.Factory f63654a;

    public static class Factory implements s3.d<a, InputStream> {

        /* renamed from: b  reason: collision with root package name */
        public static volatile Call.Factory f63655b;

        /* renamed from: a  reason: collision with root package name */
        public final Call.Factory f63656a;

        public Factory() {
            this(a());
        }

        public static Call.Factory a() {
            if (f63655b == null) {
                synchronized (Factory.class) {
                    if (f63655b == null) {
                        f63655b = new OkHttpClient();
                    }
                }
            }
            return f63655b;
        }

        public d<a, InputStream> b(f fVar) {
            return new OkHttpUrlLoader(this.f63656a);
        }

        public void teardown() {
        }

        public Factory(Call.Factory factory) {
            this.f63656a = factory;
        }
    }

    public OkHttpUrlLoader(Call.Factory factory) {
        this.f63654a = factory;
    }

    /* renamed from: c */
    public d.a<InputStream> a(a aVar, int i11, int i12, Options options) {
        return new d.a<>(aVar, new m3.a(this.f63654a, aVar));
    }

    /* renamed from: d */
    public boolean b(a aVar) {
        return true;
    }
}
