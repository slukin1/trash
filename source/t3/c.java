package t3;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import com.bumptech.glide.load.model.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import o3.d;

public final class c<DataT> implements com.bumptech.glide.load.model.d<Uri, DataT> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f66636a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bumptech.glide.load.model.d<File, DataT> f66637b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bumptech.glide.load.model.d<Uri, DataT> f66638c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<DataT> f66639d;

    public static abstract class a<DataT> implements s3.d<Uri, DataT> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f66640a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<DataT> f66641b;

        public a(Context context, Class<DataT> cls) {
            this.f66640a = context;
            this.f66641b = cls;
        }

        public final com.bumptech.glide.load.model.d<Uri, DataT> b(f fVar) {
            return new c(this.f66640a, fVar.d(File.class, this.f66641b), fVar.d(Uri.class, this.f66641b), this.f66641b);
        }

        public final void teardown() {
        }
    }

    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* renamed from: t3.c$c  reason: collision with other inner class name */
    public static final class C0731c extends a<InputStream> {
        public C0731c(Context context) {
            super(context, InputStream.class);
        }
    }

    public static final class d<DataT> implements o3.d<DataT> {

        /* renamed from: l  reason: collision with root package name */
        public static final String[] f66642l = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        public final Context f66643b;

        /* renamed from: c  reason: collision with root package name */
        public final com.bumptech.glide.load.model.d<File, DataT> f66644c;

        /* renamed from: d  reason: collision with root package name */
        public final com.bumptech.glide.load.model.d<Uri, DataT> f66645d;

        /* renamed from: e  reason: collision with root package name */
        public final Uri f66646e;

        /* renamed from: f  reason: collision with root package name */
        public final int f66647f;

        /* renamed from: g  reason: collision with root package name */
        public final int f66648g;

        /* renamed from: h  reason: collision with root package name */
        public final Options f66649h;

        /* renamed from: i  reason: collision with root package name */
        public final Class<DataT> f66650i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f66651j;

        /* renamed from: k  reason: collision with root package name */
        public volatile o3.d<DataT> f66652k;

        public d(Context context, com.bumptech.glide.load.model.d<File, DataT> dVar, com.bumptech.glide.load.model.d<Uri, DataT> dVar2, Uri uri, int i11, int i12, Options options, Class<DataT> cls) {
            this.f66643b = context.getApplicationContext();
            this.f66644c = dVar;
            this.f66645d = dVar2;
            this.f66646e = uri;
            this.f66647f = i11;
            this.f66648g = i12;
            this.f66649h = options;
            this.f66650i = cls;
        }

        public Class<DataT> a() {
            return this.f66650i;
        }

        public void b() {
            o3.d<DataT> dVar = this.f66652k;
            if (dVar != null) {
                dVar.b();
            }
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
            this.f66651j = true;
            o3.d<DataT> dVar = this.f66652k;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        public final d.a<DataT> d() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.f66644c.a(h(this.f66646e), this.f66647f, this.f66648g, this.f66649h);
            }
            return this.f66645d.a(g() ? MediaStore.setRequireOriginal(this.f66646e) : this.f66646e, this.f66647f, this.f66648g, this.f66649h);
        }

        public final o3.d<DataT> e() throws FileNotFoundException {
            d.a d11 = d();
            if (d11 != null) {
                return d11.f63995c;
            }
            return null;
        }

        public void f(Priority priority, d.a<? super DataT> aVar) {
            try {
                o3.d<DataT> e11 = e();
                if (e11 == null) {
                    aVar.e(new IllegalArgumentException("Failed to build fetcher for: " + this.f66646e));
                    return;
                }
                this.f66652k = e11;
                if (this.f66651j) {
                    cancel();
                } else {
                    e11.f(priority, aVar);
                }
            } catch (FileNotFoundException e12) {
                aVar.e(e12);
            }
        }

        public final boolean g() {
            return this.f66643b.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        public final File h(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                cursor = this.f66643b.getContentResolver().query(uri, f66642l, (String) null, (String[]) null, (String) null);
                if (cursor == null || !cursor.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    cursor.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }
    }

    public c(Context context, com.bumptech.glide.load.model.d<File, DataT> dVar, com.bumptech.glide.load.model.d<Uri, DataT> dVar2, Class<DataT> cls) {
        this.f66636a = context.getApplicationContext();
        this.f66637b = dVar;
        this.f66638c = dVar2;
        this.f66639d = cls;
    }

    /* renamed from: c */
    public d.a<DataT> a(Uri uri, int i11, int i12, Options options) {
        return new d.a<>(new e4.d(uri), new d(this.f66636a, this.f66637b, this.f66638c, uri, i11, i12, options, this.f66639d));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && p3.b.b(uri);
    }
}
