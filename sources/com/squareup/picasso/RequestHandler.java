package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import okio.Source;

public abstract class RequestHandler {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Picasso.LoadedFrom f29982a;

        /* renamed from: b  reason: collision with root package name */
        public final Bitmap f29983b;

        /* renamed from: c  reason: collision with root package name */
        public final Source f29984c;

        /* renamed from: d  reason: collision with root package name */
        public final int f29985d;

        public a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
            this((Bitmap) y.d(bitmap, "bitmap == null"), (Source) null, loadedFrom, 0);
        }

        public Bitmap a() {
            return this.f29983b;
        }

        public int b() {
            return this.f29985d;
        }

        public Picasso.LoadedFrom c() {
            return this.f29982a;
        }

        public Source d() {
            return this.f29984c;
        }

        public a(Source source, Picasso.LoadedFrom loadedFrom) {
            this((Bitmap) null, (Source) y.d(source, "source == null"), loadedFrom, 0);
        }

        public a(Bitmap bitmap, Source source, Picasso.LoadedFrom loadedFrom, int i11) {
            if ((bitmap != null) != (source == null ? false : true)) {
                this.f29983b = bitmap;
                this.f29984c = source;
                this.f29982a = (Picasso.LoadedFrom) y.d(loadedFrom, "loadedFrom == null");
                this.f29985d = i11;
                return;
            }
            throw new AssertionError();
        }
    }

    public static void a(int i11, int i12, int i13, int i14, BitmapFactory.Options options, q qVar) {
        int i15;
        double floor;
        if (i14 > i12 || i13 > i11) {
            if (i12 == 0) {
                floor = Math.floor((double) (((float) i13) / ((float) i11)));
            } else if (i11 == 0) {
                floor = Math.floor((double) (((float) i14) / ((float) i12)));
            } else {
                int floor2 = (int) Math.floor((double) (((float) i14) / ((float) i12)));
                int floor3 = (int) Math.floor((double) (((float) i13) / ((float) i11)));
                i15 = qVar.f30093l ? Math.max(floor2, floor3) : Math.min(floor2, floor3);
            }
            i15 = (int) floor;
        } else {
            i15 = 1;
        }
        options.inSampleSize = i15;
        options.inJustDecodeBounds = false;
    }

    public static void b(int i11, int i12, BitmapFactory.Options options, q qVar) {
        a(i11, i12, options.outWidth, options.outHeight, options, qVar);
    }

    public static BitmapFactory.Options d(q qVar) {
        boolean c11 = qVar.c();
        boolean z11 = qVar.f30100s != null;
        BitmapFactory.Options options = null;
        if (c11 || z11 || qVar.f30099r) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = c11;
            boolean z12 = qVar.f30099r;
            options.inInputShareable = z12;
            options.inPurgeable = z12;
            if (z11) {
                options.inPreferredConfig = qVar.f30100s;
            }
        }
        return options;
    }

    public static boolean g(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    public abstract boolean c(q qVar);

    public int e() {
        return 0;
    }

    public abstract a f(q qVar, int i11) throws IOException;

    public boolean h(boolean z11, NetworkInfo networkInfo) {
        return false;
    }

    public boolean i() {
        return false;
    }
}
