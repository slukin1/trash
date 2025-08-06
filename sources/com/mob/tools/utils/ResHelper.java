package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.mob.commons.m;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DH;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class ResHelper implements PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private static float f28138a;

    /* renamed from: b  reason: collision with root package name */
    private static int f28139b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static Uri f28140c;

    public static void clearCache(Context context) throws Throwable {
        deleteFileAndFolder(new File(getCachePath(context, (String) null)));
    }

    public static void closeIOs(Closeable... closeableArr) {
        v.a(closeableArr);
    }

    public static boolean copyFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str).exists()) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    copyFile(fileInputStream2, fileOutputStream);
                    v.a(fileInputStream2, fileOutputStream);
                    return true;
                } catch (Throwable unused) {
                    fileInputStream = fileInputStream2;
                    v.a(fileInputStream, fileOutputStream);
                    return false;
                }
            } catch (Throwable unused2) {
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                v.a(fileInputStream, fileOutputStream);
                return false;
            }
        } catch (Throwable unused3) {
            fileOutputStream = null;
            v.a(fileInputStream, fileOutputStream);
            return false;
        }
    }

    @Deprecated
    public static long dateStrToLong(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").parse(str, new ParsePosition(0)).getTime();
    }

    @Deprecated
    public static long dateToLong(String str) {
        try {
            Date date = new Date(str);
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            return instance.getTimeInMillis();
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return 0;
        }
    }

    @Deprecated
    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split2 = split.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length < 2 || split2[1] == null) {
                    bundle.putString(URLDecoder.decode(split2[0]), "");
                } else {
                    bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                }
            }
        }
        return bundle;
    }

    public static void deleteFileAndFolder(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null || list.length <= 0) {
                file.delete();
                return;
            }
            for (String file2 : list) {
                File file3 = new File(file, file2);
                if (file3.isDirectory()) {
                    deleteFileAndFolder(file3);
                } else {
                    file3.delete();
                }
            }
            file.delete();
        }
    }

    public static int designToDevice(Context context, int i11, int i12) {
        if (f28139b == 0) {
            int[] screenSize = getScreenSize(context);
            f28139b = screenSize[0] < screenSize[1] ? screenSize[0] : screenSize[1];
        }
        return (int) (((((float) i12) * ((float) f28139b)) / ((float) i11)) + 0.5f);
    }

    public static int dipToPx(Context context, int i11) {
        if (f28138a <= 0.0f) {
            f28138a = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((((float) i11) * f28138a) + 0.5f);
    }

    @Deprecated
    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z11 = true;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                obj = "";
            }
            if (z11) {
                z11 = false;
            } else {
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb2.append(Data.urlEncode(str) + ContainerUtils.KEY_VALUE_DELIMITER + Data.urlEncode(String.valueOf(obj)));
        }
        return sb2.toString();
    }

    public static <T> T forceCast(Object obj) {
        return forceCast(obj, (Object) null);
    }

    public static int getAnimRes(Context context, String str) {
        return getResId(context, "anim", str);
    }

    public static int getBitmapRes(Context context, String str) {
        int resId = getResId(context, "drawable", str);
        return resId <= 0 ? getResId(context, "mipmap", str) : resId;
    }

    public static String getCachePath(Context context, String str) {
        String str2 = context.getFilesDir().getAbsolutePath() + m.a("001j") + "MobSDK" + m.a("007jabafdj");
        try {
            String sandboxPath = DH.SyncMtd.getSandboxPath();
            if (sandboxPath != null) {
                str2 = sandboxPath + m.a("001j") + "MobSDK" + m.a("001j") + DH.SyncMtd.getPackageName() + m.a("007jabafdj");
            }
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + str + m.a("001j");
        }
        File file = new File(str2);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return str2;
    }

    public static String getCacheRoot(Context context) {
        return getCacheRoot(context, false);
    }

    public static File getCacheRootFile(Context context, String str) {
        try {
            String cacheRoot = getCacheRoot(context);
            if (cacheRoot == null) {
                return null;
            }
            File file = new File(cacheRoot, str);
            if (!file.getParentFile().exists() || !file.getParentFile().isDirectory()) {
                file.getParentFile().delete();
                file.getParentFile().mkdirs();
            }
            return file;
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    public static int getColorRes(Context context, String str) {
        return getResId(context, "color", str);
    }

    public static String getDataCache(Context context) {
        String str = context.getFilesDir().getAbsolutePath() + m.a("001j") + "MobSDK";
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        return str;
    }

    public static File getDataCacheFile(Context context, String str) {
        return getDataCacheFile(context, str, false);
    }

    public static float getDensity(Context context) {
        if (f28138a <= 0.0f) {
            f28138a = context.getResources().getDisplayMetrics().density;
        }
        return f28138a;
    }

    public static int getDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static float[] getDensityXYDpi(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new float[]{displayMetrics.xdpi, displayMetrics.ydpi};
    }

    @Deprecated
    public static long getFileSize(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return getFileSize(new File(str));
    }

    public static int getIdRes(Context context, String str) {
        return getResId(context, m.a("002Lbgba"), str);
    }

    public static String getImageCachePath(Context context) {
        return getCachePath(context, "images");
    }

    public static int getLayoutRes(Context context, String str) {
        return getResId(context, m.a("006eb4cabibeRg"), str);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    @java.lang.Deprecated
    public static synchronized android.net.Uri getMediaUri(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.Class<com.mob.tools.utils.ResHelper> r0 = com.mob.tools.utils.ResHelper.class
            monitor-enter(r0)
            java.lang.Object r1 = new java.lang.Object     // Catch:{ all -> 0x0032 }
            r1.<init>()     // Catch:{ all -> 0x0032 }
            r2 = 0
            f28140c = r2     // Catch:{ all -> 0x0032 }
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ all -> 0x0032 }
            r5 = 0
            r4[r5] = r7     // Catch:{ all -> 0x0032 }
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ all -> 0x0032 }
            r7[r5] = r8     // Catch:{ all -> 0x0032 }
            com.mob.tools.utils.ResHelper$1 r8 = new com.mob.tools.utils.ResHelper$1     // Catch:{ all -> 0x0032 }
            r8.<init>(r1)     // Catch:{ all -> 0x0032 }
            android.media.MediaScannerConnection.scanFile(r6, r4, r7, r8)     // Catch:{ all -> 0x0032 }
            android.net.Uri r6 = f28140c     // Catch:{ all -> 0x002c }
            if (r6 != 0) goto L_0x002c
            monitor-enter(r1)     // Catch:{ all -> 0x002c }
            r6 = 10000(0x2710, double:4.9407E-320)
            r1.wait(r6)     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            goto L_0x002c
        L_0x0029:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r6     // Catch:{ all -> 0x002c }
        L_0x002c:
            android.net.Uri r6 = f28140c     // Catch:{ all -> 0x0032 }
            f28140c = r2     // Catch:{ all -> 0x0032 }
            monitor-exit(r0)
            return r6
        L_0x0032:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.ResHelper.getMediaUri(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    public static int getRawRes(Context context, String str) {
        return getResId(context, "raw", str);
    }

    public static int getResId(Context context, String str, String str2) {
        int i11 = 0;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return 0;
            }
            i11 = context.getResources().getIdentifier(str2, str, packageName);
            if (i11 <= 0) {
                i11 = context.getResources().getIdentifier(str2.toLowerCase(), str, packageName);
            }
            if (i11 <= 0) {
                NLog instance = MobLog.getInstance();
                instance.w("failed to parse " + str + " resource \"" + str2 + "\"");
            }
        }
        return i11;
    }

    public static int getScreenHeight(Context context) {
        return getScreenSize(context)[1];
    }

    public static double getScreenInch(Context context) {
        try {
            int screenWidth = getScreenWidth(context);
            int screenHeight = getScreenHeight(context);
            float[] densityXYDpi = getDensityXYDpi(context);
            if (densityXYDpi == null || densityXYDpi.length != 2) {
                return 0.0d;
            }
            double d11 = (double) (((float) screenWidth) / densityXYDpi[0]);
            double d12 = (double) (((float) screenHeight) / densityXYDpi[1]);
            return new BigDecimal(Math.sqrt((d11 * d11) + (d12 * d12))).setScale(1, 4).doubleValue();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return 0.0d;
        }
    }

    public static int getScreenPpi(Context context) {
        try {
            int screenWidth = getScreenWidth(context);
            int screenHeight = getScreenHeight(context);
            return (int) Math.round(Math.sqrt((double) ((screenWidth * screenWidth) + (screenHeight * screenHeight))) / getScreenInch(context));
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return 0;
        }
    }

    public static int[] getScreenSize(Context context) {
        WindowManager windowManager;
        Display display = null;
        try {
            windowManager = (WindowManager) DH.SyncMtd.getSystemServiceSafe("window");
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            windowManager = null;
        }
        if (windowManager == null) {
            return new int[]{0, 0};
        }
        try {
            display = windowManager.getDefaultDisplay();
        } catch (Throwable th3) {
            MobLog.getInstance().w(th3);
        }
        if (display == null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
            } catch (Throwable th4) {
                MobLog.getInstance().w(th4);
                return new int[]{0, 0};
            }
        } else if (Build.VERSION.SDK_INT < 13) {
            try {
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                display.getMetrics(displayMetrics2);
                return new int[]{displayMetrics2.widthPixels, displayMetrics2.heightPixels};
            } catch (Throwable th5) {
                MobLog.getInstance().w(th5);
                return new int[]{0, 0};
            }
        } else {
            try {
                Point point = new Point();
                Method method = display.getClass().getMethod(m.a("011_ch(dg=eh8dbe*cjbgeb?d"), new Class[]{Point.class});
                method.setAccessible(true);
                method.invoke(display, new Object[]{point});
                return new int[]{point.x, point.y};
            } catch (Throwable th6) {
                MobLog.getInstance().w(th6);
                return new int[]{0, 0};
            }
        }
    }

    public static int getScreenWidth(Context context) {
        return getScreenSize(context)[0];
    }

    public static int getStringArrayRes(Context context, String str) {
        return getResId(context, "array", str);
    }

    public static int getStringRes(Context context, String str) {
        return getResId(context, "string", str);
    }

    public static int getStyleRes(Context context, String str) {
        return getResId(context, "style", str);
    }

    public static int[] getStyleableRes(Context context, String str) {
        try {
            Object staticField = ReflectHelper.getStaticField(ReflectHelper.importClass(context.getPackageName() + ".R$styleable"), str);
            if (staticField == null) {
                return new int[0];
            }
            if (staticField.getClass().isArray()) {
                return (int[]) staticField;
            }
            return new int[]{((Integer) staticField).intValue()};
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return new int[0];
        }
    }

    public static <T> boolean isEqual(T t11, T t12) {
        return !((t11 == null && t12 != null) || (t11 != null && !t11.equals(t12)));
    }

    @Deprecated
    public static int parseInt(String str) throws Throwable {
        return parseInt(str, 10);
    }

    @Deprecated
    public static long parseLong(String str) throws Throwable {
        return parseLong(str, 10);
    }

    @Deprecated
    public static Uri pathToContentUri(Context context, String str) {
        try {
            if (!DH.SyncMtd.checkPermission(m.a("040bc'babhbibgbabjPhdUbhbdbgdgdgbgbi%c-bjehegdbdjbfegeedaegehcedbdcbfcjdaefehdbgbeg"))) {
                return null;
            }
            Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, (String) null);
            if (query != null && query.moveToFirst()) {
                int i11 = query.getInt(query.getColumnIndex("_id"));
                Uri parse = Uri.parse("content://media/external/images/media");
                return Uri.withAppendedPath(parse, "" + i11);
            } else if (!new File(str).exists()) {
                return null;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_data", str);
                return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            }
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    public static int pxToDip(Context context, int i11) {
        if (f28138a <= 0.0f) {
            f28138a = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((((float) i11) / f28138a) + 0.5f);
    }

    public static ArrayList<HashMap<String, String>> readArrayListFromFile(String str) {
        return readArrayListFromFile(str, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.nio.channels.FileChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFromFileNoCompress(java.io.File r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x0057
            boolean r1 = r7.exists()
            if (r1 == 0) goto L_0x0057
            r1 = 1
            r2 = 0
            r3 = 2
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x0038 }
            r4.<init>(r7)     // Catch:{ all -> 0x0038 }
            java.nio.channels.FileChannel r7 = r4.getChannel()     // Catch:{ all -> 0x0035 }
            long r5 = r7.size()     // Catch:{ all -> 0x0033 }
            int r5 = (int) r5     // Catch:{ all -> 0x0033 }
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocate(r5)     // Catch:{ all -> 0x0033 }
        L_0x001e:
            int r6 = r7.read(r5)     // Catch:{ all -> 0x0033 }
            if (r6 <= 0) goto L_0x0025
            goto L_0x001e
        L_0x0025:
            byte[] r0 = r5.array()     // Catch:{ all -> 0x0033 }
            java.io.Closeable[] r3 = new java.io.Closeable[r3]
            r3[r2] = r7
            r3[r1] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r3)
            return r0
        L_0x0033:
            r5 = move-exception
            goto L_0x003b
        L_0x0035:
            r5 = move-exception
            r7 = r0
            goto L_0x003b
        L_0x0038:
            r5 = move-exception
            r7 = r0
            r4 = r7
        L_0x003b:
            com.mob.tools.log.NLog r6 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x004c }
            r6.d(r5)     // Catch:{ all -> 0x004c }
            java.io.Closeable[] r3 = new java.io.Closeable[r3]
            r3[r2] = r7
            r3[r1] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r3)
            goto L_0x0057
        L_0x004c:
            r0 = move-exception
            java.io.Closeable[] r3 = new java.io.Closeable[r3]
            r3[r2] = r7
            r3[r1] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r3)
            throw r0
        L_0x0057:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.ResHelper.readFromFileNoCompress(java.io.File):byte[]");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.io.ObjectInputStream} */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (r0.exists() == false) goto L_0x001b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object readObjectFromFile(java.lang.String r9) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = 0
            if (r0 != 0) goto L_0x0071
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0013 }
            r0.<init>(r9)     // Catch:{ all -> 0x0013 }
            boolean r9 = r0.exists()     // Catch:{ all -> 0x0013 }
            if (r9 != 0) goto L_0x001c
            goto L_0x001b
        L_0x0013:
            r9 = move-exception
            com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()
            r0.d(r9)
        L_0x001b:
            r0 = r1
        L_0x001c:
            if (r0 == 0) goto L_0x0071
            r9 = 2
            r2 = 1
            r3 = 0
            r4 = 3
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x004d }
            r5.<init>(r0)     // Catch:{ all -> 0x004d }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0049 }
            r0.<init>(r5)     // Catch:{ all -> 0x0049 }
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0046 }
            r6.<init>(r0)     // Catch:{ all -> 0x0046 }
            java.lang.Object r7 = r6.readObject()     // Catch:{ all -> 0x0044 }
            r6.close()     // Catch:{ all -> 0x0044 }
            java.io.Closeable[] r1 = new java.io.Closeable[r4]
            r1[r3] = r6
            r1[r2] = r0
            r1[r9] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r1)
            return r7
        L_0x0044:
            r7 = move-exception
            goto L_0x0051
        L_0x0046:
            r7 = move-exception
            r6 = r1
            goto L_0x0051
        L_0x0049:
            r7 = move-exception
            r0 = r1
            r6 = r0
            goto L_0x0051
        L_0x004d:
            r7 = move-exception
            r0 = r1
            r5 = r0
            r6 = r5
        L_0x0051:
            com.mob.tools.log.NLog r8 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0064 }
            r8.d(r7)     // Catch:{ all -> 0x0064 }
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r3] = r6
            r4[r2] = r0
            r4[r9] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            goto L_0x0071
        L_0x0064:
            r1 = move-exception
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r3] = r6
            r4[r2] = r0
            r4[r9] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            throw r1
        L_0x0071:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.ResHelper.readObjectFromFile(java.lang.String):java.lang.Object");
    }

    public static void saveArrayListToFile(ArrayList<HashMap<String, String>> arrayList, String str) {
        saveArrayListToFile(arrayList, str, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.io.File} */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveObjectToFile(java.lang.String r7, java.lang.Object r8) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r1 = 0
            if (r0 != 0) goto L_0x009e
            r0 = 0
            r2 = 1
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0040 }
            r3.<init>(r7)     // Catch:{ all -> 0x0040 }
            boolean r7 = r3.exists()     // Catch:{ all -> 0x0040 }
            if (r7 == 0) goto L_0x0017
            r3.delete()     // Catch:{ all -> 0x0040 }
        L_0x0017:
            if (r8 != 0) goto L_0x001a
            return r2
        L_0x001a:
            java.io.File r7 = r3.getParentFile()     // Catch:{ all -> 0x0040 }
            boolean r7 = r7.exists()     // Catch:{ all -> 0x0040 }
            if (r7 == 0) goto L_0x002e
            java.io.File r7 = r3.getParentFile()     // Catch:{ all -> 0x0040 }
            boolean r7 = r7.isDirectory()     // Catch:{ all -> 0x0040 }
            if (r7 != 0) goto L_0x003c
        L_0x002e:
            java.io.File r7 = r3.getParentFile()     // Catch:{ all -> 0x0040 }
            r7.delete()     // Catch:{ all -> 0x0040 }
            java.io.File r7 = r3.getParentFile()     // Catch:{ all -> 0x0040 }
            r7.mkdirs()     // Catch:{ all -> 0x0040 }
        L_0x003c:
            r3.createNewFile()     // Catch:{ all -> 0x0040 }
            goto L_0x0049
        L_0x0040:
            r7 = move-exception
            com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()
            r3.d(r7)
            r3 = r0
        L_0x0049:
            if (r3 == 0) goto L_0x009e
            r7 = 2
            r4 = 3
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x007b }
            r5.<init>(r3)     // Catch:{ all -> 0x007b }
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0076 }
            r3.<init>(r5)     // Catch:{ all -> 0x0076 }
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0073 }
            r6.<init>(r3)     // Catch:{ all -> 0x0073 }
            r6.writeObject(r8)     // Catch:{ all -> 0x0071 }
            r6.flush()     // Catch:{ all -> 0x0071 }
            r6.close()     // Catch:{ all -> 0x0071 }
            java.io.Closeable[] r8 = new java.io.Closeable[r4]
            r8[r1] = r6
            r8[r2] = r3
            r8[r7] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r8)
            return r2
        L_0x0071:
            r8 = move-exception
            goto L_0x0079
        L_0x0073:
            r8 = move-exception
            r6 = r0
            goto L_0x0079
        L_0x0076:
            r8 = move-exception
            r3 = r0
            r6 = r3
        L_0x0079:
            r0 = r5
            goto L_0x007e
        L_0x007b:
            r8 = move-exception
            r3 = r0
            r6 = r3
        L_0x007e:
            com.mob.tools.log.NLog r5 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0091 }
            r5.d(r8)     // Catch:{ all -> 0x0091 }
            java.io.Closeable[] r8 = new java.io.Closeable[r4]
            r8[r1] = r6
            r8[r2] = r3
            r8[r7] = r0
            com.mob.commons.v.a((java.io.Closeable[]) r8)
            goto L_0x009e
        L_0x0091:
            r8 = move-exception
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r1] = r6
            r4[r2] = r3
            r4[r7] = r0
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            throw r8
        L_0x009e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.ResHelper.saveObjectToFile(java.lang.String, java.lang.Object):boolean");
    }

    @Deprecated
    public static long strToDate(String str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str, new ParsePosition(0)).getTime();
    }

    @Deprecated
    public static Bundle urlToBundle(String str) {
        String str2;
        int indexOf = str.indexOf("://");
        if (indexOf >= 0) {
            str2 = m.a("007fgghijj") + str.substring(indexOf + 1);
        } else {
            str2 = m.a("007fgghijj") + str;
        }
        try {
            URL url = new URL(str2);
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return new Bundle();
        }
    }

    @Deprecated
    public static Uri videoPathToContentUri(Context context, String str) {
        try {
            if (!DH.SyncMtd.checkPermission(m.a("040bc^babhbibgbabjKhd_bhbdbgdgdgbgbiFc9bjehegdbdjbfegeedaegehcedbdcbfcjdaefehdbgbeg"))) {
                return null;
            }
            Cursor query = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, (String) null);
            if (query != null && query.moveToFirst()) {
                int i11 = query.getInt(query.getColumnIndex("_id"));
                Uri parse = Uri.parse("content://media/external/video/media");
                return Uri.withAppendedPath(parse, "" + i11);
            } else if (!new File(str).exists()) {
                return null;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_data", str);
                return context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
            }
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.nio.channels.FileChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeToFileNoCompress(java.io.File r5, byte[] r6) {
        /*
            if (r5 == 0) goto L_0x0070
            if (r6 == 0) goto L_0x0070
            boolean r0 = r5.exists()
            if (r0 != 0) goto L_0x0027
            java.io.File r0 = r5.getParentFile()
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x001b
            java.io.File r0 = r5.getParentFile()
            r0.mkdirs()
        L_0x001b:
            r5.createNewFile()     // Catch:{ IOException -> 0x001f }
            goto L_0x0027
        L_0x001f:
            r0 = move-exception
            com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()
            r1.d(r0)
        L_0x0027:
            boolean r0 = r5.exists()
            if (r0 == 0) goto L_0x0070
            r0 = 0
            r1 = 0
            r2 = 2
            r3 = 1
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0052 }
            r4.<init>(r5)     // Catch:{ all -> 0x0052 }
            java.nio.channels.FileChannel r0 = r4.getChannel()     // Catch:{ all -> 0x004e }
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.wrap(r6)     // Catch:{ all -> 0x004e }
            r0.write(r5)     // Catch:{ all -> 0x004e }
            r0.force(r3)     // Catch:{ all -> 0x004e }
            java.io.Closeable[] r5 = new java.io.Closeable[r2]
            r5[r1] = r0
            r5[r3] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r5)
            goto L_0x0070
        L_0x004e:
            r5 = move-exception
            r6 = r0
            r0 = r4
            goto L_0x0054
        L_0x0052:
            r5 = move-exception
            r6 = r0
        L_0x0054:
            com.mob.tools.log.NLog r4 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0065 }
            r4.d(r5)     // Catch:{ all -> 0x0065 }
            java.io.Closeable[] r5 = new java.io.Closeable[r2]
            r5[r1] = r6
            r5[r3] = r0
            com.mob.commons.v.a((java.io.Closeable[]) r5)
            goto L_0x0070
        L_0x0065:
            r5 = move-exception
            java.io.Closeable[] r2 = new java.io.Closeable[r2]
            r2[r1] = r6
            r2[r3] = r0
            com.mob.commons.v.a((java.io.Closeable[]) r2)
            throw r5
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.ResHelper.writeToFileNoCompress(java.io.File, byte[]):void");
    }

    public static <T> T forceCast(Object obj, T t11) {
        if (obj != null) {
            try {
                if (!(obj instanceof Integer)) {
                    return obj;
                }
                return t11 instanceof Long ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
            } catch (Throwable unused) {
            }
        }
        return t11;
    }

    public static String getCacheRoot(Context context, boolean z11) {
        String str;
        if (z11) {
            str = null;
        } else {
            try {
                str = getDataCache(context);
            } catch (Throwable th2) {
                MobLog.getInstance().w(th2);
                return null;
            }
        }
        String sandboxPath = DH.SyncMtd.getSandboxPath();
        if (sandboxPath != null) {
            str = sandboxPath + m.a("001j") + "MobSDK";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        return str;
    }

    public static File getDataCacheFile(Context context, String str, boolean z11) {
        File file = new File(getDataCache(context), str);
        if (z11 && !file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return file;
    }

    @Deprecated
    public static int parseInt(String str, int i11) throws Throwable {
        return Integer.parseInt(str, i11);
    }

    @Deprecated
    public static long parseLong(String str, int i11) throws Throwable {
        return Long.parseLong(str, i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r9v6, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> readArrayListFromFile(java.lang.String r12, boolean r13) {
        /*
            java.lang.String r0 = "utf-8"
            android.content.Context r1 = com.mob.MobSDK.getContext()
            r2 = 0
            java.io.File r12 = getDataCacheFile(r1, r12, r2)
            boolean r1 = r12.exists()
            if (r1 == 0) goto L_0x009b
            long r3 = r12.length()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x009b
            r1 = 3
            r3 = 1
            r4 = 4
            r5 = 2
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0073 }
            r7.<init>()     // Catch:{ all -> 0x0073 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ all -> 0x0073 }
            r8.<init>(r12)     // Catch:{ all -> 0x0073 }
            java.util.zip.GZIPInputStream r12 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x006d }
            r12.<init>(r8)     // Catch:{ all -> 0x006d }
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ all -> 0x006a }
            r9.<init>(r12, r0)     // Catch:{ all -> 0x006a }
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ all -> 0x0067 }
            r10.<init>(r9)     // Catch:{ all -> 0x0067 }
            java.lang.String r6 = r10.readLine()     // Catch:{ all -> 0x0065 }
        L_0x003d:
            if (r6 == 0) goto L_0x0057
            if (r13 == 0) goto L_0x004b
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0065 }
            byte[] r6 = android.util.Base64.decode(r6, r5)     // Catch:{ all -> 0x0065 }
            r11.<init>(r6, r0)     // Catch:{ all -> 0x0065 }
            r6 = r11
        L_0x004b:
            java.util.HashMap r6 = com.mob.tools.utils.HashonHelper.fromJson(r6)     // Catch:{ all -> 0x0065 }
            r7.add(r6)     // Catch:{ all -> 0x0065 }
            java.lang.String r6 = r10.readLine()     // Catch:{ all -> 0x0065 }
            goto L_0x003d
        L_0x0057:
            java.io.Closeable[] r13 = new java.io.Closeable[r4]
            r13[r2] = r10
            r13[r3] = r9
            r13[r5] = r12
            r13[r1] = r8
            com.mob.commons.v.a((java.io.Closeable[]) r13)
            return r7
        L_0x0065:
            r13 = move-exception
            goto L_0x0071
        L_0x0067:
            r13 = move-exception
            r10 = r6
            goto L_0x0071
        L_0x006a:
            r13 = move-exception
            r9 = r6
            goto L_0x0070
        L_0x006d:
            r13 = move-exception
            r12 = r6
            r9 = r12
        L_0x0070:
            r10 = r9
        L_0x0071:
            r6 = r8
            goto L_0x0077
        L_0x0073:
            r13 = move-exception
            r12 = r6
            r9 = r12
            r10 = r9
        L_0x0077:
            com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x008c }
            r0.d(r13)     // Catch:{ all -> 0x008c }
            java.io.Closeable[] r13 = new java.io.Closeable[r4]
            r13[r2] = r10
            r13[r3] = r9
            r13[r5] = r12
            r13[r1] = r6
            com.mob.commons.v.a((java.io.Closeable[]) r13)
            goto L_0x009b
        L_0x008c:
            r13 = move-exception
            java.io.Closeable[] r0 = new java.io.Closeable[r4]
            r0[r2] = r10
            r0[r3] = r9
            r0[r5] = r12
            r0[r1] = r6
            com.mob.commons.v.a((java.io.Closeable[]) r0)
            throw r13
        L_0x009b:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.ResHelper.readArrayListFromFile(java.lang.String, boolean):java.util.ArrayList");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.io.OutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveArrayListToFile(java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> r9, java.lang.String r10, boolean r11) {
        /*
            java.lang.String r0 = "utf-8"
            android.content.Context r1 = com.mob.MobSDK.getContext()
            r2 = 1
            java.io.File r10 = getDataCacheFile(r1, r10, r2)
            r1 = 0
            r3 = 3
            r4 = 0
            r5 = 2
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x0062 }
            r6.<init>(r10)     // Catch:{ all -> 0x0062 }
            java.util.zip.GZIPOutputStream r10 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x005d }
            r10.<init>(r6)     // Catch:{ all -> 0x005d }
            java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x005a }
            r7.<init>(r10, r0)     // Catch:{ all -> 0x005a }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0058 }
        L_0x0022:
            boolean r4 = r9.hasNext()     // Catch:{ all -> 0x0058 }
            if (r4 == 0) goto L_0x004c
            java.lang.Object r4 = r9.next()     // Catch:{ all -> 0x0058 }
            java.util.HashMap r4 = (java.util.HashMap) r4     // Catch:{ all -> 0x0058 }
            java.lang.String r4 = com.mob.tools.utils.HashonHelper.fromHashMap(r4)     // Catch:{ all -> 0x0058 }
            if (r11 == 0) goto L_0x0042
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x0058 }
            byte[] r4 = r4.getBytes(r0)     // Catch:{ all -> 0x0058 }
            byte[] r4 = android.util.Base64.encode(r4, r5)     // Catch:{ all -> 0x0058 }
            r8.<init>(r4, r0)     // Catch:{ all -> 0x0058 }
            r4 = r8
        L_0x0042:
            java.io.Writer r4 = r7.append(r4)     // Catch:{ all -> 0x0058 }
            r8 = 10
            r4.append(r8)     // Catch:{ all -> 0x0058 }
            goto L_0x0022
        L_0x004c:
            java.io.Closeable[] r9 = new java.io.Closeable[r3]
            r9[r1] = r7
            r9[r2] = r10
            r9[r5] = r6
            com.mob.commons.v.a((java.io.Closeable[]) r9)
            goto L_0x0077
        L_0x0058:
            r9 = move-exception
            goto L_0x0060
        L_0x005a:
            r9 = move-exception
            r7 = r4
            goto L_0x0060
        L_0x005d:
            r9 = move-exception
            r10 = r4
            r7 = r10
        L_0x0060:
            r4 = r6
            goto L_0x0065
        L_0x0062:
            r9 = move-exception
            r10 = r4
            r7 = r10
        L_0x0065:
            com.mob.tools.log.NLog r11 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0078 }
            r11.d(r9)     // Catch:{ all -> 0x0078 }
            java.io.Closeable[] r9 = new java.io.Closeable[r3]
            r9[r1] = r7
            r9[r2] = r10
            r9[r5] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r9)
        L_0x0077:
            return
        L_0x0078:
            r9 = move-exception
            java.io.Closeable[] r11 = new java.io.Closeable[r3]
            r11[r1] = r7
            r11[r2] = r10
            r11[r5] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r11)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.ResHelper.saveArrayListToFile(java.util.ArrayList, java.lang.String, boolean):void");
    }

    @Deprecated
    public static long getFileSize(File file) throws Throwable {
        if (!file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        String[] list = file.list();
        int i11 = 0;
        for (String file2 : list) {
            i11 = (int) (((long) i11) + getFileSize(new File(file, file2)));
        }
        return (long) i11;
    }

    public static int designToDevice(Context context, float f11, int i11) {
        if (f28138a <= 0.0f) {
            f28138a = context.getResources().getDisplayMetrics().density;
        }
        return (int) (((((float) i11) * f28138a) / f11) + 0.5f);
    }

    public static void copyFile(FileInputStream fileInputStream, FileOutputStream fileOutputStream) throws Throwable {
        byte[] bArr = new byte[65536];
        int read = fileInputStream.read(bArr);
        while (read > 0) {
            fileOutputStream.write(bArr, 0, read);
            read = fileInputStream.read(bArr);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Deprecated
    public static String encodeUrl(ArrayList<KVPair<String>> arrayList) {
        if (arrayList == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        Iterator<KVPair<String>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            KVPair next = it2.next();
            if (i11 > 0) {
                sb2.append('&');
            }
            String str = next.name;
            String str2 = (String) next.value;
            if (str != null) {
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(Data.urlEncode(str) + ContainerUtils.KEY_VALUE_DELIMITER + Data.urlEncode(str2));
                i11++;
            }
        }
        return sb2.toString();
    }
}
