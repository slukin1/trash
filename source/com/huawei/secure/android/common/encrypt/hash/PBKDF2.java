package com.huawei.secure.android.common.encrypt.hash;

import android.os.Build;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public abstract class PBKDF2 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38633a = "PBKDF2";

    public static byte[] a(char[] cArr, byte[] bArr, int i11, int i12, boolean z11) {
        SecretKeyFactory secretKeyFactory;
        try {
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr, bArr, i11, i12);
            if (z11) {
                secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            } else {
                secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            }
            return secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e11) {
            String str = f38633a;
            b.c(str, "pbkdf exception : " + e11.getMessage());
            return new byte[0];
        }
    }

    public static byte[] b(char[] cArr, byte[] bArr, int i11, int i12) {
        return a(cArr, bArr, i11, i12, false);
    }

    public static byte[] c(char[] cArr, byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[0];
        if (Build.VERSION.SDK_INT >= 26) {
            return a(cArr, bArr, i11, i12, true);
        }
        b.c(f38633a, "system version not high than 26");
        return bArr2;
    }
}
