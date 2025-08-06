package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;
import ig.a;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class EncryptUtil {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f38637a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f38638b = true;

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.SecureRandom a() {
        /*
            java.lang.String r0 = "EncryptUtil"
            java.lang.String r1 = "generateSecureRandomNew "
            com.huawei.secure.android.common.encrypt.utils.b.b(r0, r1)
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x0012 }
            r2 = 26
            if (r1 < r2) goto L_0x0017
            java.security.SecureRandom r1 = java.security.SecureRandom.getInstanceStrong()     // Catch:{ NoSuchAlgorithmException -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            java.lang.String r1 = "getSecureRandomBytes: NoSuchAlgorithmException"
            com.huawei.secure.android.common.encrypt.utils.b.c(r0, r1)
        L_0x0017:
            r1 = 0
        L_0x0018:
            r2 = 0
            if (r1 != 0) goto L_0x0024
            java.lang.String r3 = "SHA1PRNG"
            java.security.SecureRandom r1 = java.security.SecureRandom.getInstance(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            r3 = move-exception
            goto L_0x0043
        L_0x0024:
            r3 = 1
            org.bouncycastle.crypto.engines.AESEngine r4 = new org.bouncycastle.crypto.engines.AESEngine     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            r4.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            r5 = 256(0x100, float:3.59E-43)
            r6 = 384(0x180, float:5.38E-43)
            r7 = 32
            byte[] r7 = new byte[r7]     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            r1.nextBytes(r7)     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            org.bouncycastle.crypto.prng.SP800SecureRandomBuilder r8 = new org.bouncycastle.crypto.prng.SP800SecureRandomBuilder     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            r8.<init>(r1, r3)     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            org.bouncycastle.crypto.prng.SP800SecureRandomBuilder r3 = r8.setEntropyBitsRequired(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            org.bouncycastle.crypto.prng.SP800SecureRandom r0 = r3.buildCTR(r4, r5, r7, r2)     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            return r0
        L_0x0043:
            boolean r4 = f38638b
            if (r4 == 0) goto L_0x006c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "exception : "
            r4.append(r5)
            java.lang.String r3 = r3.getMessage()
            r4.append(r3)
            java.lang.String r3 = " , you should implementation bcprov-jdk15on library"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.huawei.secure.android.common.encrypt.utils.b.c(r0, r3)
            f38638b = r2
            goto L_0x006c
        L_0x0067:
            java.lang.String r2 = "NoSuchAlgorithmException"
            com.huawei.secure.android.common.encrypt.utils.b.c(r0, r2)
        L_0x006c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.utils.EncryptUtil.a():java.security.SecureRandom");
    }

    public static byte[] b(int i11) {
        SecureRandom a11 = a();
        if (a11 == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[i11];
        a11.nextBytes(bArr);
        return bArr;
    }

    public static byte[] c(int i11) {
        if (f38637a) {
            return b(i11);
        }
        byte[] bArr = new byte[i11];
        SecureRandom secureRandom = null;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                secureRandom = SecureRandom.getInstanceStrong();
            }
        } catch (NoSuchAlgorithmException unused) {
            b.c("EncryptUtil", "getSecureRandomBytes: NoSuchAlgorithmException");
        }
        if (secureRandom == null) {
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException unused2) {
                b.c("EncryptUtil", "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                return new byte[0];
            } catch (Exception e11) {
                b.c("EncryptUtil", "getSecureRandomBytes getInstance: exception : " + e11.getMessage());
                return new byte[0];
            }
        }
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    public static String d(int i11) {
        return a.a(c(i11));
    }

    public static void e(boolean z11) {
        b.d("EncryptUtil", "setBouncycastleFlag: " + z11);
        f38637a = z11;
    }
}
