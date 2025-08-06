package p3;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import o3.d;
import o3.e;

public class c implements d<InputStream> {

    /* renamed from: b  reason: collision with root package name */
    public final Uri f66543b;

    /* renamed from: c  reason: collision with root package name */
    public final e f66544c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f66545d;

    public static class a implements d {

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f66546b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f66547a;

        public a(ContentResolver contentResolver) {
            this.f66547a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f66547a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f66546b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    public static class b implements d {

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f66548b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f66549a;

        public b(ContentResolver contentResolver) {
            this.f66549a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f66549a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f66548b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    public c(Uri uri, e eVar) {
        this.f66543b = uri;
        this.f66544c = eVar;
    }

    public static c d(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.a.d(context).k().g(), dVar, com.bumptech.glide.a.d(context).f(), context.getContentResolver()));
    }

    public static c e(Context context, Uri uri) {
        return d(context, uri, new a(context.getContentResolver()));
    }

    public static c g(Context context, Uri uri) {
        return d(context, uri, new b(context.getContentResolver()));
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        InputStream inputStream = this.f66545d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public DataSource c() {
        return DataSource.LOCAL;
    }

    public void cancel() {
    }

    public void f(Priority priority, d.a<? super InputStream> aVar) {
        try {
            InputStream h11 = h();
            this.f66545d = h11;
            aVar.d(h11);
        } catch (FileNotFoundException e11) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e11);
            }
            aVar.e(e11);
        }
    }

    public final InputStream h() throws FileNotFoundException {
        InputStream d11 = this.f66544c.d(this.f66543b);
        int a11 = d11 != null ? this.f66544c.a(this.f66543b) : -1;
        return a11 != -1 ? new e(d11, a11) : d11;
    }
}
