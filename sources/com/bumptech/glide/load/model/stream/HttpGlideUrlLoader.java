package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.d;
import com.bumptech.glide.load.model.f;
import com.google.android.exoplayer2.DefaultLoadControl;
import java.io.InputStream;
import o3.h;
import s3.a;

public class HttpGlideUrlLoader implements d<a, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    public static final n3.d<Integer> f64025b = n3.d.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS));

    /* renamed from: a  reason: collision with root package name */
    public final ModelCache<a, a> f64026a;

    public static class Factory implements s3.d<a, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final ModelCache<a, a> f64027a = new ModelCache<>(500);

        public d<a, InputStream> b(f fVar) {
            return new HttpGlideUrlLoader(this.f64027a);
        }

        public void teardown() {
        }
    }

    public HttpGlideUrlLoader() {
        this((ModelCache<a, a>) null);
    }

    /* renamed from: c */
    public d.a<InputStream> a(a aVar, int i11, int i12, Options options) {
        ModelCache<a, a> modelCache = this.f64026a;
        if (modelCache != null) {
            a a11 = modelCache.a(aVar, 0, 0);
            if (a11 == null) {
                this.f64026a.b(aVar, 0, 0, aVar);
            } else {
                aVar = a11;
            }
        }
        return new d.a<>(aVar, new h(aVar, ((Integer) options.a(f64025b)).intValue()));
    }

    /* renamed from: d */
    public boolean b(a aVar) {
        return true;
    }

    public HttpGlideUrlLoader(ModelCache<a, a> modelCache) {
        this.f64026a = modelCache;
    }
}
