package com.huobi.vulcan.utils;

import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.io.IOException;

public class FileUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f20608a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static boolean a(File file, File file2) {
        return b(file, file2, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0056 A[SYNTHETIC, Splitter:B:40:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0060 A[SYNTHETIC, Splitter:B:45:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x006c A[SYNTHETIC, Splitter:B:52:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0076 A[SYNTHETIC, Splitter:B:57:0x0076] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.io.File r4, java.io.File r5, boolean r6) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x007f
            boolean r1 = r4.exists()
            if (r1 == 0) goto L_0x007f
            boolean r1 = r4.isFile()
            if (r1 != 0) goto L_0x0011
            goto L_0x007f
        L_0x0011:
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            r2.<init>(r4)     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x004a }
            r3.<init>(r5)     // Catch:{ Exception -> 0x004a }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
        L_0x0020:
            int r1 = r2.read(r5)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            if (r1 <= 0) goto L_0x002a
            r3.write(r5, r0, r1)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            goto L_0x0020
        L_0x002a:
            r3.flush()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            if (r6 == 0) goto L_0x0032
            r4.delete()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
        L_0x0032:
            r3.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r4 = move-exception
            com.huobi.vulcan.utils.LogUtils.b(r4)
        L_0x003a:
            r2.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r4 = move-exception
            com.huobi.vulcan.utils.LogUtils.b(r4)
        L_0x0042:
            r4 = 1
            return r4
        L_0x0044:
            r4 = move-exception
            r1 = r3
            goto L_0x006a
        L_0x0047:
            r4 = move-exception
            r1 = r3
            goto L_0x0051
        L_0x004a:
            r4 = move-exception
            goto L_0x0051
        L_0x004c:
            r4 = move-exception
            r2 = r1
            goto L_0x006a
        L_0x004f:
            r4 = move-exception
            r2 = r1
        L_0x0051:
            com.huobi.vulcan.utils.LogUtils.b(r4)     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x005e
            r1.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r4 = move-exception
            com.huobi.vulcan.utils.LogUtils.b(r4)
        L_0x005e:
            if (r2 == 0) goto L_0x0068
            r2.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r4 = move-exception
            com.huobi.vulcan.utils.LogUtils.b(r4)
        L_0x0068:
            return r0
        L_0x0069:
            r4 = move-exception
        L_0x006a:
            if (r1 == 0) goto L_0x0074
            r1.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r5 = move-exception
            com.huobi.vulcan.utils.LogUtils.b(r5)
        L_0x0074:
            if (r2 == 0) goto L_0x007e
            r2.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r5 = move-exception
            com.huobi.vulcan.utils.LogUtils.b(r5)
        L_0x007e:
            throw r4
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.vulcan.utils.FileUtils.b(java.io.File, java.io.File, boolean):boolean");
    }

    public static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return a(new File(str), new File(str2));
    }

    public static boolean d(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            try {
                if (file.exists() && !file.delete()) {
                    return false;
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    public static boolean e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).exists();
        } catch (Exception e11) {
            LogUtils.b(e11);
            return false;
        }
    }

    public static long f(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            return -1;
        }
        return file.length();
    }

    public static String g(String str, String str2) {
        int lastIndexOf = str.lastIndexOf(InstructionFileId.DOT);
        if (lastIndexOf < 0) {
            lastIndexOf = str.length();
        }
        return str.substring(0, lastIndexOf) + "_" + str2 + str.substring(lastIndexOf);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002b A[SYNTHETIC, Splitter:B:18:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0038 A[SYNTHETIC, Splitter:B:24:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String h(java.lang.String r2) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0025 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0025 }
            int r2 = r1.available()     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r1.read(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r1.close()     // Catch:{ IOException -> 0x0018 }
            goto L_0x0035
        L_0x0018:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x0035
        L_0x001d:
            r2 = move-exception
            r0 = r1
            goto L_0x0036
        L_0x0020:
            r2 = move-exception
            r0 = r1
            goto L_0x0026
        L_0x0023:
            r2 = move-exception
            goto L_0x0036
        L_0x0025:
            r2 = move-exception
        L_0x0026:
            com.huobi.vulcan.utils.LogUtils.b(r2)     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0033
            r0.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0033:
            java.lang.String r0 = ""
        L_0x0035:
            return r0
        L_0x0036:
            if (r0 == 0) goto L_0x0040
            r0.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0040:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.vulcan.utils.FileUtils.h(java.lang.String):java.lang.String");
    }

    public static boolean i(File file, String str) throws IOException {
        String absolutePath = file.getAbsolutePath();
        String c11 = StringUtils.c(file.lastModified(), str);
        if (c11.equals(StringUtils.c(System.currentTimeMillis(), str))) {
            return false;
        }
        File file2 = new File(file.getParentFile(), g(file.getName(), c11));
        boolean renameTo = file.renameTo(file2);
        LogUtils.e("renameTo:" + file2.getAbsolutePath() + "  result is " + renameTo);
        new File(absolutePath).createNewFile();
        return true;
    }

    public static boolean j(String str, String str2, boolean z11) {
        return k(str, str2, z11, 241);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0072 A[SYNTHETIC, Splitter:B:40:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007c A[SYNTHETIC, Splitter:B:46:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0086 A[SYNTHETIC, Splitter:B:52:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x008c A[SYNTHETIC, Splitter:B:56:0x008c] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:49:0x0081=Splitter:B:49:0x0081, B:43:0x0077=Splitter:B:43:0x0077, B:37:0x006d=Splitter:B:37:0x006d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean k(java.lang.String r4, java.lang.String r5, boolean r6, int r7) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            r5 = 0
            boolean r2 = r0.exists()     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x0076, Exception -> 0x006c }
            if (r2 == 0) goto L_0x0031
            if (r6 != 0) goto L_0x001d
            r0.delete()     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x0076, Exception -> 0x006c }
            r0.createNewFile()     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x0076, Exception -> 0x006c }
            goto L_0x0034
        L_0x001d:
            r6 = 242(0xf2, float:3.39E-43)
            if (r7 != r6) goto L_0x0027
            java.lang.String r6 = "yyyy-MM-dd"
            i(r0, r6)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x0076, Exception -> 0x006c }
            goto L_0x0034
        L_0x0027:
            r6 = 243(0xf3, float:3.4E-43)
            if (r7 != r6) goto L_0x0034
            java.lang.String r6 = "yyyy-MM-dd HH"
            i(r0, r6)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x0076, Exception -> 0x006c }
            goto L_0x0034
        L_0x0031:
            r0.createNewFile()     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x0076, Exception -> 0x006c }
        L_0x0034:
            boolean r6 = r0.canWrite()     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x0076, Exception -> 0x006c }
            if (r6 == 0) goto L_0x005f
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x0076, Exception -> 0x006c }
            java.lang.String r7 = "rw"
            r6.<init>(r0, r7)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x0076, Exception -> 0x006c }
            long r2 = r6.length()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0059, Exception -> 0x0056, all -> 0x0053 }
            r6.seek(r2)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0059, Exception -> 0x0056, all -> 0x0053 }
            byte[] r4 = r4.getBytes()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0059, Exception -> 0x0056, all -> 0x0053 }
            r6.write(r4)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0059, Exception -> 0x0056, all -> 0x0053 }
            r4 = 1
            r1 = r4
            r5 = r6
            goto L_0x005f
        L_0x0053:
            r4 = move-exception
            r5 = r6
            goto L_0x008a
        L_0x0056:
            r4 = move-exception
            r5 = r6
            goto L_0x006d
        L_0x0059:
            r4 = move-exception
            r5 = r6
            goto L_0x0077
        L_0x005c:
            r4 = move-exception
            r5 = r6
            goto L_0x0081
        L_0x005f:
            if (r5 == 0) goto L_0x0089
            r5.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0089
        L_0x0065:
            r4 = move-exception
            com.huobi.vulcan.utils.LogUtils.b(r4)
            goto L_0x0089
        L_0x006a:
            r4 = move-exception
            goto L_0x008a
        L_0x006c:
            r4 = move-exception
        L_0x006d:
            com.huobi.vulcan.utils.LogUtils.b(r4)     // Catch:{ all -> 0x006a }
            if (r5 == 0) goto L_0x0089
            r5.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0089
        L_0x0076:
            r4 = move-exception
        L_0x0077:
            com.huobi.vulcan.utils.LogUtils.b(r4)     // Catch:{ all -> 0x006a }
            if (r5 == 0) goto L_0x0089
            r5.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0089
        L_0x0080:
            r4 = move-exception
        L_0x0081:
            com.huobi.vulcan.utils.LogUtils.b(r4)     // Catch:{ all -> 0x006a }
            if (r5 == 0) goto L_0x0089
            r5.close()     // Catch:{ IOException -> 0x0065 }
        L_0x0089:
            return r1
        L_0x008a:
            if (r5 == 0) goto L_0x0094
            r5.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0094
        L_0x0090:
            r5 = move-exception
            com.huobi.vulcan.utils.LogUtils.b(r5)
        L_0x0094:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.vulcan.utils.FileUtils.k(java.lang.String, java.lang.String, boolean, int):boolean");
    }
}
