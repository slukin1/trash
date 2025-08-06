package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import com.bumptech.glide.load.model.f;
import java.io.InputStream;
import java.net.URL;
import s3.a;

public class UrlLoader implements d<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final d<a, InputStream> f64030a;

    public static class StreamFactory implements s3.d<URL, InputStream> {
        public d<URL, InputStream> b(f fVar) {
            return new UrlLoader(fVar.d(a.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public UrlLoader(d<a, InputStream> dVar) {
        this.f64030a = dVar;
    }

    /* renamed from: c */
    public d.a<InputStream> a(URL url, int i11, int i12, Options options) {
        return this.f64030a.a(new a(url), i11, i12, options);
    }

    /* renamed from: d */
    public boolean b(URL url) {
        return true;
    }
}
