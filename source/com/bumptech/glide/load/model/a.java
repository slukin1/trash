package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import java.io.InputStream;
import o3.d;
import o3.f;
import o3.j;

public class a<Data> implements d<Uri, Data> {

    /* renamed from: c  reason: collision with root package name */
    public static final int f63981c = 22;

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f63982a;

    /* renamed from: b  reason: collision with root package name */
    public final C0704a<Data> f63983b;

    /* renamed from: com.bumptech.glide.load.model.a$a  reason: collision with other inner class name */
    public interface C0704a<Data> {
        d<Data> a(AssetManager assetManager, String str);
    }

    public static class b implements s3.d<Uri, ParcelFileDescriptor>, C0704a<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f63984a;

        public b(AssetManager assetManager) {
            this.f63984a = assetManager;
        }

        public d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new f(assetManager, str);
        }

        public d<Uri, ParcelFileDescriptor> b(f fVar) {
            return new a(this.f63984a, this);
        }

        public void teardown() {
        }
    }

    public static class c implements s3.d<Uri, InputStream>, C0704a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f63985a;

        public c(AssetManager assetManager) {
            this.f63985a = assetManager;
        }

        public d<InputStream> a(AssetManager assetManager, String str) {
            return new j(assetManager, str);
        }

        public d<Uri, InputStream> b(f fVar) {
            return new a(this.f63985a, this);
        }

        public void teardown() {
        }
    }

    public a(AssetManager assetManager, C0704a<Data> aVar) {
        this.f63982a = assetManager;
        this.f63983b = aVar;
    }

    /* renamed from: c */
    public d.a<Data> a(Uri uri, int i11, int i12, Options options) {
        return new d.a<>(new e4.d(uri), this.f63983b.a(this.f63982a, uri.toString().substring(f63981c)));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }
}
