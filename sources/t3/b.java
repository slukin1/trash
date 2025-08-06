package t3;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import com.bumptech.glide.load.model.f;
import com.bumptech.glide.load.resource.bitmap.p;
import java.io.InputStream;
import p3.c;

public class b implements d<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f66634a;

    public static class a implements s3.d<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f66635a;

        public a(Context context) {
            this.f66635a = context;
        }

        public d<Uri, InputStream> b(f fVar) {
            return new b(this.f66635a);
        }

        public void teardown() {
        }
    }

    public b(Context context) {
        this.f66634a = context.getApplicationContext();
    }

    /* renamed from: c */
    public d.a<InputStream> a(Uri uri, int i11, int i12, Options options) {
        if (!p3.b.d(i11, i12) || !e(options)) {
            return null;
        }
        return new d.a<>(new e4.d(uri), c.g(this.f66634a, uri));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return p3.b.c(uri);
    }

    public final boolean e(Options options) {
        Long l11 = (Long) options.a(p.f64125d);
        return l11 != null && l11.longValue() == -1;
    }
}
