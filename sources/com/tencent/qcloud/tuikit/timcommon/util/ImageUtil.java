package com.tencent.qcloud.tuikit.timcommon.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.util.SPUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageUtil {
    public static final String SP_IMAGE = "_conversation_group_face";

    public static Bitmap adaptBitmapFormPath(String str, int i11, int i12) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = calculateInSampleSize(options, i11, i12);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i11, int i12) {
        int i13 = options.outHeight;
        int i14 = options.outWidth;
        int i15 = 1;
        if (i13 > i12 || i14 > i11) {
            int i16 = i13 / 2;
            int i17 = i14 / 2;
            while (i16 / i15 >= i12 && i17 / i15 >= i11) {
                i15 *= 2;
            }
        }
        return i15;
    }

    public static Bitmap compressImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int i11 = 100;
        while (byteArrayOutputStream.toByteArray().length / 1024 > 100) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i11, byteArrayOutputStream);
            i11 -= 10;
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), (Rect) null, (BitmapFactory.Options) null);
    }

    public static String generateImagePath(String str, int i11) {
        return TUIConfig.getImageDownloadDir() + str + "_" + i11;
    }

    public static int getBitmapDegree(Uri uri) {
        int i11;
        try {
            int attributeInt = new ExifInterface(FileUtil.getPathFromUri(uri)).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                i11 = 180;
            } else if (attributeInt == 6) {
                i11 = 90;
            } else if (attributeInt != 8) {
                return 0;
            } else {
                i11 = 270;
            }
            return i11;
        } catch (IOException e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055 A[Catch:{ Exception -> 0x007f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap getBitmapFormPath(android.net.Uri r10) {
        /*
            r0 = 0
            android.content.Context r1 = com.tencent.qcloud.tuicore.TUIConfig.getAppContext()     // Catch:{ Exception -> 0x007f }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ Exception -> 0x007f }
            java.io.InputStream r1 = r1.openInputStream(r10)     // Catch:{ Exception -> 0x007f }
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x007f }
            r2.<init>()     // Catch:{ Exception -> 0x007f }
            r3 = 1
            r2.inJustDecodeBounds = r3     // Catch:{ Exception -> 0x007f }
            r2.inDither = r3     // Catch:{ Exception -> 0x007f }
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x007f }
            r2.inPreferredConfig = r4     // Catch:{ Exception -> 0x007f }
            android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch:{ Exception -> 0x007f }
            r1.close()     // Catch:{ Exception -> 0x007f }
            int r1 = r2.outWidth     // Catch:{ Exception -> 0x007f }
            int r2 = r2.outHeight     // Catch:{ Exception -> 0x007f }
            r4 = -1
            if (r1 == r4) goto L_0x007e
            if (r2 != r4) goto L_0x002b
            goto L_0x007e
        L_0x002b:
            int r4 = getBitmapDegree((android.net.Uri) r10)     // Catch:{ Exception -> 0x007f }
            r5 = 90
            r6 = 1139802112(0x43f00000, float:480.0)
            r7 = 1145569280(0x44480000, float:800.0)
            if (r4 == r5) goto L_0x003b
            r5 = 270(0x10e, float:3.78E-43)
            if (r4 != r5) goto L_0x003e
        L_0x003b:
            r9 = r7
            r7 = r6
            r6 = r9
        L_0x003e:
            if (r1 <= r2) goto L_0x0048
            float r5 = (float) r1     // Catch:{ Exception -> 0x007f }
            int r8 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0048
            float r5 = r5 / r6
            int r1 = (int) r5     // Catch:{ Exception -> 0x007f }
            goto L_0x0053
        L_0x0048:
            if (r1 >= r2) goto L_0x0052
            float r1 = (float) r2     // Catch:{ Exception -> 0x007f }
            int r2 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0052
            float r1 = r1 / r7
            int r1 = (int) r1     // Catch:{ Exception -> 0x007f }
            goto L_0x0053
        L_0x0052:
            r1 = r3
        L_0x0053:
            if (r1 > 0) goto L_0x0056
            r1 = r3
        L_0x0056:
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x007f }
            r2.<init>()     // Catch:{ Exception -> 0x007f }
            r2.inSampleSize = r1     // Catch:{ Exception -> 0x007f }
            r2.inDither = r3     // Catch:{ Exception -> 0x007f }
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x007f }
            r2.inPreferredConfig = r1     // Catch:{ Exception -> 0x007f }
            android.content.Context r1 = com.tencent.qcloud.tuicore.TUIConfig.getAppContext()     // Catch:{ Exception -> 0x007f }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ Exception -> 0x007f }
            java.io.InputStream r10 = r1.openInputStream(r10)     // Catch:{ Exception -> 0x007f }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r10, r0, r2)     // Catch:{ Exception -> 0x007f }
            r10.close()     // Catch:{ Exception -> 0x007f }
            compressImage(r0)     // Catch:{ Exception -> 0x007f }
            android.graphics.Bitmap r10 = rotateBitmapByDegree(r0, r4)     // Catch:{ Exception -> 0x007f }
            goto L_0x0084
        L_0x007e:
            return r0
        L_0x007f:
            r10 = move-exception
            r10.printStackTrace()
            r10 = r0
        L_0x0084:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.timcommon.util.ImageUtil.getBitmapFormPath(android.net.Uri):android.graphics.Bitmap");
    }

    public static String getGroupConversationAvatar(String str) {
        String string = SPUtils.getInstance(TUILogin.getSdkAppId() + SP_IMAGE).getString(str, "");
        if (TextUtils.isEmpty(string) || !new File(string).isFile() || !new File(string).exists()) {
            return "";
        }
        return string;
    }

    public static String getImagePathAfterRotate(Uri uri) {
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(TUIConfig.getAppContext().getContentResolver().openInputStream(uri), (Rect) null, (BitmapFactory.Options) null);
            int bitmapDegree = getBitmapDegree(uri);
            if (bitmapDegree == 0) {
                return FileUtil.getPathFromUri(uri);
            }
            Bitmap rotateBitmapByDegree = rotateBitmapByDegree(decodeStream, bitmapDegree);
            File generateFileName = FileUtil.generateFileName(FileUtil.getFileName(TUIConfig.getAppContext(), uri), FileUtil.getDocumentCacheDir(TUIConfig.getAppContext()));
            if (generateFileName == null) {
                return FileUtil.getPathFromUri(uri);
            }
            storeBitmap(generateFileName, rotateBitmapByDegree);
            rotateBitmapByDegree.recycle();
            return generateFileName.getAbsolutePath();
        } catch (FileNotFoundException unused) {
            return FileUtil.getPathFromUri(uri);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044 A[Catch:{ Exception -> 0x0067 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] getImageSize(java.lang.String r11) {
        /*
            r0 = 2
            int[] r0 = new int[r0]
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0067 }
            r1.<init>()     // Catch:{ Exception -> 0x0067 }
            r2 = 1
            r1.inJustDecodeBounds = r2     // Catch:{ Exception -> 0x0067 }
            android.graphics.BitmapFactory.decodeFile(r11, r1)     // Catch:{ Exception -> 0x0067 }
            int r3 = r1.outWidth     // Catch:{ Exception -> 0x0067 }
            int r1 = r1.outHeight     // Catch:{ Exception -> 0x0067 }
            int r4 = getBitmapDegree((java.lang.String) r11)     // Catch:{ Exception -> 0x0067 }
            r5 = 0
            if (r4 != 0) goto L_0x001e
            r0[r5] = r3     // Catch:{ Exception -> 0x0067 }
            r0[r2] = r1     // Catch:{ Exception -> 0x0067 }
            goto L_0x006b
        L_0x001e:
            r6 = 90
            r7 = 1139802112(0x43f00000, float:480.0)
            r8 = 1145569280(0x44480000, float:800.0)
            if (r4 == r6) goto L_0x002a
            r6 = 270(0x10e, float:3.78E-43)
            if (r4 != r6) goto L_0x002d
        L_0x002a:
            r10 = r8
            r8 = r7
            r7 = r10
        L_0x002d:
            if (r3 <= r1) goto L_0x0037
            float r6 = (float) r3     // Catch:{ Exception -> 0x0067 }
            int r9 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0037
            float r6 = r6 / r7
            int r1 = (int) r6     // Catch:{ Exception -> 0x0067 }
            goto L_0x0042
        L_0x0037:
            if (r3 >= r1) goto L_0x0041
            float r1 = (float) r1     // Catch:{ Exception -> 0x0067 }
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x0041
            float r1 = r1 / r8
            int r1 = (int) r1     // Catch:{ Exception -> 0x0067 }
            goto L_0x0042
        L_0x0041:
            r1 = r2
        L_0x0042:
            if (r1 > 0) goto L_0x0045
            r1 = r2
        L_0x0045:
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0067 }
            r3.<init>()     // Catch:{ Exception -> 0x0067 }
            r3.inSampleSize = r1     // Catch:{ Exception -> 0x0067 }
            r3.inDither = r2     // Catch:{ Exception -> 0x0067 }
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x0067 }
            r3.inPreferredConfig = r1     // Catch:{ Exception -> 0x0067 }
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeFile(r11, r3)     // Catch:{ Exception -> 0x0067 }
            android.graphics.Bitmap r11 = rotateBitmapByDegree(r11, r4)     // Catch:{ Exception -> 0x0067 }
            int r1 = r11.getWidth()     // Catch:{ Exception -> 0x0067 }
            r0[r5] = r1     // Catch:{ Exception -> 0x0067 }
            int r11 = r11.getHeight()     // Catch:{ Exception -> 0x0067 }
            r0[r2] = r11     // Catch:{ Exception -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r11 = move-exception
            r11.printStackTrace()
        L_0x006b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.timcommon.util.ImageUtil.getImageSize(java.lang.String):int[]");
    }

    public static boolean isImageDownloaded(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static Bitmap rotateBitmapByDegree(Bitmap bitmap, int i11) {
        Bitmap bitmap2;
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i11);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            bitmap2 = bitmap;
        }
        if (bitmap != bitmap2) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    public static void setGroupConversationAvatar(String str, String str2) {
        SPUtils.getInstance(TUILogin.getSdkAppId() + SP_IMAGE).put(str, str2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|14|17|18|(0)|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
        r0.printStackTrace();
        r3.deleteOnExit();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0034 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039 A[SYNTHETIC, Splitter:B:20:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047 A[SYNTHETIC, Splitter:B:26:0x0047] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File storeBitmap(java.io.File r3, android.graphics.Bitmap r4) {
        /*
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r3.isDirectory()
            if (r0 == 0) goto L_0x0013
        L_0x000c:
            java.io.File r0 = r3.getParentFile()
            r0.mkdirs()
        L_0x0013:
            r0 = 0
            r3.deleteOnExit()     // Catch:{ IOException -> 0x0034 }
            r3.createNewFile()     // Catch:{ IOException -> 0x0034 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0034 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0034 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            r2 = 100
            r4.compress(r0, r2, r1)     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            r1.flush()     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            r1.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0044
        L_0x002d:
            r4 = move-exception
            r0 = r1
            goto L_0x0045
        L_0x0030:
            r0 = r1
            goto L_0x0034
        L_0x0032:
            r4 = move-exception
            goto L_0x0045
        L_0x0034:
            r3.deleteOnExit()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0044
            r0.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0044
        L_0x003d:
            r4 = move-exception
            r4.printStackTrace()
            r3.deleteOnExit()
        L_0x0044:
            return r3
        L_0x0045:
            if (r0 == 0) goto L_0x0052
            r0.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x0052
        L_0x004b:
            r0 = move-exception
            r0.printStackTrace()
            r3.deleteOnExit()
        L_0x0052:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.timcommon.util.ImageUtil.storeBitmap(java.io.File, android.graphics.Bitmap):java.io.File");
    }

    public static Bitmap toRoundBitmap(Bitmap bitmap) {
        float f11;
        float f12;
        float f13;
        float f14;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f14 = (float) (width / 2);
            f13 = (float) width;
            f12 = 0.0f;
            f11 = f13;
        } else {
            f12 = (float) ((width - height) / 2);
            f11 = (float) height;
            f13 = ((float) width) - f12;
            width = height;
            f14 = (float) (height / 2);
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect((int) f12, (int) 0.0f, (int) f13, (int) f11);
        Rect rect2 = new Rect((int) 0.0f, (int) 0.0f, (int) f11, (int) f11);
        new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawCircle(f14, f14, f14, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    public static int getBitmapDegree(String str) {
        int i11;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                i11 = 180;
            } else if (attributeInt == 6) {
                i11 = 90;
            } else if (attributeInt != 8) {
                return 0;
            } else {
                i11 = 270;
            }
            return i11;
        } catch (IOException e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static Bitmap getBitmapFormPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getBitmapFormPath(Uri.fromFile(new File(str)));
    }
}
