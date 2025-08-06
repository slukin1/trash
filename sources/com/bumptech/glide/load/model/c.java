package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import java.io.File;
import java.io.FileNotFoundException;
import o3.d;
import s3.d;

public final class c implements d<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f63988a;

    public static final class a implements d<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f63989a;

        public a(Context context) {
            this.f63989a = context;
        }

        public d<Uri, File> b(f fVar) {
            return new c(this.f63989a);
        }

        public void teardown() {
        }
    }

    public static class b implements o3.d<File> {

        /* renamed from: d  reason: collision with root package name */
        public static final String[] f63990d = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        public final Context f63991b;

        /* renamed from: c  reason: collision with root package name */
        public final Uri f63992c;

        public b(Context context, Uri uri) {
            this.f63991b = context;
            this.f63992c = uri;
        }

        public Class<File> a() {
            return File.class;
        }

        public void b() {
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
        }

        public void f(Priority priority, d.a<? super File> aVar) {
            Cursor query = this.f63991b.getContentResolver().query(this.f63992c, f63990d, (String) null, (String[]) null, (String) null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.e(new FileNotFoundException("Failed to find file path for: " + this.f63992c));
                return;
            }
            aVar.d(new File(str));
        }
    }

    public c(Context context) {
        this.f63988a = context;
    }

    /* renamed from: c */
    public d.a<File> a(Uri uri, int i11, int i12, Options options) {
        return new d.a<>(new e4.d(uri), new b(this.f63988a, uri));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return p3.b.b(uri);
    }
}
