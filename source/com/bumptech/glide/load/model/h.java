package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import o3.g;
import o3.k;

public class h<Data> implements d<Uri, Data> {

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f64020b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", "content"})));

    /* renamed from: a  reason: collision with root package name */
    public final c<Data> f64021a;

    public static final class a implements s3.d<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f64022a;

        public a(ContentResolver contentResolver) {
            this.f64022a = contentResolver;
        }

        public o3.d<AssetFileDescriptor> a(Uri uri) {
            return new o3.a(this.f64022a, uri);
        }

        public d<Uri, AssetFileDescriptor> b(f fVar) {
            return new h(this);
        }

        public void teardown() {
        }
    }

    public static class b implements s3.d<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f64023a;

        public b(ContentResolver contentResolver) {
            this.f64023a = contentResolver;
        }

        public o3.d<ParcelFileDescriptor> a(Uri uri) {
            return new g(this.f64023a, uri);
        }

        public d<Uri, ParcelFileDescriptor> b(f fVar) {
            return new h(this);
        }

        public void teardown() {
        }
    }

    public interface c<Data> {
        o3.d<Data> a(Uri uri);
    }

    public static class d implements s3.d<Uri, InputStream>, c<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f64024a;

        public d(ContentResolver contentResolver) {
            this.f64024a = contentResolver;
        }

        public o3.d<InputStream> a(Uri uri) {
            return new k(this.f64024a, uri);
        }

        public d<Uri, InputStream> b(f fVar) {
            return new h(this);
        }

        public void teardown() {
        }
    }

    public h(c<Data> cVar) {
        this.f64021a = cVar;
    }

    /* renamed from: c */
    public d.a<Data> a(Uri uri, int i11, int i12, Options options) {
        return new d.a<>(new e4.d(uri), this.f64021a.a(uri));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return f64020b.contains(uri.getScheme());
    }
}
