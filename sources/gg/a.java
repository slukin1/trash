package gg;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import com.sumsub.sns.internal.core.common.k;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e11) {
            b.c("CBC", "get encryptword exception : " + e11.getMessage());
            return "";
        }
    }

    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e11) {
                b.c("CBC", "mix exception: " + e11.getMessage());
            }
        }
        return "";
    }

    public static byte[] c(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.c("CBC", "encrypt 5 content is null");
            return new byte[0];
        } else if (bArr == null) {
            b.c("CBC", "encrypt 5 key is null");
            return new byte[0];
        } else if (bArr.length < 16) {
            b.c("CBC", "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        } else if (bArr2 == null) {
            b.c("CBC", "encrypt 5 iv is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            b.c("CBC", "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        } else {
            try {
                return m(str.getBytes("UTF-8"), bArr, bArr2);
            } catch (UnsupportedEncodingException e11) {
                b.c("CBC", " cbc encrypt data error" + e11.getMessage());
                return new byte[0];
            }
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e11) {
            b.c("CBC", "getIv exception : " + e11.getMessage());
            return "";
        }
    }

    public static String f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            b.c("CBC", "decrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.c("CBC", "decrypt 1 key is null");
            return "";
        } else {
            byte[] b11 = ig.a.b(str2);
            if (b11.length >= 16) {
                return g(str, b11);
            }
            b.c("CBC", "decrypt 1 key error: 1 key length less than 16 bytes.");
            return "";
        }
    }

    public static String g(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            b.c("CBC", "decrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            b.c("CBC", "decrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.c("CBC", "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        } else {
            String e11 = e(str);
            String a11 = a(str);
            if (TextUtils.isEmpty(e11)) {
                b.c("CBC", "decrypt 2 iv is null");
                return "";
            } else if (!TextUtils.isEmpty(a11)) {
                return h(a11, bArr, ig.a.b(e11));
            } else {
                b.c("CBC", "decrypt 2 encrypt content is null");
                return "";
            }
        }
    }

    public static String h(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.c("CBC", "decrypt 4 content is null");
            return "";
        } else if (bArr == null) {
            b.c("CBC", "decrypt 4 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.c("CBC", "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        } else if (bArr2 == null) {
            b.c("CBC", "decrypt 4 iv is null");
            return "";
        } else if (bArr2.length < 16) {
            b.c("CBC", "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        } else {
            try {
                return new String(i(ig.a.b(str), bArr, bArr2), "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                b.c("CBC", " cbc decrypt data error" + e11.getMessage());
                return "";
            }
        }
    }

    public static byte[] i(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            b.c("CBC", "decrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            b.c("CBC", "decrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            b.c("CBC", "decrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            b.c("CBC", "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        } else if (bArr3 == null) {
            b.c("CBC", "decrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 16) {
            b.c("CBC", "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        } else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, com.sumsub.sns.prooface.network.b.f40261d);
            try {
                Cipher instance = Cipher.getInstance(k.f32093a);
                instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e11) {
                b.c("CBC", "NoSuchAlgorithmException: " + e11.getMessage());
                return new byte[0];
            } catch (NoSuchPaddingException e12) {
                b.c("CBC", "NoSuchPaddingException: " + e12.getMessage());
                return new byte[0];
            } catch (InvalidKeyException e13) {
                b.c("CBC", "InvalidKeyException: " + e13.getMessage());
                return new byte[0];
            } catch (InvalidAlgorithmParameterException e14) {
                b.c("CBC", "InvalidAlgorithmParameterException: " + e14.getMessage());
                return new byte[0];
            } catch (IllegalBlockSizeException e15) {
                b.c("CBC", "IllegalBlockSizeException: " + e15.getMessage());
                return new byte[0];
            } catch (BadPaddingException e16) {
                b.c("CBC", "BadPaddingException: " + e16.getMessage());
                b.c("CBC", "key is not right");
                return new byte[0];
            } catch (NullPointerException e17) {
                b.c("CBC", "NullPointerException: " + e17.getMessage());
                return new byte[0];
            }
        }
    }

    public static String j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            b.c("CBC", "encrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.c("CBC", "encrypt 1 key is null");
            return "";
        } else {
            byte[] b11 = ig.a.b(str2);
            if (b11.length >= 16) {
                return k(str, b11);
            }
            b.c("CBC", "encrypt 1 key error: 1 key length less than 16 bytes.");
            return "";
        }
    }

    public static String k(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            b.c("CBC", "encrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            b.c("CBC", "encrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.c("CBC", "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        } else {
            byte[] c11 = EncryptUtil.c(16);
            byte[] c12 = c(str, bArr, c11);
            if (c12 == null || c12.length == 0) {
                return "";
            }
            return b(ig.a.a(c11), ig.a.a(c12));
        }
    }

    public static byte[] l(byte[] bArr, byte[] bArr2) {
        byte[] c11 = EncryptUtil.c(16);
        return d(c11, m(bArr, bArr2, c11));
    }

    public static byte[] m(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            b.c("CBC", "encrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            b.c("CBC", "encrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            b.c("CBC", "encrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            b.c("CBC", "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        } else if (bArr3 == null) {
            b.c("CBC", "encrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 16) {
            b.c("CBC", "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        } else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, com.sumsub.sns.prooface.network.b.f40261d);
            try {
                Cipher instance = Cipher.getInstance(k.f32093a);
                instance.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e11) {
                b.c("CBC", "NoSuchAlgorithmException: " + e11.getMessage());
                return new byte[0];
            } catch (NoSuchPaddingException e12) {
                b.c("CBC", "NoSuchPaddingException: " + e12.getMessage());
                return new byte[0];
            } catch (InvalidKeyException e13) {
                b.c("CBC", "InvalidKeyException: " + e13.getMessage());
                return new byte[0];
            } catch (InvalidAlgorithmParameterException e14) {
                b.c("CBC", "InvalidAlgorithmParameterException: " + e14.getMessage());
                return new byte[0];
            } catch (IllegalBlockSizeException e15) {
                b.c("CBC", "IllegalBlockSizeException: " + e15.getMessage());
                return new byte[0];
            } catch (BadPaddingException e16) {
                b.c("CBC", "BadPaddingException: " + e16.getMessage());
                return new byte[0];
            } catch (NullPointerException e17) {
                b.c("CBC", "NullPointerException: " + e17.getMessage());
                return new byte[0];
            }
        }
    }
}
