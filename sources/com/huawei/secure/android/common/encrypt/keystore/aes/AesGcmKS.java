package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.google.android.gms.stats.CodePackage;
import com.huawei.secure.android.common.encrypt.utils.b;
import ig.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class AesGcmKS {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, SecretKey> f38635a = new HashMap();

    public static SecretKey a(String str) {
        b.d("GCMKS", "load key");
        SecretKey secretKey = null;
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            Key key = instance.getKey(str, (char[]) null);
            if (key instanceof SecretKey) {
                secretKey = (SecretKey) key;
            } else {
                b.d("GCMKS", "generate key");
                KeyGenerator instance2 = KeyGenerator.getInstance(com.sumsub.sns.prooface.network.b.f40261d, "AndroidKeyStore");
                instance2.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes(new String[]{CodePackage.GCM}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).build());
                secretKey = instance2.generateKey();
            }
        } catch (KeyStoreException e11) {
            b.c("GCMKS", "KeyStoreException : " + e11.getMessage());
        } catch (IOException e12) {
            b.c("GCMKS", "IOException : " + e12.getMessage());
        } catch (CertificateException e13) {
            b.c("GCMKS", "CertificateException : " + e13.getMessage());
        } catch (NoSuchAlgorithmException e14) {
            b.c("GCMKS", "NoSuchAlgorithmException : " + e14.getMessage());
        } catch (UnrecoverableKeyException e15) {
            b.c("GCMKS", "UnrecoverableKeyException : " + e15.getMessage());
        } catch (InvalidAlgorithmParameterException e16) {
            b.c("GCMKS", "InvalidAlgorithmParameterException : " + e16.getMessage());
        } catch (NoSuchProviderException e17) {
            b.c("GCMKS", "NoSuchProviderException : " + e17.getMessage());
        } catch (Exception e18) {
            b.c("GCMKS", "Exception: " + e18.getMessage());
        }
        f38635a.put(str, secretKey);
        return secretKey;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static SecretKey c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f38635a.get(str) == null) {
            a(str);
        }
        return f38635a.get(str);
    }

    public static String d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.c("GCMKS", "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(e(str, a.b(str2)), "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            b.c("GCMKS", "decrypt: UnsupportedEncodingException : " + e11.getMessage());
            return "";
        }
    }

    public static byte[] e(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.c("GCMKS", "alias or encrypt content is null");
            return bArr2;
        } else if (!b()) {
            b.c("GCMKS", "sdk version is too low");
            return bArr2;
        } else if (bArr.length > 12) {
            return f(c(str), bArr);
        } else {
            b.c("GCMKS", "Decrypt source data is invalid.");
            return bArr2;
        }
    }

    public static byte[] f(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (secretKey == null) {
            b.c("GCMKS", "Decrypt secret key is null");
            return bArr2;
        } else if (bArr == null) {
            b.c("GCMKS", "content is null");
            return bArr2;
        } else if (!b()) {
            b.c("GCMKS", "sdk version is too low");
            return bArr2;
        } else if (bArr.length <= 12) {
            b.c("GCMKS", "Decrypt source data is invalid.");
            return bArr2;
        } else {
            byte[] copyOf = Arrays.copyOf(bArr, 12);
            try {
                Cipher instance = Cipher.getInstance(com.sumsub.sns.prooface.network.b.f40262e);
                instance.init(2, secretKey, new GCMParameterSpec(128, copyOf));
                return instance.doFinal(bArr, 12, bArr.length - 12);
            } catch (NoSuchAlgorithmException e11) {
                b.c("GCMKS", "NoSuchAlgorithmException : " + e11.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e12) {
                b.c("GCMKS", "NoSuchPaddingException : " + e12.getMessage());
                return bArr2;
            } catch (InvalidKeyException e13) {
                b.c("GCMKS", "InvalidKeyException : " + e13.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e14) {
                b.c("GCMKS", "InvalidAlgorithmParameterException : " + e14.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e15) {
                b.c("GCMKS", "IllegalBlockSizeException : " + e15.getMessage());
                return bArr2;
            } catch (BadPaddingException e16) {
                b.c("GCMKS", "BadPaddingException : " + e16.getMessage());
                return bArr2;
            } catch (Exception e17) {
                b.c("GCMKS", "Exception: " + e17.getMessage());
                return bArr2;
            }
        }
    }

    public static String g(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.c("GCMKS", "alias or encrypt content is null");
            return "";
        }
        try {
            return a.a(h(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e11) {
            b.c("GCMKS", "encrypt: UnsupportedEncodingException : " + e11.getMessage());
            return "";
        }
    }

    public static byte[] h(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.c("GCMKS", "alias or encrypt content is null");
            return bArr2;
        } else if (b()) {
            return i(c(str), bArr);
        } else {
            b.c("GCMKS", "sdk version is too low");
            return bArr2;
        }
    }

    public static byte[] i(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            b.c("GCMKS", "content is null");
            return bArr2;
        } else if (secretKey == null) {
            b.c("GCMKS", "secret key is null");
            return bArr2;
        } else if (!b()) {
            b.c("GCMKS", "sdk version is too low");
            return bArr2;
        } else {
            try {
                Cipher instance = Cipher.getInstance(com.sumsub.sns.prooface.network.b.f40262e);
                instance.init(1, secretKey);
                byte[] doFinal = instance.doFinal(bArr);
                byte[] iv2 = instance.getIV();
                if (iv2 != null) {
                    if (iv2.length == 12) {
                        byte[] copyOf = Arrays.copyOf(iv2, iv2.length + doFinal.length);
                        System.arraycopy(doFinal, 0, copyOf, iv2.length, doFinal.length);
                        return copyOf;
                    }
                }
                b.c("GCMKS", "IV is invalid.");
                return bArr2;
            } catch (NoSuchAlgorithmException e11) {
                b.c("GCMKS", "NoSuchAlgorithmException : " + e11.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e12) {
                b.c("GCMKS", "NoSuchPaddingException : " + e12.getMessage());
                return bArr2;
            } catch (BadPaddingException e13) {
                b.c("GCMKS", "BadPaddingException : " + e13.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e14) {
                b.c("GCMKS", "IllegalBlockSizeException : " + e14.getMessage());
                return bArr2;
            } catch (InvalidKeyException e15) {
                b.c("GCMKS", "InvalidKeyException : " + e15.getMessage());
                return bArr2;
            } catch (Exception e16) {
                b.c("GCMKS", "Exception: " + e16.getMessage());
                return bArr2;
            }
        }
    }
}
