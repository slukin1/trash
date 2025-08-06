package t3;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import com.bumptech.glide.load.model.f;
import java.io.InputStream;
import p3.b;
import p3.c;

public class a implements d<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f66632a;

    /* renamed from: t3.a$a  reason: collision with other inner class name */
    public static class C0730a implements s3.d<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f66633a;

        public C0730a(Context context) {
            this.f66633a = context;
        }

        public d<Uri, InputStream> b(f fVar) {
            return new a(this.f66633a);
        }

        public void teardown() {
        }
    }

    public a(Context context) {
        this.f66632a = context.getApplicationContext();
    }

    /* renamed from: c */
    public d.a<InputStream> a(Uri uri, int i11, int i12, Options options) {
        if (b.d(i11, i12)) {
            return new d.a<>(new e4.d(uri), c.e(this.f66632a, uri));
        }
        return null;
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return b.a(uri);
    }
}
