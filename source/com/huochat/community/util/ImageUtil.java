package com.huochat.community.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.hbg.lib.common.BaseApplication;
import com.huochat.community.network.domain.DomainTool;
import i6.d;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtil {
    private static ImageUtil instance;
    private Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
    private String destinationDirectoryPath = FileTool.getCacheFilePath(BaseApplication.b(), "images");
    private int maxHeight = 816;
    private int maxWidth = 612;
    private int quality = 80;

    public static byte[] bmpToByteArray(Bitmap bitmap, boolean z11) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        if (z11) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return byteArray;
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int i11, int i12) {
        int i13 = options.outHeight;
        int i14 = options.outWidth;
        int i15 = 1;
        if (i13 > i12 || i14 > i11) {
            int i16 = i13 / 2;
            int i17 = i14 / 2;
            while (i16 / i15 >= i12 && i17 / i15 >= i11) {
                i15 *= 2;
            }
            Log.d("ImageUtil", "calculateInSampleSize:inSampleSize = " + i15);
        }
        return i15;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0042, code lost:
        if (r0 != null) goto L_0x0044;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d A[Catch:{ IOException -> 0x0085, NullPointerException -> 0x0083, OutOfMemoryError -> 0x003e, Exception -> 0x0037, all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0089  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0084=Splitter:B:32:0x0084, B:21:0x0038=Splitter:B:21:0x0038} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File compressImage(java.io.File r3, int r4, int r5, android.graphics.Bitmap.CompressFormat r6, int r7, java.lang.String r8) throws java.io.IOException, java.lang.NullPointerException {
        /*
            r2 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            java.io.File r0 = r0.getParentFile()
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x0012
            r0.mkdirs()
        L_0x0012:
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0085, NullPointerException -> 0x0083, OutOfMemoryError -> 0x003e, Exception -> 0x0037 }
            r1.<init>(r8)     // Catch:{ IOException -> 0x0085, NullPointerException -> 0x0083, OutOfMemoryError -> 0x003e, Exception -> 0x0037 }
            android.graphics.Bitmap r3 = r2.decodeSampledBitmapFromFile(r3, r4, r5)     // Catch:{ IOException -> 0x0032, NullPointerException -> 0x002f, OutOfMemoryError -> 0x002c, Exception -> 0x0029, all -> 0x0026 }
            r3.compress(r6, r7, r1)     // Catch:{ IOException -> 0x0032, NullPointerException -> 0x002f, OutOfMemoryError -> 0x002c, Exception -> 0x0029, all -> 0x0026 }
            r1.flush()
            r1.close()
            goto L_0x004a
        L_0x0026:
            r3 = move-exception
            r0 = r1
            goto L_0x0087
        L_0x0029:
            r3 = move-exception
            r0 = r1
            goto L_0x0038
        L_0x002c:
            r3 = move-exception
            r0 = r1
            goto L_0x003f
        L_0x002f:
            r3 = move-exception
            r0 = r1
            goto L_0x0084
        L_0x0032:
            r3 = move-exception
            r0 = r1
            goto L_0x0086
        L_0x0035:
            r3 = move-exception
            goto L_0x0087
        L_0x0037:
            r3 = move-exception
        L_0x0038:
            r3.printStackTrace()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x004a
            goto L_0x0044
        L_0x003e:
            r3 = move-exception
        L_0x003f:
            r3.printStackTrace()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x004a
        L_0x0044:
            r0.flush()
            r0.close()
        L_0x004a:
            java.io.File r3 = new java.io.File
            r3.<init>(r8)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "after compressed: "
            r4.append(r5)
            java.lang.String r5 = r3.getAbsolutePath()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            i6.d.b(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "after compressed size = "
            r4.append(r5)
            long r5 = r3.length()
            r7 = 1024(0x400, double:5.06E-321)
            long r5 = r5 / r7
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            i6.k.c(r4)
            return r3
        L_0x0083:
            r3 = move-exception
        L_0x0084:
            throw r3     // Catch:{ all -> 0x0035 }
        L_0x0085:
            r3 = move-exception
        L_0x0086:
            throw r3     // Catch:{ all -> 0x0035 }
        L_0x0087:
            if (r0 == 0) goto L_0x008f
            r0.flush()
            r0.close()
        L_0x008f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.ImageUtil.compressImage(java.io.File, int, int, android.graphics.Bitmap$CompressFormat, int, java.lang.String):java.io.File");
    }

    private static int computeDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (Exception unused) {
            return 0;
        }
    }

    private Bitmap decodeSampledBitmapFromFile(File file, int i11, int i12) throws IOException, NullPointerException {
        try {
            String absolutePath = file.getAbsolutePath();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(absolutePath, options);
            options.inSampleSize = calculateInSampleSize(options, i11, i12);
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath, options);
            d.b("####### ---- decodeSampledBitmapFromFile bitmap: " + decodeFile + ", picPath: " + absolutePath);
            int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt("Orientation", 0);
            Matrix matrix = new Matrix();
            if (attributeInt == 6) {
                matrix.postRotate(90.0f);
            } else if (attributeInt == 3) {
                matrix.postRotate(180.0f);
            } else if (attributeInt == 8) {
                matrix.postRotate(270.0f);
            }
            return Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
        } catch (IOException e11) {
            throw e11;
        } catch (NullPointerException e12) {
            throw e12;
        } catch (OutOfMemoryError e13) {
            e13.printStackTrace();
            return null;
        } catch (Exception e14) {
            e14.printStackTrace();
            return null;
        }
    }

    public static Bitmap drawBitmapwithBg(int i11, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(i11);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRect(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight(), paint);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Bitmap drawQrcodeWithSlogan(int i11, Bitmap bitmap, String str, String str2) {
        int i12 = i11;
        Bitmap bitmap2 = bitmap;
        String str3 = str;
        String str4 = str2;
        if (bitmap2 == null || bitmap.isRecycled()) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(i12);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight() + DisplayTool.dp2px(80.0f), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRect(0.0f, 0.0f, (float) createBitmap.getWidth(), (float) createBitmap.getHeight(), paint);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
        int height = bitmap.getHeight();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#333333"));
        paint.setTextSize((float) DisplayTool.dp2px(13.0f));
        float measureText = paint.measureText(str3);
        canvas.drawText(str3, (((float) createBitmap.getWidth()) - measureText) / 2.0f, (float) (DisplayTool.dp2px(20.0f) + height), paint);
        paint.setTextSize((float) DisplayTool.dp2px(12.0f));
        canvas.drawText(str4, (((float) createBitmap.getWidth()) - paint.measureText(str4)) / 2.0f, (float) (DisplayTool.dp2px(46.0f) + height), paint);
        Paint paint2 = new Paint();
        paint2.setColor(i12);
        paint2.setStrokeWidth((float) DisplayTool.dp2px(1.0f));
        paint2.setDither(true);
        float width = ((((float) createBitmap.getWidth()) - measureText) / 2.0f) - ((float) DisplayTool.dp2px(60.0f));
        float width2 = ((((float) createBitmap.getWidth()) - measureText) / 2.0f) - ((float) DisplayTool.dp2px(10.0f));
        paint2.setShader(new LinearGradient(width, 0.0f, width2, 0.0f, Color.parseColor("#00333333"), Color.parseColor("#333333"), Shader.TileMode.CLAMP));
        Paint paint3 = paint2;
        canvas.drawLine(width, (float) (DisplayTool.dp2px(14.0f) + height), width2, (float) (DisplayTool.dp2px(14.0f) + height), paint3);
        float width3 = ((((float) createBitmap.getWidth()) + measureText) / 2.0f) + ((float) DisplayTool.dp2px(10.0f));
        float width4 = ((((float) createBitmap.getWidth()) + measureText) / 2.0f) + ((float) DisplayTool.dp2px(60.0f));
        paint2.setShader(new LinearGradient(width4, 0.0f, width3, 0.0f, Color.parseColor("#00333333"), Color.parseColor("#333333"), Shader.TileMode.CLAMP));
        canvas.drawLine(width3, (float) (DisplayTool.dp2px(14.0f) + height), width4, (float) (height + DisplayTool.dp2px(14.0f)), paint3);
        return createBitmap;
    }

    private static long getAvailMemorySize(Context context) {
        if (context == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1048576;
    }

    public static String getImageDisplayUrl(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.startsWith(DomainTool.DOMAIN_PREFIX_HTTP) && !str.startsWith(DomainTool.DOMAIN_PREFIX)) {
            return str;
        }
        switch (i11) {
            case 0:
            case 1:
                return str + "?style=st1";
            case 2:
                return str + "?style=st2";
            case 3:
                return str + "?style=st3";
            case 4:
                return str + "?style=st4";
            case 5:
                return str + "?style=st5";
            case 6:
                return str + "?style=st6";
            case 7:
                return str + "?style=st7";
            default:
                return str;
        }
    }

    public static float getImageScale(int i11, int i12) {
        int i13 = BaseApplication.b().getResources().getDisplayMetrics().widthPixels;
        if (i11 > 0) {
            return (((float) i13) * 1.0f) / ((float) i11);
        }
        return 1.0f;
    }

    private static int getImageStyle(Context context) {
        long availMemorySize = getAvailMemorySize(context);
        d.b("##### [ImageTool] memoryCacheSize: " + availMemorySize);
        int i11 = (availMemorySize > 512 ? 1 : (availMemorySize == 512 ? 0 : -1));
        if (i11 <= 0) {
            return 1;
        }
        if (i11 > 0 && availMemorySize <= 768) {
            return 2;
        }
        if (availMemorySize > 768 && availMemorySize <= 1024) {
            return 3;
        }
        if (availMemorySize <= 1024 || availMemorySize > 1536) {
            return availMemorySize > 1536 ? 5 : 0;
        }
        return 4;
    }

    public static int[] getImageWH(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[]{0, 0};
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i11 = options.outWidth;
            int i12 = options.outHeight;
            if (computeDegree(str) == 0 || computeDegree(str) == 180) {
                return new int[]{i11, i12};
            }
            return new int[]{i12, i11};
        } catch (Exception e11) {
            e11.printStackTrace();
            return new int[]{0, 0};
        }
    }

    public static ImageUtil getInstance() {
        if (instance == null) {
            synchronized (ImageUtil.class) {
                if (instance == null) {
                    instance = new ImageUtil();
                }
            }
        }
        return instance;
    }

    public static String getOriginalUrl(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
            return str;
        }
        return str + "?style=st";
    }

    public static String saveBitmap(Context context, Bitmap bitmap, String str) {
        return saveBitmap(context, bitmap, str, true);
    }

    public static String savePicturetoGallery(Bitmap bitmap, String str) {
        if (bitmap == null || bitmap.isRecycled()) {
            return "";
        }
        File file = new File(FileTool.getExternalDCIMPath(BaseApplication.b(), ""));
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        return file2.getAbsolutePath();
    }

    public static String savePicturetoLocal(Bitmap bitmap, String str) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    public static Bitmap zoomImg(Bitmap bitmap, int i11, int i12) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i11) / ((float) width), ((float) i12) / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public File compressFileToSize(File file, int i11) {
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        if (file.length() <= ((long) i11) * 1024) {
            return file;
        }
        try {
            return compressFileToSize(compressToFile(file), i11);
        } catch (IOException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public Bitmap compressToBitmap(File file) throws IOException, NullPointerException {
        return decodeSampledBitmapFromFile(file, this.maxWidth, this.maxHeight);
    }

    public File compressToFile(File file) throws IOException, NullPointerException {
        return compressToFile(file, file.getName());
    }

    public static String saveBitmap(Context context, Bitmap bitmap, String str, boolean z11) {
        String str2;
        if (bitmap != null && !bitmap.isRecycled()) {
            if (Build.BRAND.equals("Xiaomi")) {
                str2 = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/HuoChat/";
            } else {
                str2 = Environment.getExternalStorageDirectory().getPath() + "/DCIM/HuoChat/";
            }
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str);
            if (file2.exists()) {
                file2.delete();
            }
            try {
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (z11) {
                        MediaStore.Images.Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, (String) null);
                    }
                    return file2.getAbsolutePath();
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            if (z11) {
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getAbsolutePath())));
            }
        }
        return "";
    }

    public File compressToFile(File file, String str) throws IOException, NullPointerException {
        int i11 = this.maxWidth;
        int i12 = this.maxHeight;
        Bitmap.CompressFormat compressFormat2 = this.compressFormat;
        int i13 = this.quality;
        return compressImage(file, i11, i12, compressFormat2, i13, this.destinationDirectoryPath + File.separator + str);
    }

    public static String getImageDisplayUrl(Context context, String str) {
        return getImageDisplayUrl(str, getImageStyle(context));
    }
}
