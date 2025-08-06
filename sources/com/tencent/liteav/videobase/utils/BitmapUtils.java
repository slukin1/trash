package com.tencent.liteav.videobase.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.f;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
public class BitmapUtils {
    public static Bitmap createBitmap(Bitmap bitmap, Matrix matrix, boolean z11) {
        if (bitmap == null) {
            return null;
        }
        bitmap.getConfig();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (z11) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            new Canvas(createBitmap).drawBitmap(bitmap, matrix, paint);
            return createBitmap;
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap createBitmapFromBuffer(ByteBuffer byteBuffer, int i11, int i12) {
        try {
            byteBuffer.position(0);
            Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(byteBuffer);
            return createBitmap;
        } catch (Throwable th2) {
            LiteavLog.e("BitmapUtils", "build bitmap failed.", th2);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r0 = r1;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r7 = new android.graphics.Matrix();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r1 == 0) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r7.postScale(-1.0f, 1.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (r0 == 0) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        r7.postRotate((float) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        r2 = loadBitmapFile(r9, r10, r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        return android.graphics.Bitmap.createBitmap(r2, 0, 0, r2.getWidth(), r2.getHeight(), r7, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r1 = 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        r1 = 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r1 = 180;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap createBitmapFromFile(java.lang.String r9, int r10, int r11) {
        /*
            android.media.ExifInterface r0 = new android.media.ExifInterface     // Catch:{ all -> 0x004a }
            r0.<init>(r9)     // Catch:{ all -> 0x004a }
            java.lang.String r1 = "Orientation"
            r2 = 1
            int r0 = r0.getAttributeInt(r1, r2)     // Catch:{ all -> 0x004a }
            r1 = 0
            switch(r0) {
                case 1: goto L_0x001f;
                case 2: goto L_0x0020;
                case 3: goto L_0x001b;
                case 4: goto L_0x001c;
                case 5: goto L_0x0018;
                case 6: goto L_0x0014;
                case 7: goto L_0x0015;
                case 8: goto L_0x0012;
                default: goto L_0x0010;
            }     // Catch:{ all -> 0x004a }
        L_0x0010:
            r0 = r1
            goto L_0x0022
        L_0x0012:
            r2 = r1
            goto L_0x0018
        L_0x0014:
            r2 = r1
        L_0x0015:
            r1 = 90
            goto L_0x0020
        L_0x0018:
            r1 = 270(0x10e, float:3.78E-43)
            goto L_0x0020
        L_0x001b:
            r2 = r1
        L_0x001c:
            r1 = 180(0xb4, float:2.52E-43)
            goto L_0x0020
        L_0x001f:
            r2 = r1
        L_0x0020:
            r0 = r1
            r1 = r2
        L_0x0022:
            android.graphics.Matrix r7 = new android.graphics.Matrix     // Catch:{ all -> 0x004a }
            r7.<init>()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0030
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = 1065353216(0x3f800000, float:1.0)
            r7.postScale(r1, r2)     // Catch:{ all -> 0x004a }
        L_0x0030:
            if (r0 == 0) goto L_0x0036
            float r1 = (float) r0     // Catch:{ all -> 0x004a }
            r7.postRotate(r1)     // Catch:{ all -> 0x004a }
        L_0x0036:
            android.graphics.Bitmap r2 = loadBitmapFile(r9, r10, r11, r0)     // Catch:{ all -> 0x004a }
            r3 = 0
            r4 = 0
            int r5 = r2.getWidth()     // Catch:{ all -> 0x004a }
            int r6 = r2.getHeight()     // Catch:{ all -> 0x004a }
            r8 = 1
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x004a }
            return r9
        L_0x004a:
            r10 = move-exception
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r11 = "build bitmap failed, path: "
            java.lang.String r9 = r11.concat(r9)
            java.lang.String r11 = "BitmapUtils"
            com.tencent.liteav.base.util.LiteavLog.e((java.lang.String) r11, (java.lang.String) r9, (java.lang.Throwable) r10)
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.utils.BitmapUtils.createBitmapFromFile(java.lang.String, int, int):android.graphics.Bitmap");
    }

    private static Bitmap loadBitmapFile(String str, int i11, int i12, int i13) throws Throwable {
        if (i11 <= 0 || i12 <= 0) {
            return BitmapFactory.decodeFile(str);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i14 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        boolean z11 = i13 == 90 || i13 == 270;
        int i15 = z11 ? options.outHeight : options.outWidth;
        int i16 = z11 ? options.outWidth : options.outHeight;
        if (i15 > i11 || i16 > i12) {
            int i17 = i15 / ((i11 / 2) + 1);
            int i18 = i16 / ((i12 / 2) + 1);
            i14 = i18 > i17 ? i17 : i18;
        }
        options.inSampleSize = i14;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static void saveBitmapToFile(Bitmap bitmap, String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                fileOutputStream2.flush();
                f.a((Closeable) fileOutputStream2);
            } catch (Exception e11) {
                e = e11;
                fileOutputStream = fileOutputStream2;
                try {
                    LiteavLog.e("BitmapUtils", "save jpg file failed.", (Throwable) e);
                    f.a((Closeable) fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    f.a((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                f.a((Closeable) fileOutputStream);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            LiteavLog.e("BitmapUtils", "save jpg file failed.", (Throwable) e);
            f.a((Closeable) fileOutputStream);
        }
    }
}
