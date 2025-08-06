package com.huobi.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.hbg.lib.common.utils.FileUtil;
import com.luck.picture.lib.config.PictureMimeType;
import i6.n;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Hashtable;

public class ImageUtils {
    public static byte[] a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap b(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(n.g(view.getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        return d(view);
    }

    public static Bitmap c(String str, int i11) throws WriterException {
        Hashtable hashtable = new Hashtable();
        hashtable.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hashtable.put(EncodeHintType.DATA_MATRIX_SHAPE, 1);
        hashtable.put(EncodeHintType.MARGIN, 0);
        BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, i11, i11, hashtable);
        int width = encode.getWidth();
        int height = encode.getHeight();
        int[] iArr = new int[(width * height)];
        for (int i12 = 0; i12 < height; i12++) {
            for (int i13 = 0; i13 < width; i13++) {
                if (encode.get(i13, i12)) {
                    iArr[(i12 * width) + i13] = -16777216;
                } else {
                    iArr[(i12 * width) + i13] = -1;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    public static Bitmap d(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap e(Context context, int i11) {
        return BitmapFactory.decodeResource(context.getResources(), i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f A[SYNTHETIC, Splitter:B:23:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c A[SYNTHETIC, Splitter:B:31:0x009c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File f(android.content.Context r5, java.lang.String r6, double r7) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x000c
            return r0
        L_0x000c:
            long r0 = r0.length()
            r2 = 4697254411347427328(0x4130000000000000, double:1048576.0)
            double r7 = r7 * r2
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.RGB_565
            r2.inPreferredConfig = r3
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            float r0 = (float) r0
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r1
            double r0 = (double) r0
            double r0 = r0 / r7
            double r7 = java.lang.Math.ceil(r0)
            double r7 = java.lang.Math.max(r3, r7)
            int r7 = (int) r7
            r2.inSampleSize = r7
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeFile(r6, r2)
            r8 = 0
            if (r7 != 0) goto L_0x0037
            return r8
        L_0x0037:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
            r2 = 80
            r7.compress(r1, r2, r0)
            java.lang.String r6 = g(r6)
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            r1.<init>()     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            pa.d r2 = pa.d.o()     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            java.lang.String r5 = r2.n(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            r1.append(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            r1.append(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            r1.append(r2)     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            r1.append(r6)     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            r7.<init>(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            r5.<init>(r7)     // Catch:{ Exception -> 0x0088, all -> 0x0086 }
            byte[] r6 = r0.toByteArray()     // Catch:{ Exception -> 0x0084 }
            r5.write(r6)     // Catch:{ Exception -> 0x0084 }
            r5.close()     // Catch:{ IOException -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r5 = move-exception
            i6.d.g(r5)
        L_0x0083:
            return r7
        L_0x0084:
            r6 = move-exception
            goto L_0x008a
        L_0x0086:
            r6 = move-exception
            goto L_0x009a
        L_0x0088:
            r6 = move-exception
            r5 = r8
        L_0x008a:
            i6.d.g(r6)     // Catch:{ all -> 0x0098 }
            if (r5 == 0) goto L_0x0097
            r5.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x0097
        L_0x0093:
            r5 = move-exception
            i6.d.g(r5)
        L_0x0097:
            return r8
        L_0x0098:
            r6 = move-exception
            r8 = r5
        L_0x009a:
            if (r8 == 0) goto L_0x00a4
            r8.close()     // Catch:{ IOException -> 0x00a0 }
            goto L_0x00a4
        L_0x00a0:
            r5 = move-exception
            i6.d.g(r5)
        L_0x00a4:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.utils.ImageUtils.f(android.content.Context, java.lang.String, double):java.io.File");
    }

    public static String g(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) != -1) {
            return str.substring(lastIndexOf);
        }
        return PictureMimeType.JPG;
    }

    public static String h(Bitmap bitmap, Bitmap.CompressFormat compressFormat, File file) {
        FileOutputStream fileOutputStream;
        if (!(bitmap == null || file == null)) {
            FileUtil.e(file);
            try {
                fileOutputStream = new FileOutputStream(file);
                bitmap.compress(compressFormat, 100, fileOutputStream);
                fileOutputStream.flush();
                String absolutePath = file.getAbsolutePath();
                fileOutputStream.close();
                return absolutePath;
            } catch (Exception unused) {
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        return null;
        throw th;
    }

    public static Bitmap i(String str) {
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Bitmap j(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof ColorDrawable) {
            Bitmap createBitmap = Bitmap.createBitmap(32, 32, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawColor(((ColorDrawable) drawable).getColor());
            return createBitmap;
        } else if (!(drawable instanceof NinePatchDrawable)) {
            return null;
        } else {
            Bitmap createBitmap2 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return createBitmap2;
        }
    }

    public static Bitmap k(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null && bitmap2 == null) {
            return null;
        }
        if (bitmap != null && bitmap2 == null) {
            return bitmap;
        }
        if (bitmap == null && bitmap2 != null) {
            return bitmap2;
        }
        int max = Math.max(bitmap.getWidth(), bitmap2.getWidth());
        int height = bitmap.getHeight() + bitmap2.getHeight();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        Bitmap createBitmap = Bitmap.createBitmap(max, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.drawBitmap(bitmap2, 0.0f, (float) bitmap.getHeight(), paint);
        return createBitmap;
    }

    public static Bitmap l(Bitmap bitmap, int i11, int i12) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i11) / ((float) width), ((float) i12) / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
