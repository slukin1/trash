package com.hbg.module.libkt.utils;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;
import kotlin.jvm.internal.x;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f24909a = new n();

    /* renamed from: b  reason: collision with root package name */
    public static String f24910b;

    /* renamed from: c  reason: collision with root package name */
    public static String f24911c;

    public static final boolean a(String str) {
        String str2 = f24910b;
        if (str2 != null) {
            return x.b(str2, str);
        }
        String b11 = b("ro.miui.ui.version.name");
        f24911c = b11;
        if (!TextUtils.isEmpty(b11)) {
            f24910b = "MIUI";
        } else {
            String b12 = b("ro.build.version.emui");
            f24911c = b12;
            if (!TextUtils.isEmpty(b12)) {
                f24910b = "EMUI";
            } else {
                String b13 = b("ro.build.version.opporom");
                f24911c = b13;
                if (!TextUtils.isEmpty(b13)) {
                    f24910b = "OPPO";
                } else {
                    String b14 = b("ro.vivo.os.version");
                    f24911c = b14;
                    if (!TextUtils.isEmpty(b14)) {
                        f24910b = "VIVO";
                    } else {
                        String b15 = b("ro.smartisan.version");
                        f24911c = b15;
                        if (!TextUtils.isEmpty(b15)) {
                            f24910b = "SMARTISAN";
                        } else {
                            String str3 = Build.DISPLAY;
                            f24911c = str3;
                            if (str3 == null || !StringsKt__StringsKt.R(str3.toUpperCase(Locale.getDefault()), "FLYME", false, 2, (Object) null)) {
                                f24911c = "unknown";
                                f24910b = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
                            } else {
                                f24910b = "FLYME";
                            }
                        }
                    }
                }
            }
        }
        return x.b(f24910b, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043 A[SYNTHETIC, Splitter:B:16:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String b(java.lang.String r4) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x003c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            r2.<init>()     // Catch:{ all -> 0x003c }
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch:{ all -> 0x003c }
            r2.append(r4)     // Catch:{ all -> 0x003c }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x003c }
            java.lang.Process r4 = r1.exec(r4)     // Catch:{ all -> 0x003c }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x003c }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x003c }
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x003c }
            r2.<init>(r4)     // Catch:{ all -> 0x003c }
            r4 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2, r4)     // Catch:{ all -> 0x003c }
            java.lang.String r4 = r1.readLine()     // Catch:{ all -> 0x003a }
            r1.close()     // Catch:{ all -> 0x003a }
            r1.close()     // Catch:{ all -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0039:
            return r4
        L_0x003a:
            r4 = move-exception
            goto L_0x003e
        L_0x003c:
            r4 = move-exception
            r1 = r0
        L_0x003e:
            r4.printStackTrace()     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x004b
            r1.close()     // Catch:{ all -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r4 = move-exception
            r4.printStackTrace()
        L_0x004b:
            return r0
        L_0x004c:
            r4 = move-exception
            if (r1 == 0) goto L_0x0057
            r1.close()     // Catch:{ all -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0057:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.utils.n.b(java.lang.String):java.lang.String");
    }

    public static final boolean c() {
        return a("FLYME");
    }

    public static final boolean d() {
        return a("MIUI");
    }
}
