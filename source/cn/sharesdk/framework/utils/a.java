package cn.sharesdk.framework.utils;

import android.os.Build;
import android.text.TextUtils;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f13504a;

    /* renamed from: b  reason: collision with root package name */
    private static String f13505b;

    public static boolean a() {
        return a("MIUI");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x007c A[SYNTHETIC, Splitter:B:17:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009e A[SYNTHETIC, Splitter:B:25:0x009e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r8) {
        /*
            java.lang.String r0 = "CheckRomAll getProp finally catch "
            r1 = 0
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            r4.<init>()     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            java.lang.String r5 = "getprop "
            r4.append(r5)     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            r4.append(r8)     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            java.lang.Process r3 = r3.exec(r4)     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            java.io.InputStream r3 = r3.getInputStream()     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            r5.<init>(r3)     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            r3 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5, r3)     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            java.lang.String r3 = r4.readLine()     // Catch:{ IOException -> 0x0052 }
            r4.close()     // Catch:{ IOException -> 0x0052 }
            r4.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x0051
        L_0x0038:
            r8 = move-exception
            cn.sharesdk.framework.utils.SSDKLog r1 = cn.sharesdk.framework.utils.SSDKLog.b()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r1.a(r8, r0)
        L_0x0051:
            return r3
        L_0x0052:
            r3 = move-exception
            goto L_0x0058
        L_0x0054:
            r8 = move-exception
            goto L_0x009c
        L_0x0056:
            r3 = move-exception
            r4 = r1
        L_0x0058:
            cn.sharesdk.framework.utils.SSDKLog r5 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r6.<init>()     // Catch:{ all -> 0x009a }
            java.lang.String r7 = "CheckRomAll unable to read prop "
            r6.append(r7)     // Catch:{ all -> 0x009a }
            r6.append(r8)     // Catch:{ all -> 0x009a }
            java.lang.String r8 = " ex "
            r6.append(r8)     // Catch:{ all -> 0x009a }
            r6.append(r3)     // Catch:{ all -> 0x009a }
            java.lang.String r8 = r6.toString()     // Catch:{ all -> 0x009a }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x009a }
            r5.a(r8, r3)     // Catch:{ all -> 0x009a }
            if (r4 == 0) goto L_0x0099
            r4.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0099
        L_0x0080:
            r8 = move-exception
            cn.sharesdk.framework.utils.SSDKLog r3 = cn.sharesdk.framework.utils.SSDKLog.b()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r3.a(r8, r0)
        L_0x0099:
            return r1
        L_0x009a:
            r8 = move-exception
            r1 = r4
        L_0x009c:
            if (r1 == 0) goto L_0x00bb
            r1.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00bb
        L_0x00a2:
            r1 = move-exception
            cn.sharesdk.framework.utils.SSDKLog r3 = cn.sharesdk.framework.utils.SSDKLog.b()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r3.a(r0, r1)
        L_0x00bb:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.utils.a.b(java.lang.String):java.lang.String");
    }

    public static boolean a(String str) {
        String str2 = f13504a;
        if (str2 != null) {
            return str2.equals(str);
        }
        String b11 = b("ro.miui.ui.version.name");
        f13505b = b11;
        if (!TextUtils.isEmpty(b11)) {
            f13504a = "MIUI";
        } else {
            String b12 = b("ro.build.version.emui");
            f13505b = b12;
            if (!TextUtils.isEmpty(b12)) {
                f13504a = "EMUI";
            } else {
                String b13 = b("ro.build.version.opporom");
                f13505b = b13;
                if (!TextUtils.isEmpty(b13)) {
                    f13504a = "OPPO";
                } else {
                    String b14 = b("ro.vivo.os.version");
                    f13505b = b14;
                    if (!TextUtils.isEmpty(b14)) {
                        f13504a = "VIVO";
                    } else {
                        String b15 = b("ro.smartisan.version");
                        f13505b = b15;
                        if (!TextUtils.isEmpty(b15)) {
                            f13504a = "SMARTISAN";
                        } else {
                            String str3 = Build.DISPLAY;
                            f13505b = str3;
                            if (str3.toUpperCase().contains("FLYME")) {
                                f13504a = "FLYME";
                            } else {
                                f13505b = "unknown";
                                f13504a = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return f13504a.equals(str);
    }
}
