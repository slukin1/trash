package vy;

import com.sumsub.sns.internal.core.common.k;
import com.sumsub.sns.prooface.network.b;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import uy.g;

public class a {
    public static byte[] a() throws Exception {
        return g.c(new byte[]{Framer.ENTER_FRAME_PREFIX, 83, -50, -89, -84, ISOFileInfo.CHANNEL_SECURITY, 80, 99, 10, Utf8.REPLACEMENT_BYTE, 22, -65, -11, 30, 101, ISOFileInfo.LCS_BYTE});
    }

    public static byte[] b(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            bArr[i11] = Integer.valueOf(str.substring(i12, i12 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static byte[] c() {
        try {
            byte[] b11 = b.b("IUQSvE6r1TfFPdPEjfklLw==".getBytes("UTF-8"), 2);
            if (b11 != null) {
                return g.c(b11);
            }
        } catch (Exception unused) {
        }
        return new byte[16];
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, b.f40261d);
        Cipher instance = Cipher.getInstance(k.f32093a);
        instance.init(2, secretKeySpec, new IvParameterSpec(c()));
        return instance.doFinal(bArr2);
    }

    public static String e(String str) {
        try {
            return new String(d(a(), b(str)));
        } catch (Exception unused) {
            return null;
        }
    }
}
