package gg;

import android.os.Build;
import com.google.android.gms.stats.CodePackage;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class b {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] c11 = EncryptUtil.c(12);
        return a(c11, c(bArr, bArr2, c11));
    }

    public static byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.c(CodePackage.GCM, "encrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            com.huawei.secure.android.common.encrypt.utils.b.c(CodePackage.GCM, "encrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.c(CodePackage.GCM, "encrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.c(CodePackage.GCM, "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        } else if (bArr3 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.c(CodePackage.GCM, "encrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 12) {
            com.huawei.secure.android.common.encrypt.utils.b.c(CodePackage.GCM, "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        } else if (!e()) {
            com.huawei.secure.android.common.encrypt.utils.b.c(CodePackage.GCM, "encrypt 6 build version not higher than 19");
            return new byte[0];
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, com.sumsub.sns.prooface.network.b.f40261d);
                Cipher instance = Cipher.getInstance(com.sumsub.sns.prooface.network.b.f40262e);
                instance.init(1, secretKeySpec, d(bArr3));
                return instance.doFinal(bArr);
            } catch (GeneralSecurityException e11) {
                com.huawei.secure.android.common.encrypt.utils.b.c(CodePackage.GCM, "GCM encrypt data error" + e11.getMessage());
                return new byte[0];
            } catch (NullPointerException e12) {
                com.huawei.secure.android.common.encrypt.utils.b.c(CodePackage.GCM, "GCM encrypt data error" + e12.getMessage());
                return new byte[0];
            }
        }
    }

    public static AlgorithmParameterSpec d(byte[] bArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return new IvParameterSpec(bArr);
        }
        return new GCMParameterSpec(128, bArr);
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 19;
    }
}
