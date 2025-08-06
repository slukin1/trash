package com.mob.tools.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.opengl.GLES10;
import android.text.TextUtils;
import android.view.View;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.utils.FileUtil;
import com.huobi.view.roundimg.RoundedDrawable;
import com.luck.picture.lib.config.PictureMimeType;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.scuba.smartcards.ISO7816;

public class BitmapHelper implements PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private static int f27973a;

    /* renamed from: b  reason: collision with root package name */
    private static int f27974b;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        f27973a = max;
        f27974b = max;
    }

    /* access modifiers changed from: private */
    public static String b(HttpConnection httpConnection, String str) throws Throwable {
        String str2;
        List list;
        String str3;
        int lastIndexOf;
        List list2;
        Map<String, List<String>> headerFields = httpConnection.getHeaderFields();
        String str4 = null;
        if (headerFields == null || (list2 = headerFields.get(HttpHeaders.CONTENT_DISPOSITION)) == null || list2.size() <= 0) {
            str2 = null;
        } else {
            str2 = null;
            for (String str5 : ((String) list2.get(0)).split(";")) {
                if (str5.trim().startsWith("filename")) {
                    String[] split = str5.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split.length >= 2) {
                        str2 = split[1];
                        if (!TextUtils.isEmpty(str2) && str2.startsWith("\"") && str2.endsWith("\"")) {
                            str2 = str2.substring(1, str2.length() - 1);
                        }
                    }
                }
            }
        }
        if (str2 != null) {
            return str2;
        }
        String MD5 = Data.MD5(str);
        if (headerFields == null || (list = headerFields.get("Content-Type")) == null || list.size() <= 0) {
            return MD5;
        }
        String str6 = (String) list.get(0);
        if (str6 == null) {
            str3 = "";
        } else {
            str3 = str6.trim();
        }
        if (str3.startsWith("image/")) {
            String substring = str3.substring(6);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(MD5);
            sb2.append(InstructionFileId.DOT);
            if ("jpeg".equals(substring)) {
                substring = "jpg";
            }
            sb2.append(substring);
            return sb2.toString();
        }
        int lastIndexOf2 = str.lastIndexOf(47);
        if (lastIndexOf2 > 0) {
            str4 = str.substring(lastIndexOf2 + 1);
        }
        if (str4 == null || str4.length() <= 0 || (lastIndexOf = str4.lastIndexOf(46)) <= 0 || str4.length() - lastIndexOf >= 10) {
            return MD5;
        }
        return MD5 + str4.substring(lastIndexOf);
    }

    public static Bitmap blur(Bitmap bitmap, int i11, int i12) {
        float f11 = (float) i12;
        Bitmap createBitmap = Bitmap.createBitmap((int) ((((float) bitmap.getWidth()) / f11) + 0.5f), (int) ((((float) bitmap.getHeight()) / f11) + 0.5f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        float f12 = 1.0f / f11;
        canvas.scale(f12, f12);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        a(createBitmap, (int) ((((float) i11) / f11) + 0.5f), true);
        return createBitmap;
    }

    public static Bitmap captureView(View view, int i11, int i12) throws Throwable {
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap compressByQuality(Bitmap bitmap, int i11) {
        return compressByQuality(bitmap, i11, false);
    }

    public static Bitmap cropBitmap(Bitmap bitmap, int i11, int i12, int i13, int i14) {
        int width = (bitmap.getWidth() - i11) - i13;
        int height = (bitmap.getHeight() - i12) - i14;
        if (width == bitmap.getWidth() && height == bitmap.getHeight()) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, (float) (-i11), (float) (-i12), new Paint());
        return createBitmap;
    }

    public static String downloadBitmap(Context context, final String str) throws Throwable {
        final String cachePath = ResHelper.getCachePath(context, "images");
        File file = new File(cachePath, Data.MD5(str));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        final HashMap hashMap = new HashMap();
        new NetworkHelper().rawGet(str, (HttpResponseCallback) new HttpResponseCallback() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.BufferedReader} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedReader} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.BufferedReader} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.BufferedReader} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.BufferedReader} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.BufferedReader} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.io.BufferedReader} */
            /* JADX WARNING: type inference failed for: r5v7, types: [com.mob.tools.utils.BitmapHelper$1$1, java.io.InputStream] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x00a8  */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(com.mob.tools.network.HttpConnection r8) throws java.lang.Throwable {
                /*
                    r7 = this;
                    int r0 = r8.getResponseCode()
                    r1 = 0
                    r2 = 0
                    r3 = 1
                    r4 = 200(0xc8, float:2.8E-43)
                    if (r0 != r4) goto L_0x00ac
                    java.lang.String r0 = r4
                    java.lang.String r0 = com.mob.tools.utils.BitmapHelper.b(r8, r0)
                    java.io.File r4 = new java.io.File
                    java.lang.String r5 = r3
                    r4.<init>(r5, r0)
                    java.io.File r5 = r4.getParentFile()
                    boolean r5 = r5.exists()
                    if (r5 != 0) goto L_0x0029
                    java.io.File r5 = r4.getParentFile()
                    r5.mkdirs()
                L_0x0029:
                    boolean r5 = r4.exists()
                    if (r5 == 0) goto L_0x0032
                    r4.delete()
                L_0x0032:
                    com.mob.tools.utils.BitmapHelper$1$1 r5 = new com.mob.tools.utils.BitmapHelper$1$1     // Catch:{ all -> 0x009a }
                    java.io.InputStream r8 = r8.getInputStream()     // Catch:{ all -> 0x009a }
                    r5.<init>(r8)     // Catch:{ all -> 0x009a }
                    android.graphics.Bitmap r8 = com.mob.tools.utils.BitmapHelper.getBitmap((java.io.InputStream) r5, (int) r3)     // Catch:{ all -> 0x0097 }
                    if (r8 == 0) goto L_0x0096
                    boolean r5 = r8.isRecycled()
                    if (r5 != 0) goto L_0x0096
                    java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x008d }
                    r5.<init>(r4)     // Catch:{ all -> 0x008d }
                    java.lang.String r2 = r0.toLowerCase()     // Catch:{ all -> 0x008a }
                    java.lang.String r6 = ".gif"
                    boolean r2 = r2.endsWith(r6)     // Catch:{ all -> 0x008a }
                    if (r2 != 0) goto L_0x006d
                    java.lang.String r0 = r0.toLowerCase()     // Catch:{ all -> 0x008a }
                    java.lang.String r2 = ".png"
                    boolean r0 = r0.endsWith(r2)     // Catch:{ all -> 0x008a }
                    if (r0 == 0) goto L_0x0065
                    goto L_0x006d
                L_0x0065:
                    android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x008a }
                    r2 = 80
                    r8.compress(r0, r2, r5)     // Catch:{ all -> 0x008a }
                    goto L_0x0074
                L_0x006d:
                    android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x008a }
                    r2 = 100
                    r8.compress(r0, r2, r5)     // Catch:{ all -> 0x008a }
                L_0x0074:
                    r5.flush()     // Catch:{ all -> 0x008a }
                    java.util.HashMap r8 = r0     // Catch:{ all -> 0x008a }
                    java.lang.String r0 = "bitmap"
                    java.lang.String r2 = r4.getAbsolutePath()     // Catch:{ all -> 0x008a }
                    r8.put(r0, r2)     // Catch:{ all -> 0x008a }
                    java.io.Closeable[] r8 = new java.io.Closeable[r3]
                    r8[r1] = r5
                    com.mob.commons.v.a((java.io.Closeable[]) r8)
                    goto L_0x0096
                L_0x008a:
                    r8 = move-exception
                    r2 = r5
                    goto L_0x008e
                L_0x008d:
                    r8 = move-exception
                L_0x008e:
                    java.io.Closeable[] r0 = new java.io.Closeable[r3]
                    r0[r1] = r2
                    com.mob.commons.v.a((java.io.Closeable[]) r0)
                    throw r8
                L_0x0096:
                    return
                L_0x0097:
                    r8 = move-exception
                    r2 = r5
                    goto L_0x009b
                L_0x009a:
                    r8 = move-exception
                L_0x009b:
                    java.io.Closeable[] r0 = new java.io.Closeable[r3]
                    r0[r1] = r2
                    com.mob.commons.v.a((java.io.Closeable[]) r0)
                    boolean r0 = r4.exists()
                    if (r0 == 0) goto L_0x00ab
                    r4.delete()
                L_0x00ab:
                    throw r8
                L_0x00ac:
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x010c }
                    r4.<init>()     // Catch:{ all -> 0x010c }
                    java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x010c }
                    java.io.InputStream r8 = r8.getErrorStream()     // Catch:{ all -> 0x010c }
                    java.lang.String r6 = "utf-8"
                    java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r6)     // Catch:{ all -> 0x010c }
                    r5.<init>(r8, r6)     // Catch:{ all -> 0x010c }
                    java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ all -> 0x010a }
                    r8.<init>(r5)     // Catch:{ all -> 0x010a }
                    java.lang.String r2 = r8.readLine()     // Catch:{ all -> 0x0107 }
                L_0x00c9:
                    if (r2 == 0) goto L_0x00de
                    int r6 = r4.length()     // Catch:{ all -> 0x0107 }
                    if (r6 <= 0) goto L_0x00d6
                    r6 = 10
                    r4.append(r6)     // Catch:{ all -> 0x0107 }
                L_0x00d6:
                    r4.append(r2)     // Catch:{ all -> 0x0107 }
                    java.lang.String r2 = r8.readLine()     // Catch:{ all -> 0x0107 }
                    goto L_0x00c9
                L_0x00de:
                    java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0107 }
                    r2.<init>()     // Catch:{ all -> 0x0107 }
                    java.lang.String r6 = "005g*ekekelek"
                    java.lang.String r6 = com.mob.commons.a.l.a((java.lang.String) r6)     // Catch:{ all -> 0x0107 }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0107 }
                    r2.put(r6, r4)     // Catch:{ all -> 0x0107 }
                    java.lang.String r4 = "006Egj'jej2ehgj"
                    java.lang.String r4 = com.mob.commons.a.l.a((java.lang.String) r4)     // Catch:{ all -> 0x0107 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0107 }
                    r2.put(r4, r0)     // Catch:{ all -> 0x0107 }
                    java.lang.Throwable r0 = new java.lang.Throwable     // Catch:{ all -> 0x0107 }
                    java.lang.String r2 = com.mob.tools.utils.HashonHelper.fromHashMap(r2)     // Catch:{ all -> 0x0107 }
                    r0.<init>(r2)     // Catch:{ all -> 0x0107 }
                    throw r0     // Catch:{ all -> 0x0107 }
                L_0x0107:
                    r0 = move-exception
                    r2 = r8
                    goto L_0x010e
                L_0x010a:
                    r0 = move-exception
                    goto L_0x010e
                L_0x010c:
                    r0 = move-exception
                    r5 = r2
                L_0x010e:
                    r8 = 2
                    java.io.Closeable[] r8 = new java.io.Closeable[r8]
                    r8[r1] = r2
                    r8[r3] = r5
                    com.mob.commons.v.a((java.io.Closeable[]) r8)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.BitmapHelper.AnonymousClass1.onResponse(com.mob.tools.network.HttpConnection):void");
            }
        }, (NetworkHelper.NetworkTimeOut) null);
        return (String) hashMap.get("bitmap");
    }

    public static int[] fixRect(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[2];
        if (((float) iArr[0]) / ((float) iArr[1]) > ((float) iArr2[0]) / ((float) iArr2[1])) {
            iArr3[0] = iArr2[0];
            iArr3[1] = (int) (((((float) iArr[1]) * ((float) iArr2[0])) / ((float) iArr[0])) + 0.5f);
        } else {
            iArr3[1] = iArr2[1];
            iArr3[0] = (int) (((((float) iArr[0]) * ((float) iArr2[1])) / ((float) iArr[1])) + 0.5f);
        }
        return iArr3;
    }

    public static int[] fixRect_2(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[2];
        if (((float) iArr[0]) / ((float) iArr[1]) > ((float) iArr2[0]) / ((float) iArr2[1])) {
            iArr3[1] = iArr2[1];
            iArr3[0] = (int) (((((float) iArr[0]) * ((float) iArr2[1])) / ((float) iArr[1])) + 0.5f);
        } else {
            iArr3[0] = iArr2[0];
            iArr3[1] = (int) (((((float) iArr[1]) * ((float) iArr2[0])) / ((float) iArr[0])) + 0.5f);
        }
        return iArr3;
    }

    public static Bitmap getBitmap(String str, int i11) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getBitmap(new File(str), i11);
    }

    public static Bitmap getBitmapByCompressQuality(String str, int i11, int i12, int i13, long j11) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            Bitmap bitmapByCompressSize = getBitmapByCompressSize(str, i11, i12);
            if (i13 < 10 || i13 > 100) {
                i13 = 100;
            }
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                Bitmap.CompressFormat bmpFormat = getBmpFormat(str);
                bitmapByCompressSize.compress(bmpFormat, i13, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (j11 < FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    v.a(byteArrayOutputStream2);
                    return decodeByteArray;
                }
                while (true) {
                    if (((long) byteArray.length) <= j11) {
                        break;
                    } else if (i13 < 11) {
                        break;
                    } else {
                        byteArrayOutputStream2.reset();
                        i13 -= 6;
                        bitmapByCompressSize.compress(bmpFormat, i13, byteArrayOutputStream2);
                        byteArray = byteArrayOutputStream2.toByteArray();
                    }
                }
                if (i13 != 100) {
                    bitmapByCompressSize = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                }
                v.a(byteArrayOutputStream2);
                return bitmapByCompressSize;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                v.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            v.a(byteArrayOutputStream);
            throw th;
        }
    }

    public static Bitmap getBitmapByCompressSize(String str, int i11, int i12) throws Throwable {
        int i13;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i14 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i15 = options.outWidth;
        int i16 = options.outHeight;
        if (i11 <= 1 || i12 <= 1) {
            i13 = 1;
        } else {
            float f11 = 1.0f;
            float min = (((float) Math.min(i15, i16)) * 1.0f) / ((float) Math.min(i11, i12));
            float max = (((float) Math.max(i15, i16)) * 1.0f) / ((float) Math.max(i11, i12));
            float f12 = (float) (i15 / i16);
            if (f12 <= 2.0f && ((double) f12) >= 0.5d) {
                float min2 = Math.min(min, max);
                while (true) {
                    float f13 = f11 * 2.0f;
                    if (f13 > min2) {
                        break;
                    }
                    f11 = f13;
                }
            } else {
                while (true) {
                    float f14 = f11 * 2.0f;
                    if (f14 > min) {
                        break;
                    }
                    f11 = f14;
                }
            }
            i13 = (int) f11;
        }
        if (i13 >= 1) {
            i14 = i13;
        }
        while (true) {
            if (i15 / i14 > f27973a || i16 / i14 > f27974b) {
                i14++;
            } else {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inPreferredConfig = Bitmap.Config.RGB_565;
                options2.inSampleSize = i14;
                return BitmapFactory.decodeFile(str, options2);
            }
        }
    }

    public static Bitmap.CompressFormat getBmpFormat(byte[] bArr) {
        String a11 = a(bArr);
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        if (a11 != null) {
            return (a11.endsWith("png") || a11.endsWith("gif")) ? Bitmap.CompressFormat.PNG : compressFormat;
        }
        return compressFormat;
    }

    public static String getMime(String str) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                byte[] bArr = new byte[8];
                fileInputStream2.read(bArr);
                String a11 = a(bArr);
                v.a(fileInputStream2);
                return a11;
            } catch (Exception e11) {
                e = e11;
                fileInputStream = fileInputStream2;
                try {
                    MobLog.getInstance().w((Throwable) e);
                    v.a(fileInputStream);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    v.a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                v.a(fileInputStream);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            MobLog.getInstance().w((Throwable) e);
            v.a(fileInputStream);
            return "";
        }
    }

    public static boolean isBlackBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return true;
        }
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= width) {
                break;
            } else if ((iArr[i11] & FlexItem.MAX_SIZE) != 0) {
                z11 = true;
                break;
            } else {
                i11++;
            }
        }
        return !z11;
    }

    public static int mixAlpha(int i11, int i12) {
        int i13 = i11 >>> 24;
        int i14 = 255 - i13;
        return ((((((i11 & 16711680) >>> 16) * i13) + (((16711680 & i12) >>> 16) * i14)) / 255) << 16) | RoundedDrawable.DEFAULT_BORDER_COLOR | ((((((i11 & 65280) >>> 8) * i13) + (((65280 & i12) >>> 8) * i14)) / 255) << 8) | (((i13 * (i11 & 255)) + (i14 * (i12 & 255))) / 255);
    }

    public static Bitmap roundBitmap(Bitmap bitmap, int i11, int i12, float f11, float f12, float f13, float f14) throws Throwable {
        Bitmap bitmap2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        if (width == i11 && height == i12) {
            bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        } else {
            bitmap2 = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        Rect rect2 = new Rect(0, 0, i11, i12);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float[] fArr = {f11, f11, f12, f12, f13, f13, f14, f14};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF(0.0f, 0.0f, 0.0f, 0.0f), fArr));
        shapeDrawable.setBounds(rect2);
        shapeDrawable.draw(canvas);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return bitmap2;
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, FileUtils.getFileByPath(str), compressFormat, false);
    }

    public static String saveBitmap(Context context, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i11) throws Throwable {
        Throwable th2;
        FileOutputStream fileOutputStream;
        File file = new File(ResHelper.getCachePath(context, "images"), String.valueOf(System.currentTimeMillis()) + (compressFormat == Bitmap.CompressFormat.PNG ? PictureMimeType.PNG : PictureMimeType.JPG));
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(compressFormat, i11, fileOutputStream);
                fileOutputStream.flush();
                v.a(fileOutputStream);
                return file.getAbsolutePath();
            } catch (Throwable th3) {
                th2 = th3;
                v.a(fileOutputStream);
                throw th2;
            }
        } catch (Throwable th4) {
            fileOutputStream = null;
            th2 = th4;
            v.a(fileOutputStream);
            throw th2;
        }
    }

    public static String saveBitmapByCompress(String str, int i11, int i12, int i13) throws Throwable {
        Throwable th2;
        FileOutputStream fileOutputStream;
        Bitmap bitmapByCompressSize = getBitmapByCompressSize(str, i11, i12);
        if (i13 > 100) {
            i13 = 100;
        } else if (i13 < 10) {
            i13 = 10;
        }
        Bitmap.CompressFormat bmpFormat = getBmpFormat(str);
        String str2 = bmpFormat == Bitmap.CompressFormat.PNG ? PictureMimeType.PNG : PictureMimeType.JPG;
        File file = new File(new File(str).getParent(), String.valueOf(System.currentTimeMillis()) + str2);
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bitmapByCompressSize.compress(bmpFormat, i13, fileOutputStream);
                fileOutputStream.flush();
                v.a(fileOutputStream);
                return file.getAbsolutePath();
            } catch (Throwable th3) {
                th2 = th3;
                v.a(fileOutputStream);
                throw th2;
            }
        } catch (Throwable th4) {
            fileOutputStream = null;
            th2 = th4;
            v.a(fileOutputStream);
            throw th2;
        }
    }

    public static String saveViewToImage(View view) throws Throwable {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        return saveViewToImage(view, width, height);
    }

    public static Bitmap scaleBitmapByHeight(Context context, int i11, int i12) throws Throwable {
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i11);
        boolean z11 = i12 != decodeResource.getHeight();
        Bitmap scaleBitmapByHeight = scaleBitmapByHeight(decodeResource, i12);
        if (z11) {
            decodeResource.recycle();
        }
        return scaleBitmapByHeight;
    }

    private static Bitmap a(Bitmap bitmap, int i11, boolean z11) {
        Bitmap bitmap2;
        int[] iArr;
        int i12 = i11;
        if (z11) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = bitmap.copy(bitmap.getConfig(), true);
        }
        if (i12 < 1) {
            return null;
        }
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int i13 = width * height;
        int[] iArr2 = new int[i13];
        bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i14 = width - 1;
        int i15 = height - 1;
        int i16 = i12 + i12 + 1;
        int[] iArr3 = new int[i13];
        int[] iArr4 = new int[i13];
        int[] iArr5 = new int[i13];
        int[] iArr6 = new int[Math.max(width, height)];
        int i17 = (i16 + 1) >> 1;
        int i18 = i17 * i17;
        int i19 = i18 * 256;
        int[] iArr7 = new int[i19];
        for (int i21 = 0; i21 < i19; i21++) {
            iArr7[i21] = i21 / i18;
        }
        int[] iArr8 = new int[2];
        iArr8[1] = 3;
        iArr8[0] = i16;
        int[][] iArr9 = (int[][]) Array.newInstance(int.class, iArr8);
        int i22 = i12 + 1;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < height) {
            Bitmap bitmap3 = bitmap2;
            int i26 = height;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            int i34 = 0;
            int i35 = -i12;
            int i36 = 0;
            while (i35 <= i12) {
                int i37 = i15;
                int[] iArr10 = iArr6;
                int i38 = iArr2[i24 + Math.min(i14, Math.max(i35, 0))];
                int[] iArr11 = iArr9[i35 + i12];
                iArr11[0] = (i38 & 16711680) >> 16;
                iArr11[1] = (i38 & 65280) >> 8;
                iArr11[2] = i38 & 255;
                int abs = i22 - Math.abs(i35);
                i36 += iArr11[0] * abs;
                i27 += iArr11[1] * abs;
                i28 += iArr11[2] * abs;
                if (i35 > 0) {
                    i32 += iArr11[0];
                    i33 += iArr11[1];
                    i34 += iArr11[2];
                } else {
                    i29 += iArr11[0];
                    i30 += iArr11[1];
                    i31 += iArr11[2];
                }
                i35++;
                i15 = i37;
                iArr6 = iArr10;
            }
            int i39 = i15;
            int[] iArr12 = iArr6;
            int i40 = i12;
            int i41 = i36;
            int i42 = 0;
            while (i42 < width) {
                iArr3[i24] = iArr7[i41];
                iArr4[i24] = iArr7[i27];
                iArr5[i24] = iArr7[i28];
                int i43 = i41 - i29;
                int i44 = i27 - i30;
                int i45 = i28 - i31;
                int[] iArr13 = iArr9[((i40 - i12) + i16) % i16];
                int i46 = i29 - iArr13[0];
                int i47 = i30 - iArr13[1];
                int i48 = i31 - iArr13[2];
                if (i23 == 0) {
                    iArr = iArr7;
                    iArr12[i42] = Math.min(i42 + i12 + 1, i14);
                } else {
                    iArr = iArr7;
                }
                int i49 = iArr2[i25 + iArr12[i42]];
                iArr13[0] = (i49 & 16711680) >> 16;
                iArr13[1] = (i49 & 65280) >> 8;
                iArr13[2] = i49 & 255;
                int i50 = i32 + iArr13[0];
                int i51 = i33 + iArr13[1];
                int i52 = i34 + iArr13[2];
                i41 = i43 + i50;
                i27 = i44 + i51;
                i28 = i45 + i52;
                i40 = (i40 + 1) % i16;
                int[] iArr14 = iArr9[i40 % i16];
                i29 = i46 + iArr14[0];
                i30 = i47 + iArr14[1];
                i31 = i48 + iArr14[2];
                i32 = i50 - iArr14[0];
                i33 = i51 - iArr14[1];
                i34 = i52 - iArr14[2];
                i24++;
                i42++;
                iArr7 = iArr;
            }
            int[] iArr15 = iArr7;
            i25 += width;
            i23++;
            bitmap2 = bitmap3;
            height = i26;
            i15 = i39;
            iArr6 = iArr12;
        }
        Bitmap bitmap4 = bitmap2;
        int i53 = i15;
        int[] iArr16 = iArr6;
        int i54 = height;
        int[] iArr17 = iArr7;
        int i55 = 0;
        while (i55 < width) {
            int i56 = -i12;
            int i57 = i16;
            int[] iArr18 = iArr2;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            int i64 = 0;
            int i65 = i56;
            int i66 = i56 * width;
            int i67 = 0;
            int i68 = 0;
            while (i65 <= i12) {
                int i69 = width;
                int max = Math.max(0, i66) + i55;
                int[] iArr19 = iArr9[i65 + i12];
                iArr19[0] = iArr3[max];
                iArr19[1] = iArr4[max];
                iArr19[2] = iArr5[max];
                int abs2 = i22 - Math.abs(i65);
                i67 += iArr3[max] * abs2;
                i68 += iArr4[max] * abs2;
                i58 += iArr5[max] * abs2;
                if (i65 > 0) {
                    i62 += iArr19[0];
                    i63 += iArr19[1];
                    i64 += iArr19[2];
                } else {
                    i59 += iArr19[0];
                    i60 += iArr19[1];
                    i61 += iArr19[2];
                }
                int i70 = i53;
                if (i65 < i70) {
                    i66 += i69;
                }
                i65++;
                i53 = i70;
                width = i69;
            }
            int i71 = width;
            int i72 = i53;
            int i73 = i12;
            int i74 = i55;
            int i75 = i68;
            int i76 = i54;
            int i77 = i67;
            int i78 = 0;
            while (i78 < i76) {
                iArr18[i74] = (iArr18[i74] & RoundedDrawable.DEFAULT_BORDER_COLOR) | (iArr17[i77] << 16) | (iArr17[i75] << 8) | iArr17[i58];
                int i79 = i77 - i59;
                int i80 = i75 - i60;
                int i81 = i58 - i61;
                int[] iArr20 = iArr9[((i73 - i12) + i57) % i57];
                int i82 = i59 - iArr20[0];
                int i83 = i60 - iArr20[1];
                int i84 = i61 - iArr20[2];
                if (i55 == 0) {
                    iArr16[i78] = Math.min(i78 + i22, i72) * i71;
                }
                int i85 = iArr16[i78] + i55;
                iArr20[0] = iArr3[i85];
                iArr20[1] = iArr4[i85];
                iArr20[2] = iArr5[i85];
                int i86 = i62 + iArr20[0];
                int i87 = i63 + iArr20[1];
                int i88 = i64 + iArr20[2];
                i77 = i79 + i86;
                i75 = i80 + i87;
                i58 = i81 + i88;
                i73 = (i73 + 1) % i57;
                int[] iArr21 = iArr9[i73];
                i59 = i82 + iArr21[0];
                i60 = i83 + iArr21[1];
                i61 = i84 + iArr21[2];
                i62 = i86 - iArr21[0];
                i63 = i87 - iArr21[1];
                i64 = i88 - iArr21[2];
                i74 += i71;
                i78++;
                i12 = i11;
            }
            i55++;
            i12 = i11;
            i53 = i72;
            i54 = i76;
            i16 = i57;
            iArr2 = iArr18;
            width = i71;
        }
        int i89 = width;
        bitmap4.setPixels(iArr2, 0, i89, 0, 0, i89, i54);
        return bitmap4;
    }

    public static Bitmap compressByQuality(Bitmap bitmap, int i11, boolean z11) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (a(bitmap)) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i11, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (z11 && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                v.a(byteArrayOutputStream2);
                return decodeByteArray;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                v.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            v.a(byteArrayOutputStream);
            throw th;
        }
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z11) {
        boolean z12;
        if (a(bitmap) || !FileUtils.createFileByDeleteOldFile(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                z12 = bitmap.compress(compressFormat, 100, bufferedOutputStream2);
                if (z11) {
                    try {
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = bufferedOutputStream2;
                        try {
                            MobLog.getInstance().d(th);
                            return z12;
                        } finally {
                            v.a(bufferedOutputStream);
                        }
                    }
                }
                v.a(bufferedOutputStream2);
            } catch (Throwable th3) {
                th = th3;
                z12 = false;
                bufferedOutputStream = bufferedOutputStream2;
                MobLog.getInstance().d(th);
                return z12;
            }
        } catch (Throwable th4) {
            th = th4;
            z12 = false;
            MobLog.getInstance().d(th);
            return z12;
        }
        return z12;
    }

    public static Bitmap getBitmap(File file, int i11) throws Throwable {
        FileInputStream fileInputStream = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                Bitmap bitmap = getBitmap((InputStream) fileInputStream2, i11);
                v.a(fileInputStream2);
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                v.a(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            v.a(fileInputStream);
            throw th;
        }
    }

    public static String saveViewToImage(View view, int i11, int i12) throws Throwable {
        Bitmap captureView = captureView(view, i11, i12);
        FileOutputStream fileOutputStream = null;
        if (captureView == null || captureView.isRecycled()) {
            return null;
        }
        String cachePath = ResHelper.getCachePath(view.getContext(), "screenshot");
        File file = new File(cachePath, String.valueOf(System.currentTimeMillis()) + PictureMimeType.JPG);
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                captureView.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                fileOutputStream2.flush();
                v.a(fileOutputStream2);
                return file.getAbsolutePath();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                v.a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            v.a(fileOutputStream);
            throw th;
        }
    }

    public static Bitmap.CompressFormat getBmpFormat(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.endsWith("png") || lowerCase.endsWith("gif")) {
            return Bitmap.CompressFormat.PNG;
        }
        if (lowerCase.endsWith("jpg") || lowerCase.endsWith("jpeg") || lowerCase.endsWith("bmp") || lowerCase.endsWith("tif")) {
            return Bitmap.CompressFormat.JPEG;
        }
        String mime = getMime(str);
        if (mime.endsWith("png") || mime.endsWith("gif")) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public static Bitmap scaleBitmapByHeight(Bitmap bitmap, int i11) {
        return Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * i11) / bitmap.getHeight(), i11, true);
    }

    public static Bitmap getBitmap(InputStream inputStream, int i11) {
        if (inputStream == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i11;
        return BitmapFactory.decodeStream(inputStream, (Rect) null, options);
    }

    public static Bitmap compressByQuality(Bitmap bitmap, long j11) {
        return compressByQuality(bitmap, j11, false);
    }

    public static String saveBitmap(Context context, Bitmap bitmap) throws Throwable {
        return saveBitmap(context, bitmap, Bitmap.CompressFormat.JPEG, 80);
    }

    public static Bitmap compressByQuality(Bitmap bitmap, long j11, boolean z11) {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (a(bitmap) || j11 <= 0) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                int i11 = 100;
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
                if (((long) byteArrayOutputStream2.size()) <= j11) {
                    bArr = byteArrayOutputStream2.toByteArray();
                } else {
                    byteArrayOutputStream2.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream2);
                    if (((long) byteArrayOutputStream2.size()) >= j11) {
                        bArr = byteArrayOutputStream2.toByteArray();
                    } else {
                        int i12 = 0;
                        int i13 = 0;
                        while (true) {
                            if (i12 >= i11) {
                                break;
                            }
                            i13 = (i12 + i11) / 2;
                            byteArrayOutputStream2.reset();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, i13, byteArrayOutputStream2);
                            int i14 = (((long) byteArrayOutputStream2.size()) > j11 ? 1 : (((long) byteArrayOutputStream2.size()) == j11 ? 0 : -1));
                            if (i14 == 0) {
                                break;
                            } else if (i14 > 0) {
                                i11 = i13 - 1;
                            } else {
                                i12 = i13 + 1;
                            }
                        }
                        if (i11 == i13 - 1) {
                            byteArrayOutputStream2.reset();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, i12, byteArrayOutputStream2);
                        }
                        bArr = byteArrayOutputStream2.toByteArray();
                    }
                }
                if (z11 && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                v.a(byteArrayOutputStream2);
                return decodeByteArray;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                v.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            v.a(byteArrayOutputStream);
            throw th;
        }
    }

    public static Bitmap getBitmap(String str) throws Throwable {
        return getBitmap(str, 1);
    }

    public static Bitmap getBitmap(Context context, String str) throws Throwable {
        return getBitmap(downloadBitmap(context, str));
    }

    private static String a(byte[] bArr) {
        byte[] bArr2 = {-1, ISO7816.INS_LOAD_KEY_FILE, -1, ISO7816.INS_CREATE_FILE};
        byte[] bArr3 = {-1, ISO7816.INS_LOAD_KEY_FILE, -1, -31};
        if (a(bArr, bArr2) || a(bArr, bArr3)) {
            return "jpg";
        }
        if (a(bArr, new byte[]{-119, 80, 78, 71})) {
            return "png";
        }
        if (a(bArr, "GIF".getBytes())) {
            return "gif";
        }
        if (a(bArr, "BM".getBytes())) {
            return "bmp";
        }
        return (a(bArr, new byte[]{73, 73, ISO7816.INS_PSO}) || a(bArr, new byte[]{77, 77, ISO7816.INS_PSO})) ? "tif" : "";
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i11 = 0; i11 < bArr2.length; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }
}
