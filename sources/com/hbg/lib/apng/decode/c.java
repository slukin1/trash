package com.hbg.lib.apng.decode;

import com.google.common.base.Ascii;
import com.hbg.lib.apng.io.APNGWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import net.sf.scuba.smartcards.ISO7816;
import org.jmrtd.lds.CVCAFile;
import z5.a;

public class c extends g<a, APNGWriter> {

    /* renamed from: l  reason: collision with root package name */
    public static final byte[] f66178l = {-119, 80, 78, 71, 13, 10, Ascii.SUB, 10};

    /* renamed from: m  reason: collision with root package name */
    public static final byte[] f66179m = {0, 0, 0, 0, 73, 69, 78, ISO7816.INS_REHABILITATE_CHV, -82, CVCAFile.CAR_TAG, 96, -126};

    /* renamed from: n  reason: collision with root package name */
    public static ThreadLocal<CRC32> f66180n = new ThreadLocal<>();

    /* renamed from: g  reason: collision with root package name */
    public final byte f66181g;

    /* renamed from: h  reason: collision with root package name */
    public final byte f66182h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f66183i;

    /* renamed from: j  reason: collision with root package name */
    public List<d> f66184j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public List<d> f66185k = new ArrayList();

    public c(a aVar, e eVar) {
        super(aVar);
        this.f66181g = eVar.f66199m;
        this.f66182h = eVar.f66198l;
        int i11 = eVar.f66196j * 1000;
        short s11 = eVar.f66197k;
        int i12 = i11 / (s11 == 0 ? 100 : s11);
        this.f66207f = i12;
        if (i12 < 10) {
            this.f66207f = 100;
        }
        this.f66203b = eVar.f66192f;
        this.f66204c = eVar.f66193g;
        this.f66205d = eVar.f66194h;
        this.f66206e = eVar.f66195i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r9 = new android.graphics.BitmapFactory.Options();
        r9.inJustDecodeBounds = false;
        r9.inSampleSize = r7;
        r9.inMutable = true;
        r8 = android.graphics.BitmapFactory.decodeByteArray(r8, 0, r0, r9);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001c */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap a(android.graphics.Canvas r5, android.graphics.Paint r6, int r7, android.graphics.Bitmap r8, com.hbg.lib.apng.io.APNGWriter r9) {
        /*
            r4 = this;
            int r0 = r4.c(r9)     // Catch:{ IOException -> 0x0038 }
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x0038 }
            r1.<init>()     // Catch:{ IOException -> 0x0038 }
            r2 = 0
            r1.inJustDecodeBounds = r2     // Catch:{ IOException -> 0x0038 }
            r1.inSampleSize = r7     // Catch:{ IOException -> 0x0038 }
            r3 = 1
            r1.inMutable = r3     // Catch:{ IOException -> 0x0038 }
            r1.inBitmap = r8     // Catch:{ IOException -> 0x0038 }
            byte[] r8 = r9.f()     // Catch:{ IOException -> 0x0038 }
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeByteArray(r8, r2, r0, r1)     // Catch:{ IllegalArgumentException -> 0x001c }
            goto L_0x002b
        L_0x001c:
            android.graphics.BitmapFactory$Options r9 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x0038 }
            r9.<init>()     // Catch:{ IOException -> 0x0038 }
            r9.inJustDecodeBounds = r2     // Catch:{ IOException -> 0x0038 }
            r9.inSampleSize = r7     // Catch:{ IOException -> 0x0038 }
            r9.inMutable = r3     // Catch:{ IOException -> 0x0038 }
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeByteArray(r8, r2, r0, r9)     // Catch:{ IOException -> 0x0038 }
        L_0x002b:
            int r9 = r4.f66205d     // Catch:{ IOException -> 0x0038 }
            float r9 = (float) r9     // Catch:{ IOException -> 0x0038 }
            float r7 = (float) r7     // Catch:{ IOException -> 0x0038 }
            float r9 = r9 / r7
            int r0 = r4.f66206e     // Catch:{ IOException -> 0x0038 }
            float r0 = (float) r0     // Catch:{ IOException -> 0x0038 }
            float r0 = r0 / r7
            r5.drawBitmap(r8, r9, r0, r6)     // Catch:{ IOException -> 0x0038 }
            return r8
        L_0x0038:
            r5 = move-exception
            r5.printStackTrace()
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.apng.decode.c.a(android.graphics.Canvas, android.graphics.Paint, int, android.graphics.Bitmap, com.hbg.lib.apng.io.APNGWriter):android.graphics.Bitmap");
    }

    public final int c(APNGWriter aPNGWriter) throws IOException {
        int i11;
        int i12 = 33;
        for (d dVar : this.f66185k) {
            i12 += dVar.f66186a + 12;
        }
        for (d next : this.f66184j) {
            if (next instanceof h) {
                i11 = next.f66186a + 12;
            } else if (next instanceof f) {
                i11 = next.f66186a + 8;
            }
            i12 += i11;
        }
        int length = i12 + f66179m.length;
        aPNGWriter.d(length);
        aPNGWriter.c(f66178l);
        aPNGWriter.h(13);
        int a11 = aPNGWriter.a();
        aPNGWriter.g(j.f66210h);
        aPNGWriter.h(this.f66203b);
        aPNGWriter.h(this.f66204c);
        aPNGWriter.c(this.f66183i);
        CRC32 d11 = d();
        d11.reset();
        d11.update(aPNGWriter.f(), a11, 17);
        aPNGWriter.h((int) d11.getValue());
        for (d next2 : this.f66185k) {
            if (!(next2 instanceof i)) {
                ((a) this.f66202a).reset();
                ((a) this.f66202a).skip((long) next2.f66189d);
                ((a) this.f66202a).read(aPNGWriter.f(), aPNGWriter.a(), next2.f66186a + 12);
                aPNGWriter.e(next2.f66186a + 12);
            }
        }
        for (d next3 : this.f66184j) {
            if (next3 instanceof h) {
                ((a) this.f66202a).reset();
                ((a) this.f66202a).skip((long) next3.f66189d);
                ((a) this.f66202a).read(aPNGWriter.f(), aPNGWriter.a(), next3.f66186a + 12);
                aPNGWriter.e(next3.f66186a + 12);
            } else if (next3 instanceof f) {
                aPNGWriter.h(next3.f66186a - 4);
                int a12 = aPNGWriter.a();
                aPNGWriter.g(h.f66208e);
                ((a) this.f66202a).reset();
                ((a) this.f66202a).skip((long) (next3.f66189d + 4 + 4 + 4));
                ((a) this.f66202a).read(aPNGWriter.f(), aPNGWriter.a(), next3.f66186a - 4);
                aPNGWriter.e(next3.f66186a - 4);
                d11.reset();
                d11.update(aPNGWriter.f(), a12, next3.f66186a);
                aPNGWriter.h((int) d11.getValue());
            }
        }
        aPNGWriter.c(f66179m);
        return length;
    }

    public final CRC32 d() {
        CRC32 crc32 = f66180n.get();
        if (crc32 != null) {
            return crc32;
        }
        CRC32 crc322 = new CRC32();
        f66180n.set(crc322);
        return crc322;
    }
}
