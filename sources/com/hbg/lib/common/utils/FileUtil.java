package com.hbg.lib.common.utils;

import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.luck.picture.lib.config.PictureMimeType;
import i6.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {
    public static void a(String str) throws IOException {
        new ProcessBuilder(new String[]{"chmod", "777", str}).start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0113 A[SYNTHETIC, Splitter:B:103:0x0113] */
    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c9 A[SYNTHETIC, Splitter:B:63:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d3 A[SYNTHETIC, Splitter:B:68:0x00d3] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e3 A[SYNTHETIC, Splitter:B:77:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ed A[SYNTHETIC, Splitter:B:82:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f8 A[SYNTHETIC, Splitter:B:89:0x00f8] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0102 A[SYNTHETIC, Splitter:B:94:0x0102] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0109 A[SYNTHETIC, Splitter:B:98:0x0109] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:86:0x00f3=Splitter:B:86:0x00f3, B:60:0x00c4=Splitter:B:60:0x00c4, B:74:0x00de=Splitter:B:74:0x00de} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.lang.String r5, java.io.File r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 != 0) goto L_0x011c
            if (r6 != 0) goto L_0x000b
            goto L_0x011c
        L_0x000b:
            boolean r0 = r6.exists()
            if (r0 != 0) goto L_0x0012
            return r1
        L_0x0012:
            r0 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00dc, NoSuchAlgorithmException -> 0x00c2, all -> 0x00bf }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00dc, NoSuchAlgorithmException -> 0x00c2, all -> 0x00bf }
            java.lang.String r6 = "md5"
            java.security.MessageDigest r6 = java.security.MessageDigest.getInstance(r6)     // Catch:{ FileNotFoundException -> 0x00bb, IOException -> 0x00b7, NoSuchAlgorithmException -> 0x00b3, all -> 0x00ae }
            java.security.DigestInputStream r3 = new java.security.DigestInputStream     // Catch:{ FileNotFoundException -> 0x00bb, IOException -> 0x00b7, NoSuchAlgorithmException -> 0x00b3, all -> 0x00ae }
            r3.<init>(r2, r6)     // Catch:{ FileNotFoundException -> 0x00bb, IOException -> 0x00b7, NoSuchAlgorithmException -> 0x00b3, all -> 0x00ae }
            r6 = 4096(0x1000, float:5.74E-42)
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa, NoSuchAlgorithmException -> 0x00a8, all -> 0x00a6 }
        L_0x0027:
            int r0 = r3.read(r6)     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa, NoSuchAlgorithmException -> 0x00a8, all -> 0x00a6 }
            if (r0 <= 0) goto L_0x002e
            goto L_0x0027
        L_0x002e:
            java.security.MessageDigest r6 = r3.getMessageDigest()     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa, NoSuchAlgorithmException -> 0x00a8, all -> 0x00a6 }
            byte[] r6 = r6.digest()     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa, NoSuchAlgorithmException -> 0x00a8, all -> 0x00a6 }
            if (r6 == 0) goto L_0x003a
            r0 = 1
            goto L_0x003b
        L_0x003a:
            r0 = r1
        L_0x003b:
            r2.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0043:
            r3.close()     // Catch:{ Exception -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r2 = move-exception
            r2.printStackTrace()
        L_0x004b:
            if (r0 == 0) goto L_0x00a3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0052:
            int r2 = r6.length
            if (r1 >= r2) goto L_0x007b
            byte r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            java.lang.String r2 = java.lang.Integer.toHexString(r2)
            int r3 = r2.length()
            r4 = 2
            if (r3 >= r4) goto L_0x0075
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 48
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
        L_0x0075:
            r0.append(r2)
            int r1 = r1 + 1
            goto L_0x0052
        L_0x007b:
            java.lang.String r6 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "server-md5 = "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = ", local-md5 = "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "FileUtil"
            i6.d.c(r1, r0)
            boolean r1 = r6.equals(r5)
            goto L_0x0105
        L_0x00a3:
            r1 = r0
            goto L_0x0105
        L_0x00a6:
            r5 = move-exception
            goto L_0x00b0
        L_0x00a8:
            r5 = move-exception
            goto L_0x00b5
        L_0x00aa:
            r5 = move-exception
            goto L_0x00b9
        L_0x00ac:
            r5 = move-exception
            goto L_0x00bd
        L_0x00ae:
            r5 = move-exception
            r3 = r0
        L_0x00b0:
            r0 = r2
            goto L_0x0107
        L_0x00b3:
            r5 = move-exception
            r3 = r0
        L_0x00b5:
            r0 = r2
            goto L_0x00c4
        L_0x00b7:
            r5 = move-exception
            r3 = r0
        L_0x00b9:
            r0 = r2
            goto L_0x00de
        L_0x00bb:
            r5 = move-exception
            r3 = r0
        L_0x00bd:
            r0 = r2
            goto L_0x00f3
        L_0x00bf:
            r5 = move-exception
            r3 = r0
            goto L_0x0107
        L_0x00c2:
            r5 = move-exception
            r3 = r0
        L_0x00c4:
            r5.printStackTrace()     // Catch:{ all -> 0x0106 }
            if (r0 == 0) goto L_0x00d1
            r0.close()     // Catch:{ IOException -> 0x00cd }
            goto L_0x00d1
        L_0x00cd:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00d1:
            if (r3 == 0) goto L_0x0105
            r3.close()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x0105
        L_0x00d7:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0105
        L_0x00dc:
            r5 = move-exception
            r3 = r0
        L_0x00de:
            r5.printStackTrace()     // Catch:{ all -> 0x0106 }
            if (r0 == 0) goto L_0x00eb
            r0.close()     // Catch:{ IOException -> 0x00e7 }
            goto L_0x00eb
        L_0x00e7:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00eb:
            if (r3 == 0) goto L_0x0105
            r3.close()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x0105
        L_0x00f1:
            r5 = move-exception
            r3 = r0
        L_0x00f3:
            r5.printStackTrace()     // Catch:{ all -> 0x0106 }
            if (r0 == 0) goto L_0x0100
            r0.close()     // Catch:{ IOException -> 0x00fc }
            goto L_0x0100
        L_0x00fc:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0100:
            if (r3 == 0) goto L_0x0105
            r3.close()     // Catch:{ Exception -> 0x00d7 }
        L_0x0105:
            return r1
        L_0x0106:
            r5 = move-exception
        L_0x0107:
            if (r0 == 0) goto L_0x0111
            r0.close()     // Catch:{ IOException -> 0x010d }
            goto L_0x0111
        L_0x010d:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0111:
            if (r3 == 0) goto L_0x011b
            r3.close()     // Catch:{ Exception -> 0x0117 }
            goto L_0x011b
        L_0x0117:
            r6 = move-exception
            r6.printStackTrace()
        L_0x011b:
            throw r5
        L_0x011c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.utils.FileUtil.b(java.lang.String, java.io.File):boolean");
    }

    public static void c(File file) {
        if (file != null) {
            try {
                if (!file.exists()) {
                    return;
                }
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            if (file2.isFile()) {
                                file2.delete();
                            } else if (file2.isDirectory()) {
                                c(file2);
                                file2.delete();
                            }
                        }
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static void d(File file, File file2) {
        FileOutputStream fileOutputStream;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return;
                    }
                }
            } catch (Throwable th2) {
                fileInputStream.close();
                throw th2;
            }
            throw th;
        } catch (Exception e11) {
            e11.printStackTrace();
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
    }

    public static File e(File file) {
        try {
            if (file.exists()) {
                file.delete();
                file.createNewFile();
                return file;
            }
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            return file;
        } catch (IOException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static File f(String str, boolean z11) {
        File file = new File(g(str, z11));
        d.j("create temp file", file.getAbsolutePath());
        return file;
    }

    public static String g(String str, boolean z11) {
        String str2;
        if (!z11) {
            str2 = BaseApplication.b().getExternalCacheDir() + File.separator + "share_image";
        } else {
            str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + PictureMimeType.DCIM;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2 + File.separator + "share_" + System.currentTimeMillis() + PictureMimeType.PNG;
    }

    public static boolean h(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static Uri j(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String k(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb2.append(readLine);
                } else {
                    String sb3 = sb2.toString();
                    bufferedReader.close();
                    return sb3;
                }
            }
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
