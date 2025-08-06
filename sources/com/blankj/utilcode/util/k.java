package com.blankj.utilcode.util;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static int f63540a = 524288;

    public interface a {
        void a(double d11);
    }

    public static byte[] a(File file) {
        return b(file, (a) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0073 A[SYNTHETIC, Splitter:B:42:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0087 A[SYNTHETIC, Splitter:B:55:0x0087] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(java.io.File r10, com.blankj.utilcode.util.k.a r11) {
        /*
            boolean r0 = com.blankj.utilcode.util.a0.x(r10)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0090 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0090 }
            r2.<init>(r10)     // Catch:{ FileNotFoundException -> 0x0090 }
            int r10 = f63540a     // Catch:{ FileNotFoundException -> 0x0090 }
            r0.<init>(r2, r10)     // Catch:{ FileNotFoundException -> 0x0090 }
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            r10.<init>()     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            int r2 = f63540a     // Catch:{ IOException -> 0x005f }
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x005f }
            r3 = -1
            r4 = 0
            if (r11 != 0) goto L_0x002d
        L_0x0021:
            int r11 = f63540a     // Catch:{ IOException -> 0x005f }
            int r11 = r0.read(r2, r4, r11)     // Catch:{ IOException -> 0x005f }
            if (r11 == r3) goto L_0x004a
            r10.write(r2, r4, r11)     // Catch:{ IOException -> 0x005f }
            goto L_0x0021
        L_0x002d:
            int r5 = r0.available()     // Catch:{ IOException -> 0x005f }
            double r5 = (double) r5     // Catch:{ IOException -> 0x005f }
            r7 = 0
            r11.a(r7)     // Catch:{ IOException -> 0x005f }
            r7 = r4
        L_0x0038:
            int r8 = f63540a     // Catch:{ IOException -> 0x005f }
            int r8 = r0.read(r2, r4, r8)     // Catch:{ IOException -> 0x005f }
            if (r8 == r3) goto L_0x004a
            r10.write(r2, r4, r8)     // Catch:{ IOException -> 0x005f }
            int r7 = r7 + r8
            double r8 = (double) r7     // Catch:{ IOException -> 0x005f }
            double r8 = r8 / r5
            r11.a(r8)     // Catch:{ IOException -> 0x005f }
            goto L_0x0038
        L_0x004a:
            byte[] r11 = r10.toByteArray()     // Catch:{ IOException -> 0x005f }
            r0.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ FileNotFoundException -> 0x0090 }
        L_0x0056:
            r10.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ FileNotFoundException -> 0x0090 }
        L_0x005e:
            return r11
        L_0x005f:
            r11 = move-exception
            goto L_0x0066
        L_0x0061:
            r11 = move-exception
            r10 = r1
            goto L_0x007d
        L_0x0064:
            r11 = move-exception
            r10 = r1
        L_0x0066:
            r11.printStackTrace()     // Catch:{ all -> 0x007c }
            r0.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ FileNotFoundException -> 0x0090 }
        L_0x0071:
            if (r10 == 0) goto L_0x007b
            r10.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ FileNotFoundException -> 0x0090 }
        L_0x007b:
            return r1
        L_0x007c:
            r11 = move-exception
        L_0x007d:
            r0.close()     // Catch:{ IOException -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ FileNotFoundException -> 0x0090 }
        L_0x0085:
            if (r10 == 0) goto L_0x008f
            r10.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ FileNotFoundException -> 0x0090 }
        L_0x008f:
            throw r11     // Catch:{ FileNotFoundException -> 0x0090 }
        L_0x0090:
            r10 = move-exception
            r10.printStackTrace()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.k.b(java.io.File, com.blankj.utilcode.util.k$a):byte[]");
    }

    public static String c(File file) {
        return d(file, (String) null);
    }

    public static String d(File file, String str) {
        byte[] a11 = a(file);
        if (a11 == null) {
            return null;
        }
        if (a0.C(str)) {
            return new String(a11);
        }
        try {
            return new String(a11, str);
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static boolean e(File file, InputStream inputStream) {
        return f(file, inputStream, false, (a) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0070 A[SYNTHETIC, Splitter:B:41:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0083 A[SYNTHETIC, Splitter:B:51:0x0083] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean f(java.io.File r7, java.io.InputStream r8, boolean r9, com.blankj.utilcode.util.k.a r10) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x008c
            boolean r1 = com.blankj.utilcode.util.a0.c(r7)
            if (r1 != 0) goto L_0x000b
            goto L_0x008c
        L_0x000b:
            r1 = 0
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0062 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0062 }
            r3.<init>(r7, r9)     // Catch:{ IOException -> 0x0062 }
            int r7 = f63540a     // Catch:{ IOException -> 0x0062 }
            r2.<init>(r3, r7)     // Catch:{ IOException -> 0x0062 }
            r7 = -1
            if (r10 != 0) goto L_0x0029
            int r9 = f63540a     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            byte[] r9 = new byte[r9]     // Catch:{ IOException -> 0x005d, all -> 0x005a }
        L_0x001f:
            int r10 = r8.read(r9)     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            if (r10 == r7) goto L_0x0048
            r2.write(r9, r0, r10)     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            goto L_0x001f
        L_0x0029:
            int r9 = r8.available()     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            double r3 = (double) r9     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            r5 = 0
            r10.a(r5)     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            int r9 = f63540a     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            byte[] r9 = new byte[r9]     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            r1 = r0
        L_0x0038:
            int r5 = r8.read(r9)     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            if (r5 == r7) goto L_0x0048
            r2.write(r9, r0, r5)     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            int r1 = r1 + r5
            double r5 = (double) r1     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            double r5 = r5 / r3
            r10.a(r5)     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            goto L_0x0038
        L_0x0048:
            r7 = 1
            r8.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0051:
            r2.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0059:
            return r7
        L_0x005a:
            r7 = move-exception
            r1 = r2
            goto L_0x0079
        L_0x005d:
            r7 = move-exception
            r1 = r2
            goto L_0x0063
        L_0x0060:
            r7 = move-exception
            goto L_0x0079
        L_0x0062:
            r7 = move-exception
        L_0x0063:
            r7.printStackTrace()     // Catch:{ all -> 0x0060 }
            r8.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r7 = move-exception
            r7.printStackTrace()
        L_0x006e:
            if (r1 == 0) goto L_0x0078
            r1.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0078:
            return r0
        L_0x0079:
            r8.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0081:
            if (r1 == 0) goto L_0x008b
            r1.close()     // Catch:{ IOException -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r8 = move-exception
            r8.printStackTrace()
        L_0x008b:
            throw r7
        L_0x008c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "create file <"
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = "> failed."
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.String r8 = "FileIOUtils"
            android.util.Log.e(r8, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.k.f(java.io.File, java.io.InputStream, boolean, com.blankj.utilcode.util.k$a):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e A[SYNTHETIC, Splitter:B:27:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0059 A[SYNTHETIC, Splitter:B:33:0x0059] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean g(java.io.File r4, java.lang.String r5, boolean r6) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0062
            if (r5 != 0) goto L_0x0006
            goto L_0x0062
        L_0x0006:
            boolean r1 = com.blankj.utilcode.util.a0.c(r4)
            if (r1 != 0) goto L_0x0028
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "create file <"
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = "> failed."
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "FileIOUtils"
            android.util.Log.e(r5, r4)
            return r0
        L_0x0028:
            r1 = 0
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x0048 }
            java.io.FileWriter r3 = new java.io.FileWriter     // Catch:{ IOException -> 0x0048 }
            r3.<init>(r4, r6)     // Catch:{ IOException -> 0x0048 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0048 }
            r2.write(r5)     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            r4 = 1
            r2.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x003f:
            return r4
        L_0x0040:
            r4 = move-exception
            r1 = r2
            goto L_0x0057
        L_0x0043:
            r4 = move-exception
            r1 = r2
            goto L_0x0049
        L_0x0046:
            r4 = move-exception
            goto L_0x0057
        L_0x0048:
            r4 = move-exception
        L_0x0049:
            r4.printStackTrace()     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0056
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0056:
            return r0
        L_0x0057:
            if (r1 == 0) goto L_0x0061
            r1.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0061:
            throw r4
        L_0x0062:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.k.g(java.io.File, java.lang.String, boolean):boolean");
    }

    public static boolean h(String str, String str2, boolean z11) {
        return g(a0.k(str), str2, z11);
    }
}
