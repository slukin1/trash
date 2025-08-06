package com.bumptech.glide.load.model;

import android.net.Uri;
import com.adjust.sdk.Constants;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import s3.a;
import s3.d;

public class UrlUriLoader<Data> implements d<Uri, Data> {

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f63979b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", Constants.SCHEME})));

    /* renamed from: a  reason: collision with root package name */
    public final d<a, Data> f63980a;

    public static class StreamFactory implements d<Uri, InputStream> {
        public d<Uri, InputStream> b(f fVar) {
            return new UrlUriLoader(fVar.d(a.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public UrlUriLoader(d<a, Data> dVar) {
        this.f63980a = dVar;
    }

    /* renamed from: c */
    public d.a<Data> a(Uri uri, int i11, int i12, Options options) {
        return this.f63980a.a(new a(uri.toString()), i11, i12, options);
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return f63979b.contains(uri.getScheme());
    }
}
