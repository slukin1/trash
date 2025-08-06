package j2;

import android.content.Context;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f16009a = "0123456789abcdef".toCharArray();

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return str == null ? "" : str;
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String b(String str, String str2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "HmacSHA1");
        try {
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            return c(instance.doFinal(str2.getBytes()));
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static String c(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11] & 255;
            int i12 = i11 * 2;
            char[] cArr2 = f16009a;
            cArr[i12] = cArr2[b11 >>> 4];
            cArr[i12 + 1] = cArr2[b11 & 15];
        }
        return new String(cArr);
    }
}
