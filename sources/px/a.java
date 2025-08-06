package px;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.io.InputStream;
import ox.c;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f29165a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final c f29168a;

        /* renamed from: b  reason: collision with root package name */
        public final C0257a f29169b;

        public b(c cVar, C0257a aVar) {
            this.f29168a = cVar;
            this.f29169b = aVar;
        }
    }

    public a(boolean z11) {
        this.f29165a = z11;
    }

    public Bitmap a(c cVar) throws IOException {
        InputStream f11 = f(cVar);
        if (f11 == null) {
            vx.c.b("No stream for image [%s]", cVar.g());
            return null;
        }
        try {
            b e11 = e(f11, cVar);
            f11 = h(f11, cVar);
            Bitmap decodeStream = BitmapFactory.decodeStream(f11, (Rect) null, g(e11.f29168a, cVar));
            if (decodeStream == null) {
                vx.c.b("Image can't be decoded [%s]", cVar.g());
                return decodeStream;
            }
            C0257a aVar = e11.f29169b;
            return c(decodeStream, cVar, aVar.f29166a, aVar.f29167b);
        } finally {
            vx.b.a(f11);
        }
    }

    public final boolean b(String str, String str2) {
        return "image/jpeg".equalsIgnoreCase(str2) && ImageDownloader.Scheme.ofUri(str) == ImageDownloader.Scheme.FILE;
    }

    public Bitmap c(Bitmap bitmap, c cVar, int i11, boolean z11) {
        Matrix matrix = new Matrix();
        ImageScaleType h11 = cVar.h();
        if (h11 == ImageScaleType.EXACTLY || h11 == ImageScaleType.EXACTLY_STRETCHED) {
            c cVar2 = new c(bitmap.getWidth(), bitmap.getHeight(), i11);
            float b11 = vx.a.b(cVar2, cVar.j(), cVar.k(), h11 == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(b11, 1.0f) != 0) {
                matrix.setScale(b11, b11);
                if (this.f29165a) {
                    vx.c.a("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", cVar2, cVar2.c(b11), Float.valueOf(b11), cVar.g());
                }
            }
        }
        if (z11) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.f29165a) {
                vx.c.a("Flip image horizontally [%s]", cVar.g());
            }
        }
        if (i11 != 0) {
            matrix.postRotate((float) i11);
            if (this.f29165a) {
                vx.c.a("Rotate image on %1$d° [%2$s]", Integer.valueOf(i11), cVar.g());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: int} */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r1 = r0;
        r0 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        r5 = 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        r5 = 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r5 = 180;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public px.a.C0257a d(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            android.media.ExifInterface r2 = new android.media.ExifInterface     // Catch:{ IOException -> 0x0025 }
            com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r3 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE     // Catch:{ IOException -> 0x0025 }
            java.lang.String r3 = r3.crop(r5)     // Catch:{ IOException -> 0x0025 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0025 }
            java.lang.String r3 = "Orientation"
            int r5 = r2.getAttributeInt(r3, r1)     // Catch:{ IOException -> 0x0025 }
            switch(r5) {
                case 1: goto L_0x002e;
                case 2: goto L_0x002f;
                case 3: goto L_0x0020;
                case 4: goto L_0x001f;
                case 5: goto L_0x001b;
                case 6: goto L_0x0018;
                case 7: goto L_0x0017;
                case 8: goto L_0x001c;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x002e
        L_0x0017:
            r0 = r1
        L_0x0018:
            r5 = 90
            goto L_0x0022
        L_0x001b:
            r0 = r1
        L_0x001c:
            r5 = 270(0x10e, float:3.78E-43)
            goto L_0x0022
        L_0x001f:
            r0 = r1
        L_0x0020:
            r5 = 180(0xb4, float:2.52E-43)
        L_0x0022:
            r1 = r0
            r0 = r5
            goto L_0x002f
        L_0x0025:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r5
            java.lang.String r5 = "Can't read EXIF tags from file [%s]"
            vx.c.f(r5, r1)
        L_0x002e:
            r1 = r0
        L_0x002f:
            px.a$a r5 = new px.a$a
            r5.<init>(r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: px.a.d(java.lang.String):px.a$a");
    }

    public b e(InputStream inputStream, c cVar) throws IOException {
        C0257a aVar;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, (Rect) null, options);
        String i11 = cVar.i();
        if (!cVar.l() || !b(i11, options.outMimeType)) {
            aVar = new C0257a();
        } else {
            aVar = d(i11);
        }
        return new b(new c(options.outWidth, options.outHeight, aVar.f29166a), aVar);
    }

    public InputStream f(c cVar) throws IOException {
        return cVar.e().a(cVar.i(), cVar.f());
    }

    public BitmapFactory.Options g(c cVar, c cVar2) {
        int i11;
        ImageScaleType h11 = cVar2.h();
        if (h11 == ImageScaleType.NONE) {
            i11 = 1;
        } else if (h11 == ImageScaleType.NONE_SAFE) {
            i11 = vx.a.c(cVar);
        } else {
            i11 = vx.a.a(cVar, cVar2.j(), cVar2.k(), h11 == ImageScaleType.IN_SAMPLE_POWER_OF_2);
        }
        if (i11 > 1 && this.f29165a) {
            vx.c.a("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", cVar, cVar.d(i11), Integer.valueOf(i11), cVar2.g());
        }
        BitmapFactory.Options d11 = cVar2.d();
        d11.inSampleSize = i11;
        return d11;
    }

    public InputStream h(InputStream inputStream, c cVar) throws IOException {
        if (inputStream.markSupported()) {
            try {
                inputStream.reset();
                return inputStream;
            } catch (IOException unused) {
            }
        }
        vx.b.a(inputStream);
        return f(cVar);
    }

    /* renamed from: px.a$a  reason: collision with other inner class name */
    public static class C0257a {

        /* renamed from: a  reason: collision with root package name */
        public final int f29166a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f29167b;

        public C0257a() {
            this.f29166a = 0;
            this.f29167b = false;
        }

        public C0257a(int i11, boolean z11) {
            this.f29166a = i11;
            this.f29167b = z11;
        }
    }
}
