package com.jumio.core.environment;

import android.content.Context;
import android.os.Build;
import com.huobi.vulcan.model.VulcanInfo;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.util.SplitUtil;
import java.io.File;
import net.sf.scuba.smartcards.ISO7816;

public final class Environment {
    public static final String ALE_VERSION = "1.11.0";
    public static final String BUILD_NUMBER = "0-6";
    public static final String BUILD_VERSION = "4.8.2 (6)";
    public static final Environment INSTANCE = new Environment();
    public static final String IPROOV_VERSION = "8.5.2";
    public static final String JVISION_VERSION = "0.18.7";
    public static final String SARDINE_VERSION = "1.2.16";

    /* renamed from: a  reason: collision with root package name */
    public static final String f39133a = "/jumio/";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f39134b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f39135c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f39136d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f39137e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f39138f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f39139g = StringDeobfuscator.deobfuscate(new byte[]{-75, 121, -7, -44, 38, 97, -73, -37, 99, -41, -82, 41, 101, 95, -87, -11, -101, -47, -61, 65, -81, -11, 104, ISO7816.INS_DELETE_FILE, 73, -73, 93, 22}, 633805970385962911L);

    public static boolean a(Context context, String str) {
        try {
            SplitUtil splitUtil = SplitUtil.INSTANCE;
            if (splitUtil.getHasSplitCompat()) {
                splitUtil.loadLibrary(context, str);
            } else {
                System.loadLibrary(str);
            }
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        kotlin.io.b.a(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        kotlin.io.b.a(r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009f, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkOcrVersion(android.content.Context r11) {
        /*
            r10 = this;
            java.io.File r11 = r10.getDataDirectory(r11)
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "cv"
            r0.<init>(r11, r1)
            boolean r1 = r0.isFile()
            r2 = 0
            if (r1 != 0) goto L_0x0016
            java.lang.String r1 = ""
            goto L_0x007b
        L_0x0016:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003c }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x003c }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003c }
            r5.<init>(r0)     // Catch:{ Exception -> 0x003c }
            r4.<init>(r5)     // Catch:{ Exception -> 0x003c }
            r3.<init>(r4)     // Catch:{ Exception -> 0x003c }
            java.lang.String r4 = r3.readLine()     // Catch:{ all -> 0x0035 }
            r1.append(r4)     // Catch:{ all -> 0x0035 }
            kotlin.io.b.a(r3, r2)     // Catch:{ Exception -> 0x003c }
            goto L_0x0040
        L_0x0035:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0037 }
        L_0x0037:
            r5 = move-exception
            kotlin.io.b.a(r3, r4)     // Catch:{ Exception -> 0x003c }
            throw r5     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            r3 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r3)
        L_0x0040:
            java.lang.String r1 = r1.toString()
            int r3 = r1.length()
            r4 = 1
            int r3 = r3 - r4
            r5 = 0
            r6 = r5
            r7 = r6
        L_0x004d:
            if (r6 > r3) goto L_0x0072
            if (r7 != 0) goto L_0x0053
            r8 = r6
            goto L_0x0054
        L_0x0053:
            r8 = r3
        L_0x0054:
            char r8 = r1.charAt(r8)
            r9 = 32
            int r8 = kotlin.jvm.internal.x.c(r8, r9)
            if (r8 > 0) goto L_0x0062
            r8 = r4
            goto L_0x0063
        L_0x0062:
            r8 = r5
        L_0x0063:
            if (r7 != 0) goto L_0x006c
            if (r8 != 0) goto L_0x0069
            r7 = r4
            goto L_0x004d
        L_0x0069:
            int r6 = r6 + 1
            goto L_0x004d
        L_0x006c:
            if (r8 != 0) goto L_0x006f
            goto L_0x0072
        L_0x006f:
            int r3 = r3 + -1
            goto L_0x004d
        L_0x0072:
            int r3 = r3 + r4
            java.lang.CharSequence r1 = r1.subSequence(r6, r3)
            java.lang.String r1 = r1.toString()
        L_0x007b:
            java.lang.String r3 = "0.18.7"
            boolean r1 = kotlin.jvm.internal.x.b(r3, r1)
            if (r1 != 0) goto L_0x00a4
            a(r11)
            java.io.OutputStreamWriter r11 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x00a0 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00a0 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00a0 }
            r11.<init>(r1)     // Catch:{ Exception -> 0x00a0 }
            r11.write(r3)     // Catch:{ all -> 0x0099 }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0099 }
            kotlin.io.b.a(r11, r2)     // Catch:{ Exception -> 0x00a0 }
            goto L_0x00a4
        L_0x0099:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x009b }
        L_0x009b:
            r1 = move-exception
            kotlin.io.b.a(r11, r0)     // Catch:{ Exception -> 0x00a0 }
            throw r1     // Catch:{ Exception -> 0x00a0 }
        L_0x00a0:
            r11 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r11)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.environment.Environment.checkOcrVersion(android.content.Context):void");
    }

    public final String extractFile(Context context, String str, String str2, String str3) {
        return extractFile(context, Environment.class, str, str2, str3);
    }

    public final int getAndroidSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    public final String getCDN_URL() {
        return f39139g;
    }

    public final File getDataDirectory(Context context) {
        File file = new File(context.getFilesDir(), f39133a);
        if (file.isDirectory()) {
            file.mkdirs();
        }
        return file;
    }

    public final synchronized boolean loadAleLib(Context context) {
        if (!f39136d) {
            f39136d = a(context, "aleInterface");
        }
        return f39136d;
    }

    public final synchronized boolean loadCpuInfoLib(Context context) {
        if (!f39135c) {
            f39135c = a(context, VulcanInfo.CPUINFO);
        }
        return f39135c;
    }

    public final synchronized boolean loadDaClientLib(Context context) {
        if (!f39138f) {
            f39138f = a(context, "jumio_daclient");
        }
        return f39138f;
    }

    public final synchronized boolean loadJniImageQualityLib(Context context) {
        if (!f39137e) {
            f39137e = a(context, "JVImgJava");
        }
        return f39137e;
    }

    public final synchronized boolean loadJniJvCoreLib(Context context) {
        if (!f39134b) {
            f39134b = a(context, "c++_shared") && a(context, "JVCore") && a(context, "JVCoreJava");
        }
        return f39134b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.io.b.a(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0071, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String extractFile(android.content.Context r9, java.lang.Class<?> r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            r8 = this;
            java.io.File r0 = new java.io.File
            java.io.File r9 = r8.getDataDirectory(r9)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r11)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            r0.<init>(r9, r13)
            java.lang.String r9 = r0.getName()
            java.lang.String r13 = "_"
            r1 = 0
            r2 = 2
            r3 = 0
            boolean r9 = kotlin.text.StringsKt__StringsJVMKt.M(r9, r13, r1, r2, r3)
            r13 = 1
            if (r9 == 0) goto L_0x003a
            java.lang.String r9 = r0.getName()
            java.lang.String r9 = r9.substring(r13)
            java.io.File r4 = new java.io.File
            java.io.File r0 = r0.getParentFile()
            r4.<init>(r0, r9)
            r0 = r4
        L_0x003a:
            boolean r9 = r0.isFile()
            if (r9 != 0) goto L_0x0042
            r9 = r3
            goto L_0x008d
        L_0x0042:
            java.lang.String r9 = "SHA-256"
            java.security.MessageDigest r9 = java.security.MessageDigest.getInstance(r9)
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0072 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0072 }
            java.lang.String r6 = r0.getPath()     // Catch:{ Exception -> 0x0072 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0072 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0072 }
            r5 = 2048(0x800, float:2.87E-42)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x006b }
        L_0x005a:
            int r6 = r4.read(r5)     // Catch:{ all -> 0x006b }
            r7 = -1
            if (r6 == r7) goto L_0x0065
            r9.update(r5, r1, r6)     // Catch:{ all -> 0x006b }
            goto L_0x005a
        L_0x0065:
            kotlin.Unit r5 = kotlin.Unit.f56620a     // Catch:{ all -> 0x006b }
            kotlin.io.b.a(r4, r3)     // Catch:{ Exception -> 0x0072 }
            goto L_0x0076
        L_0x006b:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x006d }
        L_0x006d:
            r6 = move-exception
            kotlin.io.b.a(r4, r5)     // Catch:{ Exception -> 0x0072 }
            throw r6     // Catch:{ Exception -> 0x0072 }
        L_0x0072:
            r4 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r4)
        L_0x0076:
            java.math.BigInteger r4 = new java.math.BigInteger
            byte[] r9 = r9.digest()
            r4.<init>(r13, r9)
            r9 = 16
            java.lang.String r9 = r4.toString(r9)
            r13 = 32
            r4 = 48
            java.lang.String r9 = kotlin.text.StringsKt__StringsKt.u0(r9, r13, r4)
        L_0x008d:
            boolean r13 = r0.isFile()
            if (r13 == 0) goto L_0x0099
            boolean r9 = kotlin.jvm.internal.x.b(r12, r9)
            if (r9 != 0) goto L_0x00ba
        L_0x0099:
            boolean r9 = r0.isFile()
            if (r9 == 0) goto L_0x00a3
            r0.delete()
            goto L_0x00ac
        L_0x00a3:
            java.io.File r9 = r0.getParentFile()
            if (r9 == 0) goto L_0x00ac
            r9.mkdirs()
        L_0x00ac:
            java.io.InputStream r9 = r10.getResourceAsStream(r11)     // Catch:{ Exception -> 0x00bf }
            if (r9 == 0) goto L_0x00ba
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00bf }
            r10.<init>(r0)     // Catch:{ Exception -> 0x00bf }
            kotlin.io.a.b(r9, r10, r1, r2, r3)     // Catch:{ Exception -> 0x00bf }
        L_0x00ba:
            java.lang.String r9 = r0.getAbsolutePath()
            return r9
        L_0x00bf:
            r9 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.environment.Environment.extractFile(android.content.Context, java.lang.Class, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void a(File file) {
        File[] listFiles;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                }
                file2.delete();
            }
        }
    }
}
