package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.core.util.h;
import java.util.concurrent.Executor;
import t0.g;
import y0.c;

public class FontsContractCompat {

    public static final class Columns implements BaseColumns {
    }

    public static class FontRequestCallback {
        public void a(int i11) {
        }

        public void b(Typeface typeface) {
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f8419a;

        /* renamed from: b  reason: collision with root package name */
        public final b[] f8420b;

        @Deprecated
        public a(int i11, b[] bVarArr) {
            this.f8419a = i11;
            this.f8420b = bVarArr;
        }

        public static a a(int i11, b[] bVarArr) {
            return new a(i11, bVarArr);
        }

        public b[] b() {
            return this.f8420b;
        }

        public int c() {
            return this.f8419a;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f8421a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8422b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8423c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f8424d;

        /* renamed from: e  reason: collision with root package name */
        public final int f8425e;

        @Deprecated
        public b(Uri uri, int i11, int i12, boolean z11, int i13) {
            this.f8421a = (Uri) h.g(uri);
            this.f8422b = i11;
            this.f8423c = i12;
            this.f8424d = z11;
            this.f8425e = i13;
        }

        public static b a(Uri uri, int i11, int i12, boolean z11, int i13) {
            return new b(uri, i11, i12, z11, i13);
        }

        public int b() {
            return this.f8425e;
        }

        public int c() {
            return this.f8422b;
        }

        public Uri d() {
            return this.f8421a;
        }

        public int e() {
            return this.f8423c;
        }

        public boolean f() {
            return this.f8424d;
        }
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return g.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, c cVar) throws PackageManager.NameNotFoundException {
        return b.e(context, cVar, cancellationSignal);
    }

    public static Typeface c(Context context, c cVar, int i11, boolean z11, int i12, Handler handler, FontRequestCallback fontRequestCallback) {
        a aVar = new a(fontRequestCallback, handler);
        if (z11) {
            return c.e(context, cVar, aVar, i11, i12);
        }
        return c.d(context, cVar, i11, (Executor) null, aVar);
    }
}
