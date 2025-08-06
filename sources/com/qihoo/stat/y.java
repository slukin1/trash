package com.qihoo.stat;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class y implements a {
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008d A[SYNTHETIC, Splitter:B:40:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a4 A[SYNTHETIC, Splitter:B:50:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ac A[SYNTHETIC, Splitter:B:54:0x00ac] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r7) {
        /*
            java.lang.String r0 = "Reader"
            if (r7 == 0) goto L_0x00b5
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0085 }
            java.lang.String r3 = "r"
            r2.<init>(r7, r3)     // Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x0085 }
            long r3 = r2.length()     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            r5 = 180(0xb4, double:8.9E-322)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x006f
            r7 = 180(0xb4, float:2.52E-43)
            byte[] r7 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            long r3 = r3 - r5
            r2.seek(r3)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            r2.readFully(r7)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            java.lang.String r1 = r7.toString()     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            com.qihoo.stat.w.a(r0, r1)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            java.lang.String r7 = c(r7)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            if (r7 == 0) goto L_0x006c
            int r1 = r7.length()     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            if (r1 <= 0) goto L_0x006c
            java.lang.String r1 = "err"
            boolean r1 = r7.startsWith(r1)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            if (r1 == 0) goto L_0x003d
            goto L_0x0071
        L_0x003d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            java.lang.String r3 = "qch_"
            r1.append(r3)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            r1.append(r7)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            java.lang.String r1 = r1.toString()     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            boolean r3 = g(r7)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            if (r3 == 0) goto L_0x0064
            boolean r7 = h(r7)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            if (r7 != 0) goto L_0x0062
            java.lang.String r7 = "Channel包含不支持字符"
            com.qihoo.stat.w.b(r0, r7)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            java.lang.String r7 = "err07"
            goto L_0x0071
        L_0x0062:
            r7 = r1
            goto L_0x0071
        L_0x0064:
            java.lang.String r7 = "Channel长度不合法"
            com.qihoo.stat.w.b(r0, r7)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            java.lang.String r7 = "err06"
            goto L_0x0071
        L_0x006c:
            java.lang.String r7 = "err09"
            goto L_0x0071
        L_0x006f:
            java.lang.String r7 = "qch_default1"
        L_0x0071:
            r2.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x00bc
        L_0x0075:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x00bc
        L_0x007a:
            r7 = move-exception
            r1 = r2
            goto L_0x00aa
        L_0x007d:
            r7 = move-exception
            r1 = r2
            goto L_0x0086
        L_0x0080:
            r7 = move-exception
            r1 = r2
            goto L_0x0098
        L_0x0083:
            r7 = move-exception
            goto L_0x00aa
        L_0x0085:
            r7 = move-exception
        L_0x0086:
            java.lang.String r2 = "err04"
            r7.printStackTrace()     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x0095
            r1.close()     // Catch:{ IOException -> 0x0091 }
            goto L_0x0095
        L_0x0091:
            r7 = move-exception
        L_0x0092:
            r7.printStackTrace()
        L_0x0095:
            r7 = r2
            goto L_0x00bc
        L_0x0097:
            r7 = move-exception
        L_0x0098:
            java.lang.String r2 = "读取APK文件异常，文件找不到"
            com.qihoo.stat.w.b(r0, r2)     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = "err02"
            r7.printStackTrace()     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x0095
            r1.close()     // Catch:{ IOException -> 0x00a8 }
            goto L_0x0095
        L_0x00a8:
            r7 = move-exception
            goto L_0x0092
        L_0x00aa:
            if (r1 == 0) goto L_0x00b4
            r1.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00b4
        L_0x00b0:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b4:
            throw r7
        L_0x00b5:
            java.lang.String r7 = "指定目录下APK文件找不到（不支持系统APK目录）"
            com.qihoo.stat.w.b(r0, r7)
            java.lang.String r7 = "err03"
        L_0x00bc:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "channel="
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            com.qihoo.stat.w.a(r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo.stat.y.a(java.io.File):java.lang.String");
    }

    public static String b(String str) {
        return a(i(str));
    }

    public static String c(byte[] bArr) {
        String str;
        byte[] bArr2;
        String str2;
        if (bArr == null) {
            return null;
        }
        f f11 = f(bArr);
        if (f11 != null) {
            int i11 = f11.f28729b;
            if (i11 < 0 || (bArr2 = f11.f28728a) == null) {
                byte[] bArr3 = f11.f28728a;
                if (bArr3 == null) {
                    return null;
                }
                try {
                    return new String(bArr3, "UTF-8");
                } catch (UnsupportedEncodingException e11) {
                    e11.printStackTrace();
                    str = "cbs.mBytes编码异常";
                }
            } else {
                String a11 = v.a(bArr2, "9CaP3uQ4");
                if (a11 == null || a11.length() <= 0) {
                    w.b("Reader", "解密异常，数据被篡改");
                    return "err10";
                }
                int i12 = a.f28699f;
                if (i11 < i12 + 32) {
                    str2 = "校验数据长度不够，跳过校验";
                } else if (e(bArr, i11 - i12, a.f28696c, i12)) {
                    byte[] bArr4 = new byte[32];
                    int i13 = 0;
                    int i14 = (i11 - i12) - 32;
                    while (i13 < 32) {
                        bArr4[i13] = (byte) (bArr[i14] + 96);
                        i13++;
                        i14++;
                    }
                    String str3 = new String(bArr4);
                    String a12 = x.a(a11);
                    if (a12 == null || a12.equals(str3)) {
                        return a11;
                    }
                    w.b("Reader", "校验失败，数据被篡改");
                    return "err01";
                } else {
                    str2 = "没有找到MM，跳过校验";
                }
                w.b("Reader", str2);
                return a11;
            }
        } else {
            str = "cbs=null，不应该到这里";
            w.a("Reader", str);
            return null;
        }
    }

    public static boolean d(char c11) {
        if (c11 >= '0' && c11 <= '9') {
            return true;
        }
        if (c11 < 'a' || c11 > 'z') {
            return (c11 >= 'A' && c11 <= 'Z') || c11 == '_';
        }
        return true;
    }

    public static boolean e(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int length;
        if (bArr == null || i11 < 0 || (length = bArr.length) <= 0 || length <= (i11 + i12) - 1) {
            return false;
        }
        int i13 = 0;
        while (i13 < i12) {
            if (bArr[i11] != bArr2[i13]) {
                return false;
            }
            i13++;
            i11++;
        }
        return true;
    }

    public static f f(byte[] bArr) {
        int i11;
        f fVar = new f();
        if (bArr != null) {
            int length = bArr.length;
            int i12 = a.f28697d;
            int i13 = a.f28698e;
            int i14 = (length - i12) - i13;
            int length2 = bArr.length - i13;
            if (i14 >= 0 && length2 > i12) {
                while (true) {
                    i11 = a.f28697d;
                    if (length2 < i11) {
                        length2 = -1;
                        break;
                    } else if (e(bArr, length2, a.f28695b, a.f28698e)) {
                        w.a("Reader", "endMagicStartIdx=" + length2);
                        break;
                    } else {
                        length2--;
                    }
                }
                if (length2 > 0) {
                    int i15 = length2 - i11;
                    while (true) {
                        if (i15 < 0) {
                            i15 = -1;
                            break;
                        } else if (e(bArr, i15, a.f28694a, a.f28697d)) {
                            w.a("Reader", "begMagicStartIdx=" + i15);
                            break;
                        } else {
                            i15--;
                        }
                    }
                    if (i15 >= 0) {
                        int i16 = a.f28697d;
                        int i17 = (length2 - i15) - i16;
                        if (i17 > 0) {
                            w.a("Reader", "chBytesLen=" + i17);
                            byte[] bArr2 = new byte[i17];
                            int i18 = 0;
                            int i19 = i16 + i15;
                            while (i18 < i17) {
                                bArr2[i18] = bArr[i19];
                                i18++;
                                i19++;
                            }
                            fVar.f28728a = bArr2;
                            fVar.f28729b = i15;
                        } else {
                            try {
                                w.b("Reader", "channel长度错误");
                                fVar.f28729b = -1;
                                fVar.f28728a = "err05".getBytes("UTF-8");
                            } catch (UnsupportedEncodingException e11) {
                                e11.printStackTrace();
                            }
                        }
                    } else {
                        w.b("Reader", "找不到BM，数据被篡改");
                        fVar.f28729b = -1;
                        fVar.f28728a = "err08".getBytes("UTF-8");
                    }
                } else {
                    w.b("Reader", "找不到EM，没有读到渠道，使用默认");
                    fVar.f28729b = -1;
                    fVar.f28728a = "default".getBytes("UTF-8");
                }
            }
        }
        return fVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r2 = r2.length();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean g(java.lang.String r2) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x0010
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0010
            r1 = 16
            if (r2 <= r1) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r2 = 1
            return r2
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo.stat.y.g(java.lang.String):boolean");
    }

    public static boolean h(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!d(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static File i(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return new File(str);
    }
}
