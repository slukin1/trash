package com.huawei.hms.framework.common;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CreateFileUtil {
    private static final String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
    private static final String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
    private static final String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
    private static final String TAG = "CreateFileUtil";

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        int i11 = 0;
        for (byte b11 : bArr) {
            int i12 = i11 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i11] = cArr2[(b11 >>> 4) & 15];
            i11 = i12 + 1;
            cArr[i12] = cArr2[b11 & 15];
        }
        return new String(cArr);
    }

    public static void deleteSecure(File file) {
        if (file != null && file.exists() && !file.delete()) {
            Logger.w(TAG, "deleteSecure exception");
        }
    }

    public static String getCacheDirPath(Context context) {
        return context == null ? "" : ContextCompat.getProtectedStorageContext(context).getCacheDir().getPath();
    }

    public static String getCanonicalPath(String str) {
        try {
            return newFile(str).getCanonicalPath();
        } catch (IOException e11) {
            Logger.w(TAG, "the canonicalPath has IOException", (Throwable) e11);
            return str;
        } catch (SecurityException e12) {
            Logger.w(TAG, "the canonicalPath has securityException", (Throwable) e12);
            return str;
        } catch (Exception e13) {
            Logger.w(TAG, "the canonicalPath has other Exception", (Throwable) e13);
            return str;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0074, code lost:
        if (r10 != null) goto L_0x002e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004e A[Catch:{ NoSuchAlgorithmException -> 0x006d, FileNotFoundException -> 0x0063, IOException -> 0x0059, IllegalArgumentException -> 0x004f, IndexOutOfBoundsException -> 0x0045, all -> 0x0043, all -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0058 A[Catch:{ NoSuchAlgorithmException -> 0x006d, FileNotFoundException -> 0x0063, IOException -> 0x0059, IllegalArgumentException -> 0x004f, IndexOutOfBoundsException -> 0x0045, all -> 0x0043, all -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0062 A[Catch:{ NoSuchAlgorithmException -> 0x006d, FileNotFoundException -> 0x0063, IOException -> 0x0059, IllegalArgumentException -> 0x004f, IndexOutOfBoundsException -> 0x0045, all -> 0x0043, all -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x006c A[Catch:{ NoSuchAlgorithmException -> 0x006d, FileNotFoundException -> 0x0063, IOException -> 0x0059, IllegalArgumentException -> 0x004f, IndexOutOfBoundsException -> 0x0045, all -> 0x0043, all -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x007a A[SYNTHETIC, Splitter:B:52:0x007a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileHashData(java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "Close FileInputStream failed!"
            java.lang.String r1 = "CreateFileUtil"
            r2 = 0
            java.security.MessageDigest r11 = java.security.MessageDigest.getInstance(r11)     // Catch:{ NoSuchAlgorithmException -> 0x006d, FileNotFoundException -> 0x0063, IOException -> 0x0059, IllegalArgumentException -> 0x004f, IndexOutOfBoundsException -> 0x0045, all -> 0x0043 }
            java.io.FileInputStream r10 = newSafeFileInputStream(r10)     // Catch:{ NoSuchAlgorithmException -> 0x006d, FileNotFoundException -> 0x0063, IOException -> 0x0059, IllegalArgumentException -> 0x004f, IndexOutOfBoundsException -> 0x0045, all -> 0x0043 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ NoSuchAlgorithmException -> 0x0041, FileNotFoundException -> 0x003f, IOException -> 0x003d, IllegalArgumentException -> 0x003b, IndexOutOfBoundsException -> 0x0039 }
            r4 = 0
            r6 = r4
        L_0x0014:
            int r8 = r10.read(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0041, FileNotFoundException -> 0x003f, IOException -> 0x003d, IllegalArgumentException -> 0x003b, IndexOutOfBoundsException -> 0x0039 }
            r9 = -1
            if (r8 == r9) goto L_0x0022
            r9 = 0
            r11.update(r3, r9, r8)     // Catch:{ NoSuchAlgorithmException -> 0x0041, FileNotFoundException -> 0x003f, IOException -> 0x003d, IllegalArgumentException -> 0x003b, IndexOutOfBoundsException -> 0x0039 }
            long r8 = (long) r8     // Catch:{ NoSuchAlgorithmException -> 0x0041, FileNotFoundException -> 0x003f, IOException -> 0x003d, IllegalArgumentException -> 0x003b, IndexOutOfBoundsException -> 0x0039 }
            long r6 = r6 + r8
            goto L_0x0014
        L_0x0022:
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x002e
            byte[] r11 = r11.digest()     // Catch:{ NoSuchAlgorithmException -> 0x0041, FileNotFoundException -> 0x003f, IOException -> 0x003d, IllegalArgumentException -> 0x003b, IndexOutOfBoundsException -> 0x0039 }
            java.lang.String r2 = byteArrayToHex(r11)     // Catch:{ NoSuchAlgorithmException -> 0x0041, FileNotFoundException -> 0x003f, IOException -> 0x003d, IllegalArgumentException -> 0x003b, IndexOutOfBoundsException -> 0x0039 }
        L_0x002e:
            r10.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0077
        L_0x0032:
            com.huawei.hms.framework.common.Logger.e(r1, r0)
            goto L_0x0077
        L_0x0036:
            r11 = move-exception
            r2 = r10
            goto L_0x0078
        L_0x0039:
            r11 = move-exception
            goto L_0x0047
        L_0x003b:
            r11 = move-exception
            goto L_0x0051
        L_0x003d:
            r11 = move-exception
            goto L_0x005b
        L_0x003f:
            r11 = move-exception
            goto L_0x0065
        L_0x0041:
            r11 = move-exception
            goto L_0x006f
        L_0x0043:
            r11 = move-exception
            goto L_0x0078
        L_0x0045:
            r11 = move-exception
            r10 = r2
        L_0x0047:
            java.lang.String r3 = "getFileHashData IndexOutOfBoundsException"
            com.huawei.hms.framework.common.Logger.e((java.lang.String) r1, (java.lang.String) r3, (java.lang.Throwable) r11)     // Catch:{ all -> 0x0036 }
            if (r10 == 0) goto L_0x0077
            goto L_0x002e
        L_0x004f:
            r11 = move-exception
            r10 = r2
        L_0x0051:
            java.lang.String r3 = "getFileHashData IllegalArgumentException"
            com.huawei.hms.framework.common.Logger.e((java.lang.String) r1, (java.lang.String) r3, (java.lang.Throwable) r11)     // Catch:{ all -> 0x0036 }
            if (r10 == 0) goto L_0x0077
            goto L_0x002e
        L_0x0059:
            r11 = move-exception
            r10 = r2
        L_0x005b:
            java.lang.String r3 = "getFileHashData IOException"
            com.huawei.hms.framework.common.Logger.e((java.lang.String) r1, (java.lang.String) r3, (java.lang.Throwable) r11)     // Catch:{ all -> 0x0036 }
            if (r10 == 0) goto L_0x0077
            goto L_0x002e
        L_0x0063:
            r11 = move-exception
            r10 = r2
        L_0x0065:
            java.lang.String r3 = "getFileHashData FileNotFoundException"
            com.huawei.hms.framework.common.Logger.e((java.lang.String) r1, (java.lang.String) r3, (java.lang.Throwable) r11)     // Catch:{ all -> 0x0036 }
            if (r10 == 0) goto L_0x0077
            goto L_0x002e
        L_0x006d:
            r11 = move-exception
            r10 = r2
        L_0x006f:
            java.lang.String r3 = "getFileHashData NoSuchAlgorithmException"
            com.huawei.hms.framework.common.Logger.e((java.lang.String) r1, (java.lang.String) r3, (java.lang.Throwable) r11)     // Catch:{ all -> 0x0036 }
            if (r10 == 0) goto L_0x0077
            goto L_0x002e
        L_0x0077:
            return r2
        L_0x0078:
            if (r2 == 0) goto L_0x0081
            r2.close()     // Catch:{ IOException -> 0x007e }
            goto L_0x0081
        L_0x007e:
            com.huawei.hms.framework.common.Logger.e(r1, r0)
        L_0x0081:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.CreateFileUtil.getFileHashData(java.lang.String, java.lang.String):java.lang.String");
    }

    @Deprecated
    public static boolean isPVersion() {
        return EmuiUtil.isUpPVersion();
    }

    public static File newFile(String str) {
        if (str == null) {
            return null;
        }
        if (!EmuiUtil.isUpPVersion() || !ReflectionUtils.checkCompatible(EXTERNAL_FILE_NAME)) {
            return new File(str);
        }
        return new ExternalStorageFile(str);
    }

    public static FileInputStream newFileInputStream(String str) throws FileNotFoundException {
        if (str == null) {
            Logger.w(TAG, "newFileInputStream  file is null");
            throw new FileNotFoundException("file is null");
        } else if (!EmuiUtil.isUpPVersion() || !ReflectionUtils.checkCompatible(EXTERNAL_INPUTSTREAM_NAME)) {
            return new FileInputStream(str);
        } else {
            return new ExternalStorageFileInputStream(str);
        }
    }

    public static FileOutputStream newFileOutputStream(File file) throws FileNotFoundException {
        if (file == null) {
            Logger.e(TAG, "newFileOutputStream  file is null");
            throw new FileNotFoundException("file is null");
        } else if (!EmuiUtil.isUpPVersion() || !ReflectionUtils.checkCompatible(EXTERNAL_OUTPUTSTREAM_NAME)) {
            return new FileOutputStream(file);
        } else {
            return new ExternalStorageFileOutputStream(file);
        }
    }

    public static RandomAccessFile newRandomAccessFile(String str, String str2) throws FileNotFoundException {
        if (str == null) {
            Logger.w(TAG, "newFileOutputStream  file is null");
            throw new FileNotFoundException("file is null");
        } else if (!EmuiUtil.isUpPVersion() || !ReflectionUtils.checkCompatible(RANDOM_ACCESS_FILE_NAME)) {
            return new RandomAccessFile(str, str2);
        } else {
            return new ExternalStorageRandomAccessFile(str, str2);
        }
    }

    public static File newSafeFile(String str) {
        if (str == null) {
            return null;
        }
        try {
            File newFile = newFile(str);
            return !newFile.exists() ? new File(str) : newFile;
        } catch (RuntimeException unused) {
            Logger.w(TAG, "newFile is runtimeException");
            return new File(str);
        } catch (Throwable unused2) {
            Logger.w(TAG, "newFile is Throwable");
            return new File(str);
        }
    }

    public static FileInputStream newSafeFileInputStream(String str) throws FileNotFoundException {
        try {
            return newFileInputStream(str);
        } catch (FileNotFoundException unused) {
            Logger.w(TAG, "newFileInputStream is fileNotFoundException");
            return new FileInputStream(str);
        } catch (RuntimeException unused2) {
            Logger.w(TAG, "newFileInputStream is runtimeException");
            return new FileInputStream(str);
        } catch (Throwable unused3) {
            Logger.w(TAG, "newFileInputStream is Throwable");
            return new FileInputStream(str);
        }
    }

    public static FileOutputStream newSafeFileOutputStream(File file) throws FileNotFoundException {
        try {
            return newFileOutputStream(file);
        } catch (FileNotFoundException unused) {
            Logger.w(TAG, "newFileOutputStream is fileNotFoundException");
            return new FileOutputStream(file);
        } catch (RuntimeException unused2) {
            Logger.w(TAG, "newFileOutputStream is runtimeException");
            return new FileOutputStream(file);
        } catch (Throwable unused3) {
            Logger.w(TAG, "newFileOutputStream is Throwable");
            return new FileOutputStream(file);
        }
    }

    public static RandomAccessFile newSafeRandomAccessFile(String str, String str2) throws FileNotFoundException {
        if (str != null) {
            try {
                return newRandomAccessFile(str, str2);
            } catch (FileNotFoundException unused) {
                Logger.w(TAG, "newRandomAccessFile is fileNotFoundException");
                return new RandomAccessFile(str, str2);
            } catch (RuntimeException unused2) {
                Logger.w(TAG, "newRandomAccessFile is runtimeException");
                return new RandomAccessFile(str, str2);
            } catch (Throwable unused3) {
                Logger.w(TAG, "newRandomAccessFile is Throwable");
                return new RandomAccessFile(str, str2);
            }
        } else {
            Logger.w(TAG, "newRandomAccessFile  file is null");
            throw new FileNotFoundException("file is null");
        }
    }

    public static void deleteSecure(String str) {
        if (!TextUtils.isEmpty(str)) {
            deleteSecure(newFile(str));
        }
    }
}
