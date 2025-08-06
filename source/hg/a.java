package hg;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40503a = "SHA";

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f40504b = {"SHA-256", "SHA-384", "SHA-512"};

    public static boolean a(String str) {
        for (String equals : f40504b) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String b(String str) {
        return c(str, "SHA-256");
    }

    public static String c(String str, String str2) {
        byte[] bArr;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.c(f40503a, "content or algorithm is null.");
            return "";
        } else if (!a(str2)) {
            b.c(f40503a, "algorithm is not safe or legal");
            return "";
        } else {
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                bArr = new byte[0];
                b.c(f40503a, "Error in generate SHA UnsupportedEncodingException");
            }
            return ig.a.a(d(bArr, str2));
        }
    }

    public static byte[] d(byte[] bArr, String str) {
        if (bArr == null || TextUtils.isEmpty(str)) {
            b.c(f40503a, "content or algorithm is null.");
            return new byte[0];
        } else if (!a(str)) {
            b.c(f40503a, "algorithm is not safe or legal");
            return new byte[0];
        } else {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                instance.update(bArr);
                return instance.digest();
            } catch (NoSuchAlgorithmException unused) {
                b.c(f40503a, "Error in generate SHA NoSuchAlgorithmException");
                return new byte[0];
            }
        }
    }
}
