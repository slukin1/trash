package com.hbg.lib.apng.decode;

import com.hbg.lib.apng.io.APNGWriter;
import z5.a;

public class k extends g<a, APNGWriter> {
    public k(a aVar) {
        super(aVar);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r8 = new android.graphics.BitmapFactory.Options();
        r8.inJustDecodeBounds = false;
        r8.inSampleSize = r6;
        r8.inMutable = true;
        r6 = android.graphics.BitmapFactory.decodeStream(((z5.a) r3.f66202a).a(), (android.graphics.Rect) null, r8);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0024 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap a(android.graphics.Canvas r4, android.graphics.Paint r5, int r6, android.graphics.Bitmap r7, com.hbg.lib.apng.io.APNGWriter r8) {
        /*
            r3 = this;
            android.graphics.BitmapFactory$Options r8 = new android.graphics.BitmapFactory$Options
            r8.<init>()
            r0 = 0
            r8.inJustDecodeBounds = r0
            r8.inSampleSize = r6
            r1 = 1
            r8.inMutable = r1
            r8.inBitmap = r7
            r7 = 0
            R r2 = r3.f66202a     // Catch:{ IOException -> 0x0046 }
            z5.a r2 = (z5.a) r2     // Catch:{ IOException -> 0x0046 }
            r2.reset()     // Catch:{ IOException -> 0x0046 }
            R r2 = r3.f66202a     // Catch:{ IllegalArgumentException -> 0x0024 }
            z5.a r2 = (z5.a) r2     // Catch:{ IllegalArgumentException -> 0x0024 }
            java.io.InputStream r2 = r2.a()     // Catch:{ IllegalArgumentException -> 0x0024 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r2, r7, r8)     // Catch:{ IllegalArgumentException -> 0x0024 }
            goto L_0x003b
        L_0x0024:
            android.graphics.BitmapFactory$Options r8 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x0046 }
            r8.<init>()     // Catch:{ IOException -> 0x0046 }
            r8.inJustDecodeBounds = r0     // Catch:{ IOException -> 0x0046 }
            r8.inSampleSize = r6     // Catch:{ IOException -> 0x0046 }
            r8.inMutable = r1     // Catch:{ IOException -> 0x0046 }
            R r6 = r3.f66202a     // Catch:{ IOException -> 0x0046 }
            z5.a r6 = (z5.a) r6     // Catch:{ IOException -> 0x0046 }
            java.io.InputStream r6 = r6.a()     // Catch:{ IOException -> 0x0046 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r6, r7, r8)     // Catch:{ IOException -> 0x0046 }
        L_0x003b:
            r5.setXfermode(r7)     // Catch:{ IOException -> 0x0043 }
            r7 = 0
            r4.drawBitmap(r6, r7, r7, r5)     // Catch:{ IOException -> 0x0043 }
            goto L_0x004b
        L_0x0043:
            r4 = move-exception
            r7 = r6
            goto L_0x0047
        L_0x0046:
            r4 = move-exception
        L_0x0047:
            r4.printStackTrace()
            r6 = r7
        L_0x004b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.apng.decode.k.a(android.graphics.Canvas, android.graphics.Paint, int, android.graphics.Bitmap, com.hbg.lib.apng.io.APNGWriter):android.graphics.Bitmap");
    }
}
