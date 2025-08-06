package com.huawei.hms.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;
import com.jumio.commons.log.LogUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public class ReadApkFileUtil {
    public static final String EMUI10_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx4nUogUyMCmzHhaEb420yvpw9zBs+ETzE9Qm77bGxl1Iml9JEkBkNTsUWOstLgUBajNhV+BAMVBHKMEdzoQbL5kIHkTgUVM65yewd+5+BhrcB9OQ3LHp+0BN6aLKZh71T4WvsvHFhfhQpShuGWkRkSaVGLFTHxX70kpWLzeZ3RtqiEUNIufPR2SFCH6EmecJ+HdkmBOh603IblCpGxwSWse0fDI98wZBEmV88RFaiYEgyiezLlWvXzqIj6I/xuyd5nGAegjH2y3cmoDE6CubecoB1jf4KdgACXgdiQ4Oc63MfLGTor3l6RCqeUk4APAMtyhK83jc72W1sdXMd/sj2wIDAQAB";
    public static final String EMUI11_PK = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAqq2eRTMYr2JHLtvuZzfgPrgU8oatD4Rar9fOD7E00es2VhtB3vTyaT2BvYPUPA/nbkHRPak3EZX77CfWj9tzLgSHJE8XLk9C+2ESkdrxCDA6z7I8X+cBDnA05OlCJeZFjnUbjYB8SP8M3BttdrvqtVPxTkEJhchC7UXnMLaJ3kQ3ZPjN7ubjYzO4rv7EtEpqr2bX+qjnSLIZZuUXraxqfdBuhGDIYq62dNsqiyrhX1mfvA3+43N4ZIs3BdfSYII8BNFmFxf+gyf1aoq386R2kAjHcrfOOhjAbZh+R1OAGLWPCqi3E9nB8EsZkeoTW/oIP6pJvgL3bnxq+1viT2dmZyipMgcx/3N6FJqkd67j/sPMtPlHJuq8/s0silzs13jAw1WBV6tWHFkLGpkWGs8jp50wQtndtY8cCPl2XPGmdPN72agH+zsHuKqr/HOB2TuzzaO8rKlGIDQlzZcCSHB28nnvOyBVN9xzLkbYiLnHfd6bTwzNPeqjWrTnPwKyH3BPAgMBAAE=";
    public static final String KEY_SIGNATURE = "Signature:";
    public static final String KEY_SIGNATURE2 = "Signature2:";
    public static final String KEY_SIGNATURE3 = "Signature3:";

    /* renamed from: a  reason: collision with root package name */
    private static final String f38615a = "ReadApkFileUtil";

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f38616b = Pattern.compile("\\s*|\t|\r|\n");

    /* renamed from: c  reason: collision with root package name */
    private static String f38617c;

    /* renamed from: d  reason: collision with root package name */
    private static String f38618d;

    /* renamed from: e  reason: collision with root package name */
    private static String f38619e;

    /* renamed from: f  reason: collision with root package name */
    private static String f38620f = null;

    /* renamed from: g  reason: collision with root package name */
    private static String f38621g = null;

    private static byte[] a(ZipFile zipFile) {
        return a(zipFile, "META-INF/MANIFEST.MF");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00c5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(byte[] r5) {
        /*
            if (r5 != 0) goto L_0x000a
            java.lang.String r5 = f38615a
            java.lang.String r0 = "manifest is null！"
            com.huawei.hms.support.log.HMSLog.e(r5, r0)
            return
        L_0x000a:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
            f38617c = r1
            f38618d = r1
            f38619e = r1
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00c5, all -> 0x00bd }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00c5, all -> 0x00bd }
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x00c5, all -> 0x00bd }
            r3.<init>(r2, r4)     // Catch:{ Exception -> 0x00c5, all -> 0x00bd }
            r5.<init>(r3)     // Catch:{ Exception -> 0x00c5, all -> 0x00bd }
            java.lang.String r1 = a((java.io.BufferedReader) r5)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
        L_0x002b:
            if (r1 == 0) goto L_0x00b2
            int r3 = r1.length()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            if (r3 == 0) goto L_0x00ac
            java.lang.String r3 = "ApkHash:"
            boolean r3 = r1.startsWith(r3)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.String r4 = ":"
            if (r3 == 0) goto L_0x004d
            int r3 = r1.indexOf(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            int r3 = r3 + 1
            java.lang.String r3 = r1.substring(r3)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.String r3 = a((java.lang.String) r3)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            f38620f = r3     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
        L_0x004d:
            java.lang.String r3 = "Signature:"
            boolean r3 = r1.startsWith(r3)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            if (r3 == 0) goto L_0x006a
            int r3 = r1.indexOf(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            int r3 = r3 + 1
            java.lang.String r1 = r1.substring(r3)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            f38617c = r1     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.String r1 = a((java.io.BufferedReader) r5)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            goto L_0x002b
        L_0x006a:
            java.lang.String r3 = "Signature2:"
            boolean r3 = r1.startsWith(r3)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            if (r3 == 0) goto L_0x0087
            int r3 = r1.indexOf(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            int r3 = r3 + 1
            java.lang.String r1 = r1.substring(r3)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            f38618d = r1     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.String r1 = a((java.io.BufferedReader) r5)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            goto L_0x002b
        L_0x0087:
            java.lang.String r3 = "Signature3:"
            boolean r3 = r1.startsWith(r3)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            if (r3 == 0) goto L_0x00a4
            int r3 = r1.indexOf(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            int r3 = r3 + 1
            java.lang.String r1 = r1.substring(r3)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            f38619e = r1     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.String r1 = a((java.io.BufferedReader) r5)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            goto L_0x002b
        L_0x00a4:
            r0.append(r1)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.String r1 = "\r\n"
            r0.append(r1)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
        L_0x00ac:
            java.lang.String r1 = a((java.io.BufferedReader) r5)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            goto L_0x002b
        L_0x00b2:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            f38621g = r0     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            goto L_0x00cd
        L_0x00b9:
            r0 = move-exception
            goto L_0x00d9
        L_0x00bb:
            r1 = r5
            goto L_0x00c5
        L_0x00bd:
            r5 = move-exception
            r0 = r5
            goto L_0x00da
        L_0x00c0:
            r5 = move-exception
            r0 = r5
            r5 = r1
            goto L_0x00d8
        L_0x00c4:
            r2 = r1
        L_0x00c5:
            java.lang.String r5 = f38615a     // Catch:{ all -> 0x00d4 }
            java.lang.String r0 = "loadApkCert Exception!"
            com.huawei.hms.support.log.HMSLog.e(r5, r0)     // Catch:{ all -> 0x00d4 }
            r5 = r1
        L_0x00cd:
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r2)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) r5)
            return
        L_0x00d4:
            r5 = move-exception
            r0 = r5
            r5 = r1
            r1 = r2
        L_0x00d8:
            r2 = r1
        L_0x00d9:
            r1 = r5
        L_0x00da:
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r2)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.utils.ReadApkFileUtil.b(byte[]):void");
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11] & 255;
            int i12 = i11 * 2;
            cArr2[i12] = cArr[b11 >>> 4];
            cArr2[i12 + 1] = cArr[b11 & 15];
        }
        return String.valueOf(cArr2);
    }

    private static boolean c() {
        try {
            if (a(Base64.decode(EMUI11_PK, 0), a(f38621g, "SHA-384"), b(f38619e), "SHA384withRSA")) {
                HMSLog.i(f38615a, "verifyMDMSignatureV3 verify successful!");
                return true;
            }
            HMSLog.i(f38615a, "verifyMDMSignatureV3 verify failure!");
            return false;
        } catch (Exception e11) {
            String str = f38615a;
            HMSLog.i(str, "verifyMDMSignatureV3 MDM verify Exception!:" + e11.getMessage());
        }
    }

    public static boolean checkSignature() {
        if (f38619e != null) {
            return c();
        }
        if (f38618d != null) {
            return b();
        }
        if (f38617c != null) {
            return a();
        }
        return false;
    }

    public static String getHmsPath(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128).sourceDir;
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.e(f38615a, "HMS is not found!");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060 A[SYNTHETIC, Splitter:B:23:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081 A[SYNTHETIC, Splitter:B:29:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isCertFound(java.lang.String r6) {
        /*
            java.lang.String r0 = "META-INF/HUAWEI.CER"
            java.lang.String r1 = "zipFile.close Exception!"
            r2 = 0
            r3 = 0
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch:{ Exception -> 0x0043 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0043 }
            java.util.zip.ZipEntry r6 = r4.getEntry(r0)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            if (r6 == 0) goto L_0x0013
            r6 = 1
            goto L_0x0014
        L_0x0013:
            r6 = r2
        L_0x0014:
            if (r6 == 0) goto L_0x001d
            byte[] r0 = a((java.util.zip.ZipFile) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            b((byte[]) r0)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
        L_0x001d:
            r4.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x003a
        L_0x0021:
            r0 = move-exception
            java.lang.String r2 = f38615a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.huawei.hms.support.log.HMSLog.e(r2, r0)
        L_0x003a:
            r2 = r6
            goto L_0x007d
        L_0x003c:
            r6 = move-exception
            goto L_0x007f
        L_0x003e:
            r6 = move-exception
            r3 = r4
            goto L_0x0044
        L_0x0041:
            r6 = move-exception
            goto L_0x007e
        L_0x0043:
            r6 = move-exception
        L_0x0044:
            java.lang.String r0 = f38615a     // Catch:{ all -> 0x0041 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            r4.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r5 = "isCertFound Exception!"
            r4.append(r5)     // Catch:{ all -> 0x0041 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0041 }
            r4.append(r6)     // Catch:{ all -> 0x0041 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0041 }
            com.huawei.hms.support.log.HMSLog.e(r0, r6)     // Catch:{ all -> 0x0041 }
            if (r3 == 0) goto L_0x007d
            r3.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x007d
        L_0x0064:
            r6 = move-exception
            java.lang.String r0 = f38615a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r6 = r6.getMessage()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            com.huawei.hms.support.log.HMSLog.e(r0, r6)
        L_0x007d:
            return r2
        L_0x007e:
            r4 = r3
        L_0x007f:
            if (r4 == 0) goto L_0x009e
            r4.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x009e
        L_0x0085:
            r0 = move-exception
            java.lang.String r2 = f38615a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.huawei.hms.support.log.HMSLog.e(r2, r0)
        L_0x009e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.utils.ReadApkFileUtil.isCertFound(java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0092 A[SYNTHETIC, Splitter:B:29:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b4 A[SYNTHETIC, Splitter:B:35:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean verifyApkHash(java.lang.String r5) {
        /*
            java.lang.String r0 = "close stream Exception!"
            r1 = 0
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ Exception -> 0x0075 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0075 }
            byte[] r5 = a((java.util.zip.ZipFile) r2)     // Catch:{ Exception -> 0x0070, all -> 0x006e }
            java.util.ArrayList r1 = a((byte[]) r5)     // Catch:{ Exception -> 0x0070, all -> 0x006e }
            if (r1 == 0) goto L_0x0016
            byte[] r5 = a((java.util.ArrayList<java.lang.String>) r1)     // Catch:{ Exception -> 0x0070, all -> 0x006e }
        L_0x0016:
            java.lang.String r1 = "SHA-256"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ Exception -> 0x0070, all -> 0x006e }
            r1.update(r5)     // Catch:{ Exception -> 0x0070, all -> 0x006e }
            byte[] r5 = r1.digest()     // Catch:{ Exception -> 0x0070, all -> 0x006e }
            java.lang.String r5 = bytesToString(r5)     // Catch:{ Exception -> 0x0070, all -> 0x006e }
            java.lang.String r1 = f38620f     // Catch:{ Exception -> 0x0070, all -> 0x006e }
            if (r1 == 0) goto L_0x0050
            boolean r5 = r1.equals(r5)     // Catch:{ Exception -> 0x0070, all -> 0x006e }
            if (r5 == 0) goto L_0x0050
            r5 = 1
            r2.close()     // Catch:{ Exception -> 0x0036 }
            goto L_0x004f
        L_0x0036:
            r1 = move-exception
            java.lang.String r2 = f38615a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = r1.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.huawei.hms.support.log.HMSLog.i(r2, r0)
        L_0x004f:
            return r5
        L_0x0050:
            r2.close()     // Catch:{ Exception -> 0x0054 }
            goto L_0x00af
        L_0x0054:
            r5 = move-exception
            java.lang.String r1 = f38615a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r5 = r5.getMessage()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            com.huawei.hms.support.log.HMSLog.i(r1, r5)
            goto L_0x00af
        L_0x006e:
            r5 = move-exception
            goto L_0x00b2
        L_0x0070:
            r5 = move-exception
            r1 = r2
            goto L_0x0076
        L_0x0073:
            r5 = move-exception
            goto L_0x00b1
        L_0x0075:
            r5 = move-exception
        L_0x0076:
            java.lang.String r2 = f38615a     // Catch:{ all -> 0x0073 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r3.<init>()     // Catch:{ all -> 0x0073 }
            java.lang.String r4 = "verifyApkHash Exception!"
            r3.append(r4)     // Catch:{ all -> 0x0073 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0073 }
            r3.append(r5)     // Catch:{ all -> 0x0073 }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x0073 }
            com.huawei.hms.support.log.HMSLog.i(r2, r5)     // Catch:{ all -> 0x0073 }
            if (r1 == 0) goto L_0x00af
            r1.close()     // Catch:{ Exception -> 0x0096 }
            goto L_0x00af
        L_0x0096:
            r5 = move-exception
            java.lang.String r1 = f38615a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r5 = r5.getMessage()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            com.huawei.hms.support.log.HMSLog.i(r1, r5)
        L_0x00af:
            r5 = 0
            return r5
        L_0x00b1:
            r2 = r1
        L_0x00b2:
            if (r2 == 0) goto L_0x00d1
            r2.close()     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00d1
        L_0x00b8:
            r1 = move-exception
            java.lang.String r2 = f38615a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = r1.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.huawei.hms.support.log.HMSLog.i(r2, r0)
        L_0x00d1:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.utils.ReadApkFileUtil.verifyApkHash(java.lang.String):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] a(java.util.zip.ZipFile r7, java.lang.String r8) {
        /*
            java.util.zip.ZipEntry r8 = r7.getEntry(r8)
            r0 = 0
            if (r8 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.InputStream r7 = r7.getInputStream(r8)     // Catch:{ Exception -> 0x006f, all -> 0x0068 }
            if (r7 != 0) goto L_0x001b
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r7)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r0)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) r0)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) r0)
            return r0
        L_0x001b:
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0065, all -> 0x0063 }
            r8.<init>(r7)     // Catch:{ Exception -> 0x0065, all -> 0x0063 }
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r1]     // Catch:{ Exception -> 0x0060, all -> 0x005c }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0060, all -> 0x005c }
            r3.<init>()     // Catch:{ Exception -> 0x0060, all -> 0x005c }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            r5 = 0
            int r6 = r8.read(r2, r5, r1)     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
        L_0x0033:
            if (r6 <= 0) goto L_0x003d
            r4.write(r2, r5, r6)     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            int r6 = r8.read(r2, r5, r1)     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            goto L_0x0033
        L_0x003d:
            r4.flush()     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            byte[] r0 = r3.toByteArray()     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r7)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r8)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) r3)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) r4)
            return r0
        L_0x0051:
            r0 = move-exception
            r1 = r0
            goto L_0x00a0
        L_0x0055:
            r1 = move-exception
            goto L_0x0075
        L_0x0057:
            r1 = move-exception
            goto L_0x00a1
        L_0x0059:
            r1 = move-exception
            r4 = r0
            goto L_0x0075
        L_0x005c:
            r1 = move-exception
            r3 = r0
            r4 = r3
            goto L_0x009e
        L_0x0060:
            r1 = move-exception
            r3 = r0
            goto L_0x0074
        L_0x0063:
            r8 = move-exception
            goto L_0x006b
        L_0x0065:
            r8 = move-exception
            r1 = r8
            goto L_0x0072
        L_0x0068:
            r7 = move-exception
            r8 = r7
            r7 = r0
        L_0x006b:
            r1 = r8
            r8 = r0
            r3 = r8
            goto L_0x00a1
        L_0x006f:
            r7 = move-exception
            r1 = r7
            r7 = r0
        L_0x0072:
            r8 = r0
            r3 = r8
        L_0x0074:
            r4 = r3
        L_0x0075:
            java.lang.String r2 = f38615a     // Catch:{ all -> 0x009c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x009c }
            r5.<init>()     // Catch:{ all -> 0x009c }
            java.lang.String r6 = "getManifestBytes Exception!"
            r5.append(r6)     // Catch:{ all -> 0x009c }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x009c }
            r5.append(r1)     // Catch:{ all -> 0x009c }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x009c }
            com.huawei.hms.support.log.HMSLog.i(r2, r1)     // Catch:{ all -> 0x009c }
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r7)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r8)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) r3)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) r4)
            return r0
        L_0x009c:
            r0 = move-exception
            r1 = r0
        L_0x009e:
            r0 = r8
            r8 = r0
        L_0x00a0:
            r0 = r4
        L_0x00a1:
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r7)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r8)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) r3)
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.utils.ReadApkFileUtil.a(java.util.zip.ZipFile, java.lang.String):byte[]");
    }

    @TargetApi(19)
    private static ArrayList<String> a(byte[] bArr) {
        BufferedReader bufferedReader;
        if (bArr == null) {
            HMSLog.e(f38615a, "manifest is null！");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                if (!a(bufferedReader, arrayList)) {
                    bufferedReader.close();
                    byteArrayInputStream.close();
                    return null;
                }
                bufferedReader.close();
                byteArrayInputStream.close();
                return arrayList;
            } catch (Throwable th2) {
                byteArrayInputStream.close();
                throw th2;
            }
        } catch (IOException unused) {
            HMSLog.e(f38615a, "getManifestLinesArrary IOException!");
            return null;
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
        throw th;
    }

    private static boolean b() {
        try {
            if (a(Base64.decode(EMUI10_PK, 0), a(f38621g, "SHA-256"), b(f38618d), "SHA256withRSA")) {
                HMSLog.i(f38615a, "verifyMDMSignatureV2 verify successful!");
                return true;
            }
            HMSLog.i(f38615a, "verifyMDMSignatureV2 verify failure!");
            return false;
        } catch (Exception e11) {
            String str = f38615a;
            HMSLog.i(str, "verifyMDMSignatureV2 MDM verify Exception!:" + e11.getMessage());
        }
    }

    @TargetApi(19)
    private static byte[] a(ArrayList<String> arrayList) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8));
        try {
            Collections.sort(arrayList);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                String str = arrayList.get(i11);
                bufferedWriter.write(str, 0, str.length());
                bufferedWriter.write(LogUtils.NEW_LINE, 0, 2);
            }
            bufferedWriter.flush();
        } catch (Exception e11) {
            HMSLog.i(f38615a, "getManifestBytesbySorted Exception!" + e11.getMessage());
        } catch (Throwable th2) {
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            throw th2;
        }
        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
        IOUtils.closeQuietly((Writer) bufferedWriter);
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] b(String str) {
        int i11;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 == 0) {
            i11 = length / 2;
        } else {
            i11 = (length / 2) + 1;
        }
        byte[] bArr = new byte[i11];
        for (int i12 = 0; i12 < length; i12 += 2) {
            int i13 = i12 + 1;
            if (i13 < length) {
                bArr[i12 / 2] = (byte) ((Character.digit(str.charAt(i12), 16) << 4) + Character.digit(str.charAt(i13), 16));
            } else {
                bArr[i12 / 2] = (byte) (Character.digit(str.charAt(i12), 16) << 4);
            }
        }
        return bArr;
    }

    private static boolean a(BufferedReader bufferedReader, ArrayList<String> arrayList) throws IOException {
        String a11 = a(bufferedReader);
        boolean z11 = false;
        while (a11 != null) {
            if (a11.equals("Name: META-INF/HUAWEI.CER")) {
                z11 = true;
                String a12 = a(bufferedReader);
                while (true) {
                    if (a12 == null) {
                        break;
                    } else if (a12.startsWith("Name:")) {
                        a11 = a12;
                        break;
                    } else {
                        a12 = a(bufferedReader);
                    }
                }
            }
            if (a11.length() != 0) {
                arrayList.add(a11);
            }
            a11 = a(bufferedReader);
        }
        return z11;
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        int read;
        if (bufferedReader == null || (read = bufferedReader.read()) == -1) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(10);
        while (read != -1) {
            char c11 = (char) read;
            if (c11 == 10) {
                break;
            } else if (sb2.length() < 4096) {
                sb2.append(c11);
                read = bufferedReader.read();
            } else {
                throw new IOException("cert line is too long!");
            }
        }
        String sb3 = sb2.toString();
        return (sb3.isEmpty() || !sb3.endsWith("\r")) ? sb3 : sb3.substring(0, sb3.length() - 1);
    }

    private static boolean a() {
        try {
            if (a(b("30820122300d06092a864886f70d01010105000382010f003082010a0282010100a3d269348ac59923f65e8111c337605e29a1d1bc54fa96c1445050dd14d8d63b10f9f0230bb87ef348183660bedcabfdec045e235ed96935799fcdb4af5c97717ff3b0954eaf1b723225b3a00f81cbd67ce6dc5a4c07f7741ad3bf1913a480c6e267ab1740f409edd2dc33c8b718a8e30e56d9a93f321723c1d0c9ea62115f996812ceef186954595e39a19b74245542c407f7dddb1d12e6eedcfc0bd7cd945ef7255ad0fc9e796258e0fb5e52a23013d15033a32b4071b65f3f924ae5c5761e22327b4d2ae60f4158a5eb15565ba079de29b81540f5fbb3be101a95357f367fc661d797074ff3826950029c52223e4594673a24a334cae62d63b838ba3df9770203010001"), a(f38621g, "SHA-256"), b(f38617c), "SHA256withRSA")) {
                HMSLog.i(f38615a, "verifyMDMSignatureV1 verify successful!");
                return true;
            }
            HMSLog.i(f38615a, "verifyMDMSignatureV1 verify failure!");
            return false;
        } catch (Exception e11) {
            String str = f38615a;
            HMSLog.i(str, "verifyMDMSignatureV1 MDM verify Exception!:" + e11.getMessage());
            return false;
        }
    }

    private static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws Exception {
        Signature instance = Signature.getInstance(str);
        instance.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)));
        instance.update(bArr2);
        return instance.verify(bArr3);
    }

    @TargetApi(19)
    private static byte[] a(String str, String str2) throws Exception {
        MessageDigest instance = MessageDigest.getInstance(str2);
        instance.update(str.getBytes(StandardCharsets.UTF_8.name()));
        return instance.digest();
    }

    private static String a(String str) {
        if (str != null) {
            return f38616b.matcher(str).replaceAll("");
        }
        return "";
    }
}
