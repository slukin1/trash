package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import java.io.File;
import java.io.InputStream;
import s3.d;

public class StringLoader<Data> implements d<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final d<Uri, Data> f63975a;

    public static final class AssetFileDescriptorFactory implements d<String, AssetFileDescriptor> {
        public d<String, AssetFileDescriptor> b(f fVar) {
            return new StringLoader(fVar.d(Uri.class, AssetFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class FileDescriptorFactory implements d<String, ParcelFileDescriptor> {
        public d<String, ParcelFileDescriptor> b(f fVar) {
            return new StringLoader(fVar.d(Uri.class, ParcelFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class StreamFactory implements d<String, InputStream> {
        public d<String, InputStream> b(f fVar) {
            return new StringLoader(fVar.d(Uri.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public StringLoader(d<Uri, Data> dVar) {
        this.f63975a = dVar;
    }

    public static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? f(str) : parse;
    }

    public static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    /* renamed from: c */
    public d.a<Data> a(String str, int i11, int i12, Options options) {
        Uri e11 = e(str);
        if (e11 == null || !this.f63975a.b(e11)) {
            return null;
        }
        return this.f63975a.a(e11, i11, i12, options);
    }

    /* renamed from: d */
    public boolean b(String str) {
        return true;
    }
}
