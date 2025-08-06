package com.bumptech.glide.load.model.stream;

import android.net.Uri;
import com.adjust.sdk.Constants;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import com.bumptech.glide.load.model.f;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import s3.a;

public class HttpUriLoader implements d<Uri, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f64028b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", Constants.SCHEME})));

    /* renamed from: a  reason: collision with root package name */
    public final d<a, InputStream> f64029a;

    public static class Factory implements s3.d<Uri, InputStream> {
        public d<Uri, InputStream> b(f fVar) {
            return new HttpUriLoader(fVar.d(a.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public HttpUriLoader(d<a, InputStream> dVar) {
        this.f64029a = dVar;
    }

    /* renamed from: c */
    public d.a<InputStream> a(Uri uri, int i11, int i12, Options options) {
        return this.f64029a.a(new a(uri.toString()), i11, i12, options);
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return f64028b.contains(uri.getScheme());
    }
}
